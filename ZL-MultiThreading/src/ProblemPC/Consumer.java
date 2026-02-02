package ProblemPC;

public class Consumer implements Runnable{

    SharedResource obj;

    Consumer(SharedResource obj) {
        this.obj = obj;
    }

    @Override
    public void run() {
        for (int i=0; i<6; i++) {
            int j = obj.consume();
            System.out.println("Consumed Item: " + j);
        }
    }
}
