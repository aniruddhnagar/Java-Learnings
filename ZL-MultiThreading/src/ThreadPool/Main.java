package ThreadPool;

import java.math.BigInteger;
import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.ArrayBlockingQueue;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.ExecutorService;
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

        ThreadPoolExecutor poolExecutor4 = new ThreadPoolExecutor(1, 1, 1, TimeUnit.HOURS,
        new ArrayBlockingQueue<>(3), Executors.defaultThreadFactory(), new ThreadPoolExecutor.DiscardPolicy());

        List<Integer> output = new ArrayList<>();
        Future<List<Integer>> futureObj4 = poolExecutor4.submit(new MyTask(output), output);

        try {
            System.out.println(futureObj4.get());
        } catch (Exception e) {
        }

        poolExecutor4.shutdown();

        // -------------------------------------------------------------------------------------------------------------
        // Use of Callable thread:
        // Other usecase:

        // Create an ExecutorService with a fixed thread pool size of 1
        ExecutorService executor = Executors.newFixedThreadPool(1);
        System.out.println("Main thread started.");

        // Instantiate the Callable task
        FactorialTask task = new FactorialTask(20);

        // 3. Submit the Callable task to the executor
        //    The submit() method immediately returns a Future object.
        Future<BigInteger> futureResult = executor.submit(task);

        // 4. The Main thread continues its own work while the task runs asynchronously
        System.out.println("Main thread can do other things while calculation runs...");
        System.out.println("Checking task status: Is done? " + futureResult.isDone());

        // 5. Retrieve the result using Future.get()
        //    This call BLOCKS the main thread until the computation is complete.
        System.out.println("\nWaiting for the result using future.get()...");
        BigInteger factorial = futureResult.get();

        // Execution reaches here only after the worker thread finishes
        System.out.println("--- Main thread got the result ---");
        System.out.println("Factorial of 20 is: " + factorial);
        System.out.println("Checking task status again: Is done? " + futureResult.isDone());

        // Clean up the executor service
        executor.shutdown();
    }
}

