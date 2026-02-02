package ProblemPC;

import java.util.LinkedList;
import java.util.Queue;

public class SharedResource {

    private Queue<Integer> queue;
    private int capacity;

    SharedResource(int iSize) {
        this.capacity = iSize;
        queue = new LinkedList<>();
    }

    // PROBLEM: No synchronization here.
    // Two threads can add/remove at the exact same time.
    public void produce(int value) {
        if (queue.size() == capacity) {
            System.out.println("Buffer full! Producer should wait but can't...");
            return;
        }
        queue.add(value);
        System.out.println("Produced: " + value);
    }

    public int consume() {
        if (queue.isEmpty()) {
            System.out.println("Buffer empty! Consumer should wait but can't...");
            return 0;
        }
        int value = queue.poll();
        System.out.println("Consumed: " + value);
        return value;
    }

}
