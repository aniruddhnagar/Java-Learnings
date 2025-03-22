package SemaphoreLock;

import java.util.concurrent.Semaphore;

public class SharedResource {

    Semaphore lock;

    SharedResource(Semaphore lock) {
        this.lock = lock;
    }

    public void producer() throws InterruptedException {
        lock.acquire();
        System.out.println("Locking by: " + Thread.currentThread().getName());
        int a = 10;
        Thread.sleep(4000);
        System.out.println("Unocking by: " + Thread.currentThread().getName());
        lock.release();
    }

}
