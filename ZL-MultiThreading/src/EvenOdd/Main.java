package EvenOdd;

public class Main {
    public static void main(String[] args) {

        Resource res = new Resource(1);

        Thread t1 = new Thread(res::printOdd);
        Thread t2 = new Thread(res::printEven);

        t1.start();
        t2.start();
    }
}
