package ProblemPC;

public class Producer implements Runnable{

    SharedResource obj;

    Producer(SharedResource obj) {
        this.obj = obj;
    }

    @Override
    public void run() {
        for (int i=0; i<6; i++) {
            System.out.println("Produced Item: " + i);
            obj.produce(i);
        }
    }
}
