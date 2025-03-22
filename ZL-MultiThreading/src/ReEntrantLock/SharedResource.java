package ReEntrantLock;

import java.util.concurrent.locks.ReentrantLock;

public class SharedResource {

    ReentrantLock lock;

    SharedResource(ReentrantLock lock) {
        this.lock = lock;
    }

    public void doTask() throws InterruptedException {
        lock.lock();
        System.out.println("Locking by: " + Thread.currentThread().getName());
        try {
            Thread.sleep(4000);
        } finally {
            System.out.println("Releasing by: " + Thread.currentThread().getName());
            lock.unlock();
        }
    }
}
