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

        System.out.println("[Main] Starting travel booking process...");

        // Start the asynchronous chain
        CompletableFuture<Void> pipeline = CompletableFuture.supplyAsync(() -> {
                    System.out.println("[Task 1] Fetching flight price...");
                    simulateDelay(1500); // Simulate network latency

                    // UNCOMMENT the line below to test the error handling:
                    // if (true) throw new RuntimeException("Database Connection Timeout!");

                    return 500.0;
                })
                /*
                 * .handle() is better than .exceptionally() because it processes
                 * BOTH the result (res) and the error (ex) in one step.
                 */
                .handle((res, ex) -> {
                    if (ex != null) {
                        System.err.println("[Error] Could not fetch price: " + ex.getMessage());
                        return 0.0; // Return a 'fallback' default value
                    }
                    return res; // Pass the successful result forward
                })
                .thenApply(price -> {
                    if (price == 0.0) return 0.0; // Skip discount if error occurred
                    System.out.println("[Task 2] Applying 10% discount to: $" + price);
                    return price * 0.9;
                })
                .thenAccept(finalPrice -> {
                    if (finalPrice > 0) {
                        System.out.println("[Success] Booking confirmed for: $" + finalPrice);
                    } else {
                        System.out.println("[Fail] Booking could not be completed.");
                    }
                });

        // The main thread is NOT blocked. It continues while the future runs.
        System.out.println("[Main] I'm free to do other work while the booking happens!");

        for(int i = 1; i <= 3; i++) {
            System.out.println("[Main] Doing unrelated task #" + i + "...");
            simulateDelay(500);
        }

        // join() ensures the program doesn't exit before the background tasks finish
        pipeline.join();

        System.out.println("[Main] Program finished.");
    }

    private static void simulateDelay(int ms) {
        try { TimeUnit.MILLISECONDS.sleep(ms); } catch (InterruptedException e) {
            Thread.currentThread().interrupt();
        }
    }

}
