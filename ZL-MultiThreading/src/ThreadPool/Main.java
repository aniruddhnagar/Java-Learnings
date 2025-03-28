package ThreadPool;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.ArrayBlockingQueue;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.Executors;
import java.util.concurrent.Future;
import java.util.concurrent.ThreadPoolExecutor;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.TimeoutException;

public class Main {

    public static void main(String[] args) throws ExecutionException, InterruptedException, TimeoutException {

        ThreadPoolExecutor poolExecutor1 = new ThreadPoolExecutor(2, 3, 30,
                TimeUnit.MINUTES, new ArrayBlockingQueue<>(3), Executors.defaultThreadFactory(),
                new ThreadPoolExecutor.DiscardPolicy());

        poolExecutor1.allowCoreThreadTimeOut(true);

        for (int i=0; i<8; i++) {
            poolExecutor1.submit( () -> {
                System.out.println("name: " + Thread.currentThread().getName());
                try {
                    Thread.sleep(3000);
                } catch (InterruptedException e) {
                    throw new RuntimeException(e);
                }
            });
        }
        poolExecutor1.shutdown();

        // -------------------------------------------------------------------------------------------------------------
        // Use of Future to store Status/Results/Exception from thread:
        // Use of Runnable thread:
        ThreadPoolExecutor poolExecutor2 = new ThreadPoolExecutor(1, 1, 1,
                TimeUnit.HOURS, new ArrayBlockingQueue<>(3), Executors.defaultThreadFactory(),
                new ThreadPoolExecutor.AbortPolicy());

        Future<?> futureObj = poolExecutor2.submit( () -> {
                    System.out.println("name: " + Thread.currentThread().getName());
                    try {
                        Thread.sleep(7000);
                    } catch (InterruptedException e) {
                        throw new RuntimeException(e);
                    }
                });

        System.out.println("Is Done: " + futureObj.isDone());

        try {
            futureObj.get(2, TimeUnit.SECONDS);
        } catch (TimeoutException e) {
            System.out.println("Time out happened.");;
        }

        try {
            futureObj.get();
        } catch (Exception e) {
        }

        System.out.println("Is Done: " + futureObj.isDone());
        System.out.println("Is Cancelled: " + futureObj.isCancelled());

        poolExecutor2.shutdown();

        // -------------------------------------------------------------------------------------------------------------
        // Use of Callable thread:

        ThreadPoolExecutor poolExecutor3 = new ThreadPoolExecutor(1, 1, 1, TimeUnit.HOURS,
                new ArrayBlockingQueue<>(3), Executors.defaultThreadFactory(), new ThreadPoolExecutor.DiscardPolicy());

        Future<String> futureObj2 = poolExecutor3.submit( () -> {
            try {
                Thread.sleep(7000);
            } catch (InterruptedException e) {
                throw new RuntimeException(e);
            }
            return "name: " + Thread.currentThread().getName();
        });

        try {
            Object outObj = futureObj2.get();
            System.out.println(outObj == null);
        } catch (Exception e) {
        }
            poolExecutor3.shutdown();

        // -------------------------------------------------------------------------------------------------------------
        // Use of Callable thread:
        // Other usecase:

        ThreadPoolExecutor poolExecutor4 = new ThreadPoolExecutor(1, 1, 1, TimeUnit.HOURS,
        new ArrayBlockingQueue<>(3), Executors.defaultThreadFactory(), new ThreadPoolExecutor.DiscardPolicy());

        List<Integer> output = new ArrayList<>();
        Future<List<Integer>> futureObj4 = poolExecutor4.submit(new MyTask(output), output);

        try {
            System.out.println((futureObj4.get()).getFirst());
        } catch (Exception e) {
        }

        poolExecutor4.shutdown();
    }
}

