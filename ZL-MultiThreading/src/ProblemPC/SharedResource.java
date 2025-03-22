package ProblemPC;

import java.util.LinkedList;
import java.util.Queue;

public class SharedResource {

    private Queue<Integer> buffer;
    private int bufferSize;

    SharedResource(int iSize) {
        this.bufferSize = iSize;
        buffer = new LinkedList<>();
    }

    public synchronized void addItem(int iItem) throws InterruptedException {
        while (buffer.size() == bufferSize) {
            System.out.println("Inside Resource P: waiting");
            wait();
        }
        System.out.println("Inside Resource P: adding");
        buffer.add(iItem);
        notifyAll();
    }

    public synchronized int popItem() throws InterruptedException {
        while (buffer.isEmpty()) {
            System.out.println("Inside Resource C: waiting");
            wait();
        }
        System.out.println("Inside Resource C: consuming");
        int i = buffer.poll();
        notifyAll();
        return i;
    }

}
