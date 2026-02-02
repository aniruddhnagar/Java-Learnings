package ReEntrantLock;

import java.util.concurrent.locks.ReentrantLock;

public class Main {

    public static void main(String[] args) throws InterruptedException {

        // Create ONE single instance of the shared resource
        CorrectedLockingExample.SharedCounter counter = new CorrectedLockingExample.SharedCounter();

        // Create multiple threads that all operate on the SAME 'counter' instance
        Thread thread1 = new Thread(counter::increment, "Thread-1");
        Thread thread2 = new Thread(counter::increment, "Thread-2");
        Thread thread3 = new Thread(counter::increment, "Thread-3");
        Thread thread4 = new Thread(counter::increment, "Thread-4");

        thread1.start();
        thread2.start();
        thread3.start();
        thread4.start();

        // Wait for all threads to finish for demo purposes
        thread1.join();
        thread2.join();
        thread3.join();
        thread4.join();

        System.out.println("\nFinal count value: " + counter.count);

        ReentrantLock lock = new ReentrantLock();

        TaskDriver obj1 = new TaskDriver(lock);
        TaskDriver obj2 = new TaskDriver(lock);

        Thread tread1 = new Thread(obj1);
        Thread tread2 = new Thread(obj2);

        tread1.start();
        tread2.start();
    }
}
