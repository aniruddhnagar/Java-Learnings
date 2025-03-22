package ReEntrantLock;

import java.util.concurrent.locks.ReentrantLock;

public class Main {

    public static void main(String[] args) {

        ReentrantLock lock = new ReentrantLock();

        TaskDriver obj1 = new TaskDriver(lock);
        TaskDriver obj2 = new TaskDriver(lock);

        Thread tread1 = new Thread(obj1);
        Thread tread2 = new Thread(obj2);

        tread1.start();
        tread2.start();
    }
}
