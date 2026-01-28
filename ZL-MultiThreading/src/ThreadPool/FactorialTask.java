package ThreadPool;

import java.util.concurrent.*;
import java.math.BigInteger;

// 1. Define a task that implements Callable<V>
//    In this case, it will return a BigInteger result.
class FactorialTask implements Callable<BigInteger> {

    private final int number;

    public FactorialTask(int number) {
        this.number = number;
    }

    // The call() method contains the long-running logic.
    @Override
    public BigInteger call() throws Exception {
        BigInteger result = BigInteger.ONE;
        if (number < 0) {
            throw new IllegalArgumentException("Number must be non-negative");
        }

        for (int i = 1; i <= number; i++) {
            result = result.multiply(BigInteger.valueOf(i));
            // Simulate some work being done
            Thread.sleep(10);
        }
        System.out.println("--- Calculation for " + number + "! finished by worker thread ---");
        return result;
    }
}
