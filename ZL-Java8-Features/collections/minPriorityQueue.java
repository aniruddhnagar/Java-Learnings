package collections;

import java.util.PriorityQueue;

public class minPriorityQueue {

    public static void main(String[] args) {

        PriorityQueue<Integer> pq = new PriorityQueue<>();

        // insert element
        pq.offer(10);
        pq.offer(50);
        pq.offer(70);
        pq.offer(20);

        pq.forEach(System.out::println);

        // Query top element & remove it
        System.out.println(pq.poll());

        // Query top element
        System.out.println(pq.peek());
    }
}
