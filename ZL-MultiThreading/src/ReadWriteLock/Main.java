package ReadWriteLock;

import java.util.concurrent.locks.ReadWriteLock;
import java.util.concurrent.locks.ReentrantReadWriteLock;

public class Main {

    public static void main(String[] args) throws InterruptedException {

        ReadWriteLock lock = new ReentrantReadWriteLock();
        SharedResource obj1 = new SharedResource(lock);

        Thread thread5 = new Thread(() -> {
            try {
                obj1.producer();
            } catch (InterruptedException e) {
                throw new RuntimeException(e);
            }
        } );

        thread5.start();

    }
}
