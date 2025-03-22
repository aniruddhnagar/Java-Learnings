package MonitorLock;

public class Consumer implements Runnable{

    SharedResource obj;

    Consumer(SharedResource obj) {
        this.obj = obj;
    }

    @Override
    public void run() {
        System.out.println("Inside Consumer");
        System.out.println("Inside Consumer Thread: " + Thread.currentThread().getName());
        try {
            obj.consumeItem();
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }
    }
}
