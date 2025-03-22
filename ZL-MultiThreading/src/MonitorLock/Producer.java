package MonitorLock;

public class Producer implements Runnable{

    SharedResource obj;

    Producer(SharedResource obj) {
        this.obj = obj;
    }

    @Override
    public void run() {
        System.out.println("Inside Producer");
        System.out.println("Inside Producer Thread: " + Thread.currentThread().getName());
        try {
            Thread.sleep(4000);
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }
        obj.addItem();
    }
}
