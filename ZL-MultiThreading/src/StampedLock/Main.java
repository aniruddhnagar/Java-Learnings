package StampedLock;

import java.util.concurrent.locks.StampedLock;

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
