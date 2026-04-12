package EvenOdd;

public class Resource {

    public final int limit = 10;
    public int count;

    Resource(int count){
        this.count = count;
    }

    public void printOdd(){
        synchronized (this) {
            while (count < limit) {
                while (count % 2 == 0) {
                    try {
                        wait();
                    } catch (InterruptedException e) {
                        throw new RuntimeException(e);
                    }
                }
                System.out.println(count);
                count++;
                notify();
            }
        }
    }

    public void printEven(){
        synchronized (this) {
            while (count < limit) {
                while (count % 2 == 1) {
                    try {
                        wait();
                    } catch (InterruptedException e) {
                        throw new RuntimeException(e);
                    }
                }
                System.out.println(count);
                count++;
                notify();
            }
        }
    }
}
