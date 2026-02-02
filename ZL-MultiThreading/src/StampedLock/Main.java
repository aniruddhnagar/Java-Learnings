package StampedLock;

import java.util.concurrent.locks.StampedLock;

//    A StampedLock (introduced in Java 8) is an advanced, high-performance alternative to the ReadWriteLock.
//    It is designed specifically for read-heavy scenarios and provides a unique "Optimistic Reading" mode
//    that can be significantly faster than traditional locks.
//
//    The Three Locking Modes:
//    Unlike other locks, a StampedLock returns a long value called a stamp. You must provide this exact stamp to release the lock.
//
//    Writing Mode: An exclusive lock. Only one thread can hold it, blocking all other readers and writers.
//    Reading Mode: A pessimistic, shared lock. Multiple threads can read, but they block any writer from starting.
//    Optimistic Reading: A non-blocking mode where the thread doesn't actually "lock" anything. It reads the data and then calls validate(stamp) to check if a writer modified the data during the read.

public class Main {

    public static void main(String[] args) {

        StampedLock lock = new StampedLock();
        SharedResource obj1 = new SharedResource(lock);
        SharedResource obj2 = new SharedResource(lock);
        SharedResource obj3 = new SharedResource(lock);

        Thread thread1 = new Thread(() -> {
            try {
                obj1.producer();
            } catch (InterruptedException e) {
                throw new RuntimeException(e);
            }
        } );

        Thread thread2 = new Thread(() -> {
            try {
                obj2.producer();
            } catch (InterruptedException e) {
                throw new RuntimeException(e);
            }
        });

        Thread thread3 = new Thread(() -> {
            try {
                obj3.consumer();
            } catch (InterruptedException e) {
                throw new RuntimeException(e);
            }
        });

        thread1.start();
        thread2.start();
        thread3.start();
    }
}
