package MonitorLock;

public class SharedResource {

    boolean isItemAvailable = false;

    public synchronized void addItem() {
        System.out.println("Inside Resource: Adding Item");
        isItemAvailable = true;
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
