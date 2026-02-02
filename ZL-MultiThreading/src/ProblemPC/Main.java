package ProblemPC;

// In Java, the Producer-Consumer Problem occurs when multiple threads share a common resource (buffer)
// without proper coordination,
// leading to race conditions, buffer overflow, or buffer underflow.

public class Main {

    public static void main(String[] args) {

        SharedResource obj = new SharedResource(3);

        Producer pObj = new Producer(obj);
        Consumer cObj = new Consumer(obj);

        Thread pThread = new Thread(pObj);
        Thread cThread = new Thread(cObj);

        pThread.start();
        cThread.start();
    }
}
