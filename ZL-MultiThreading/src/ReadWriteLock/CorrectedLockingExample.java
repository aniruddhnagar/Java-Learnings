package ReadWriteLock;

import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

public class CorrectedLockingExample {

    // --- The Shared Resource (Data and the Lock guarding it) ---
    public static class SharedCounter {

        int count = 0;
        // The lock instance is shared by all threads that access the count
        private final Lock lock = new ReentrantLock();

        public void increment() {
            // ACQUIRE THE LOCK
            lock.lock();
            try {
                // Critical section: Only one thread can be here at a time
                count++;
                System.out.println(Thread.currentThread().getName() + " incremented count to: " + count);
            } finally {
                // RELEASE THE LOCK (Crucial to do this in a finally block)
                lock.unlock();
            }
        }
    }
}