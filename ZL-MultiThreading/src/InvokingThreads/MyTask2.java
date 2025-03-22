package InvokingThreads;

public class MyTask2 extends Thread{

    public void run() {
        System.out.println("MyTask2 Thread: " + Thread.currentThread().getName());
        try {
            sleep(8000);
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }
        System.out.println("MyTask2 Thread: " + Thread.currentThread().getName());
    }
}
