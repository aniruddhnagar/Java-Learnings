package CompletableFuture;

import java.util.concurrent.ArrayBlockingQueue;
import java.util.concurrent.CompletableFuture;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.Executors;
import java.util.concurrent.ThreadPoolExecutor;
import java.util.concurrent.TimeUnit;

//Chaining Operations: You can chain multiple asynchronous operations seamlessly.
    //thenApply(): Executes a function when the previous stage completes.
    //thenAccept(): Consumes the result (no return value).
    //thenRun(): Executes a simple action (no input or output).

//Combining Futures: You can combine the results of multiple independent futures.
    //thenCombine(): Combines two results when both are ready.
    //allOf(): Waits for all provided futures to complete.
    //anyOf(): Completes as soon as any one future is finished.

public class Main {

    public static void main(String[] args) throws ExecutionException, InterruptedException {

        ThreadPoolExecutor poolExecutor = new ThreadPoolExecutor(1, 1, 1, TimeUnit.HOURS,
                new ArrayBlockingQueue<>(3), Executors.defaultThreadFactory(), new ThreadPoolExecutor.DiscardPolicy());

        // new thread will be created for all async operations
        // It provides chaining, it provides a method to be applied on the results by same thread:
        CompletableFuture<String> futureObj = CompletableFuture.supplyAsync( () -> {
            try {
                Thread.sleep(3000);
            } catch (InterruptedException e) {
                throw new RuntimeException(e);
            }
            return "name: " + Thread.currentThread().getName();
        }, poolExecutor);

        System.out.println(futureObj.get());

        // -------------------------------------------------------------------------------------------------------------
        // It provides chaining, it provides a method to be applied on the results by same thread:
        CompletableFuture<String> futureObj2 = CompletableFuture.supplyAsync( () -> {
            try {
                Thread.sleep(3000);
            } catch (InterruptedException e) {
                throw new RuntimeException(e);
            }
            return "name: " + Thread.currentThread().getName();
        }, poolExecutor);

        futureObj2 = futureObj2.thenApplyAsync((String val) -> {
            return val + " - Extra - "  + Thread.currentThread().getName();
        }, poolExecutor);

        // Chain together dependent Async operation:
//        futureObj2 = futureObj2.thenCompose((String val) -> {
//            return CompletableFuture.supplyAsync(() -> val + " - Completable - "  + Thread.currentThread().getName());});

        futureObj2 = futureObj2.thenComposeAsync((String val) -> {
            return CompletableFuture.supplyAsync(() -> val + " - Completable - "  + Thread.currentThread().getName());}
        , poolExecutor);


        // will not return anything
        futureObj2.thenAcceptAsync((String val) -> {
            System.out.println( val + " - Completable2 - "  + Thread.currentThread().getName());});

        System.out.println(futureObj2.get());


        poolExecutor.shutdown();
    }

}
