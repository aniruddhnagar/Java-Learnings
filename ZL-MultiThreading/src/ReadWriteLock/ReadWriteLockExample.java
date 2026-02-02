package ReadWriteLock;

import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReadWriteLock;
import java.util.concurrent.locks.ReentrantReadWriteLock;

public class ReadWriteLockExample {

    static class SharedData {
        private int count = 0;

        // The ReentrantReadWriteLock manages access
        private final ReadWriteLock rwLock = new ReentrantReadWriteLock();
        // Specific Lock objects derived from the main RWL
        private final Lock readLock = rwLock.readLock();
        private final Lock writeLock = rwLock.writeLock();

        // Method for reading the data (Many threads can execute this concurrently)
        public int readCount() {
            readLock.lock(); // Acquire the read lock
            try {
                // System.out.println(Thread.currentThread().getName() + " is READING.");
                // Simulate a small delay for reading
                Thread.sleep(10);
                return count;
            } catch (InterruptedException e) {
                Thread.currentThread().interrupt();
                return count;
            } finally {
                readLock.unlock(); // Release the read lock
            }
        }

        // Method for writing the data (Only one thread can execute this at a time)
        public void incrementCount() {
            writeLock.lock(); // Acquire the write lock (blocks all other readers/writers)
            try {
                int oldValue = count;
                count++;
                System.out.println(Thread.currentThread().getName() + " WROTE (incremented from " + oldValue + " to " + count + ").");
            } finally {
                writeLock.unlock(); // Release the write lock
            }
        }
    }
}