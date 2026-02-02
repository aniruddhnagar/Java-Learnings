package MonitorLock;

public class SharedResource {

    boolean isItemAvailable = false;

    public synchronized void addItem() throws InterruptedException {
        System.out.println("Inside Resource: Adding Item");
        while(isItemAvailable) {
            wait();
        }
        notifyAll();
    }

    public synchronized void consumeItem() throws InterruptedException {

        while (!isItemAvailable) {
            wait();
        }
        System.out.println("Inside Resource: Consuming Item");
        isItemAvailable = false;
    }

}
