package SemaphoreLock;

import java.util.concurrent.Semaphore;

//    In Java, a Semaphore is a synchronization tool that maintains a set of permits.
//    It is used to control how many threads can access a specific resource simultaneously.
//    acquire(): Decrements the number of available permits. If no permits are available, the thread blocks (waits).
//    release(): Increments the number of permits, potentially unblocking a waiting thread.

//    A Mutex is a locking mechanism for exclusive access,
//    whereas a Semaphore is a signaling mechanism for managing multiple resource instances.

public class Main {

    public static void main(String[] args) {

        Semaphore lock = new Semaphore(2);
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
                obj3.producer();
            } catch (InterruptedException e) {
                throw new RuntimeException(e);
            }
        });

        thread1.start();
        thread2.start();
        thread3.start();
    }
}
