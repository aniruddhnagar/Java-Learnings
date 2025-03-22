package ProblemPC;

public class Consumer implements Runnable{

    SharedResource obj;

    Consumer(SharedResource obj) {
        this.obj = obj;
    }

    @Override
    public void run() {
        for (int i=0; i<6; i++) {
            try {
                int j = obj.popItem();
                System.out.println("Consumed Item: " + j);
            } catch (InterruptedException e) {
                throw new RuntimeException(e);
            }
        }
    }
}
