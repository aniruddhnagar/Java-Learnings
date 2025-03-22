package InvokingThreads;

public class Main {

    public static void main(String[] args) throws InterruptedException {

        System.out.println("Main Thread: " + Thread.currentThread().getName());

        MyTask1 obj1 = new MyTask1();
        Thread myTask = new Thread(obj1);
        myTask.start();

        MyTask2 obj2 = new MyTask2();

        // obj2 will be killed as soon as main/user threads finishes
        // obj2.setDaemon(true);

        obj2.start();

        // main will wait until obj2 finishes
        obj2.join();
        System.out.println("Main Thread: " + Thread.currentThread().getName());

    }

}