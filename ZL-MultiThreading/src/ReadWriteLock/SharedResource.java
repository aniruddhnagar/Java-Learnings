package ReadWriteLock;

import java.util.concurrent.locks.ReadWriteLock;

public class SharedResource {

    ReadWriteLock lock;

    SharedResource(ReadWriteLock lock) {
        this.lock = lock;
    }

    public void producer() throws InterruptedException {
        lock.readLock().lock();
        System.out.println("R-Locking by: " + Thread.currentThread().getName());
        Thread.sleep(5000);
        System.out.println("R-Unlocking by: " + Thread.currentThread().getName());
        lock.readLock().unlock();
    }

    public void consumer() throws InterruptedException {
        lock.writeLock().lock();
        System.out.println("W-Locking by: " + Thread.currentThread().getName());
        Thread.sleep(5000);
        System.out.println("W-Unlocking by: " + Thread.currentThread().getName());
        lock.writeLock().unlock();
    }

}
