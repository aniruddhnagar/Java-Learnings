package ProblemPC;

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
