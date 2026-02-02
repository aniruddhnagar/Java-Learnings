package MonitorLock;

// In Java, a Monitor Lock (also called an Intrinsic Lock) is the fundamental mechanism
// that ensures only one thread can execute a specific block of code at a time,
// preventing data corruption.

public class Main {

    public static void main(String[] args) {

        SharedResource obj = new SharedResource();

        Producer pObj = new Producer(obj);
        Consumer cObj = new Consumer(obj);

        Thread pThread = new Thread(pObj);
        Thread cThread = new Thread(cObj);

        pThread.start();
        cThread.start();
    }

}

