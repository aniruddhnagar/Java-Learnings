package StampedLock;

import java.util.concurrent.locks.ReadWriteLock;
import java.util.concurrent.locks.StampedLock;

public class SharedResource {

    StampedLock lock;

    SharedResource(StampedLock lock) {
        this.lock = lock;
    }

    public void producer() throws InterruptedException {
        long stamp = lock.tryOptimisticRead();
        System.out.println("R-Locking by: " + Thread.currentThread().getName());
        int a = 10;
        Thread.sleep(5000);
        if (lock.validate(stamp)) {
            a = 20;
        }
        System.out.println("Value of a: " + a);
    }

    public void consumer() throws InterruptedException {
        long stamp = lock.writeLock();
        try {
            System.out.println("W-Locking by: " + Thread.currentThread().getName());
            Thread.sleep(5000);
        } finally {
            System.out.println("W-Unlocking by: " + Thread.currentThread().getName());
            lock.unlockWrite(stamp);
        }
    }

}
