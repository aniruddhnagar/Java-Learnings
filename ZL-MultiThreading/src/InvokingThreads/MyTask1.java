package InvokingThreads;

public class MyTask1 implements Runnable{

    public void run() {
        System.out.println("MyTask1 Thread: " + Thread.currentThread().getName());
    }
}
