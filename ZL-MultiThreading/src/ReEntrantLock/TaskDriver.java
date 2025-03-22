package ReEntrantLock;

import java.util.concurrent.locks.ReentrantLock;

public class TaskDriver implements Runnable{

    SharedResource obj;
    ReentrantLock lock;

    TaskDriver(ReentrantLock lock) {
        this.lock = lock;
        this.obj = new SharedResource(lock);
    }

    @Override
    public void run() {
        try {
            obj.doTask();
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }
    }
}
