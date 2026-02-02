package ReEntrantLock;

import java.util.concurrent.locks.ReentrantLock;

//1. What does "Reentrant" mean?
//    It means that if a thread already holds the lock, it can re-acquire it multiple times without getting stuck (deadlocked).
//    The lock keeps a hold count—each time the thread locks it, the count goes up; each unlock decrements it.
//    The resource is only freed when the count hits zero.
//
//2. Why use it over synchronized?
//    While synchronized is simple, ReentrantLock offers features for complex scenarios:
//    Fairness Policy: You can force the lock to give access to the thread that has been waiting the longest.
//    tryLock(): A thread can check if the lock is available. If it’s not, the thread can do something else instead of blocking indefinitely.
//    Interruptible Locks: You can allow a waiting thread to be interrupted while it's waiting for the lock.

public class Main {

    public static void main(String[] args) throws InterruptedException {

        // Create ONE single instance of the shared resource
        ReenterantLockExample.SharedCounter counter = new ReenterantLockExample.SharedCounter();

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

    }
}
