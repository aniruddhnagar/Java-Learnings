import java.util.*;
import java.util.concurrent.ArrayBlockingQueue;
import java.util.concurrent.BlockingQueue;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.CopyOnWriteArrayList;

public class Main {
    public static void main(String[] args) {

        // Define a List of integers
        List<Integer> integerList = new ArrayList<>();

        // Adding integers to the list
        integerList.add(10);
        integerList.add(20);
        integerList.add(70);
        integerList.add(50);
        integerList.add(30);

        // Accessing elements
        System.out.println("1. Elements in integerList:");
        for (Integer num : integerList) {
            System.out.println(num);
        }

        System.out.println("2. Elements in integerList:");
        Iterator<Integer> values = integerList.iterator();
        while (values.hasNext()) {
            System.out.println(values.next());
        }

        System.out.println("3. Elements in integerList:");
        integerList.forEach(System.out::println);

        System.out.println("4. Max value: " + Collections.max(integerList));
        System.out.println("5. Min value: " + Collections.min(integerList));

        Collections.sort(integerList);
        System.out.println("6. Elements in integerList after Sort:");
        integerList.forEach(System.out::println);

        Collections.reverse(integerList);
        System.out.println("7. Elements in integerList after Reverse:");
        integerList.forEach(System.out::println);

        /*
        ============================================================
        1. ARRAY
        ============================================================
        */
        System.out.println("===== ARRAY =====");

        int[] arr = new int[5]; // defining array
        arr[0] = 10;
        arr[1] = 20;
        arr[2] = 30;

        System.out.println("Array elements:");

        for(int i=0;i<arr.length;i++){
            System.out.print(arr[i] + " ");
        }

        System.out.println("\n");

        /*
        ============================================================
        2. ARRAYLIST
        ============================================================
        */

        System.out.println("===== ARRAYLIST =====");

        List<Integer> arrayList = new ArrayList<>();

        arrayList.add(10);
        arrayList.add(20);
        arrayList.add(30);

        System.out.println("ArrayList: " + arrayList);

        arrayList.remove(Integer.valueOf(20));

        System.out.println("After removing 20: " + arrayList);

        System.out.println();

        /*
        ============================================================
        3. LINKEDLIST
        ============================================================
        */

        System.out.println("===== LINKEDLIST =====");

        List<Integer> linkedList = new LinkedList<>();

        linkedList.add(1);
        linkedList.add(2);
        linkedList.add(3);

        System.out.println("LinkedList: " + linkedList);

        linkedList.add(0, 100);

        System.out.println("After inserting at index 0: " + linkedList);

        System.out.println();

        /*
        ============================================================
        4. STACK
        ============================================================
        */

        System.out.println("===== STACK =====");

        Stack<Integer> stack = new Stack<>();

        stack.push(10);
        stack.push(20);
        stack.push(30);

        System.out.println("Stack: " + stack);

        System.out.println("Pop: " + stack.pop());

        System.out.println("Peek: " + stack.peek());

        System.out.println("Stack after operations: " + stack);

        System.out.println();

        /*
        ============================================================
        5. QUEUE
        ============================================================
        */

        System.out.println("===== QUEUE =====");

        Queue<Integer> queue = new LinkedList<>();

        queue.offer(10);
        queue.offer(20);
        queue.offer(30);

        System.out.println("Queue: " + queue);

        System.out.println("Poll: " + queue.poll());

        System.out.println("Peek: " + queue.peek());

        System.out.println("Queue after operations: " + queue);

        System.out.println();

        /*
        ============================================================
        6. DEQUE
        ============================================================
        */

        System.out.println("===== DEQUE =====");

        Deque<Integer> deque = new ArrayDeque<>();

        deque.addFirst(10);
        deque.addLast(20);
        deque.addLast(30);

        System.out.println("Deque: " + deque);

        deque.removeFirst();
        deque.removeLast();

        System.out.println("Deque after removals: " + deque);

        System.out.println();

        /*
        ============================================================
        7. HASHSET
        ============================================================
        */

        System.out.println("===== HASHSET =====");

        Set<Integer> hashSet = new HashSet<>();

        hashSet.add(10);
        hashSet.add(20);
        hashSet.add(20); // duplicate ignored

        System.out.println("HashSet: " + hashSet);

        System.out.println("Contains 10? " + hashSet.contains(10));

        System.out.println();

        /*
        ============================================================
        8. TREESET
        ============================================================
        */

        System.out.println("===== TREESET =====");

        Set<Integer> treeSet = new TreeSet<>();

        treeSet.add(30);
        treeSet.add(10);
        treeSet.add(20);

        System.out.println("TreeSet (Sorted): " + treeSet);

        System.out.println();

        /*
        ============================================================
        9. HASHMAP
        ============================================================
        */

        System.out.println("===== HASHMAP =====");

        Map<Integer,String> hashMap = new HashMap<>();

        hashMap.put(1,"One");
        hashMap.put(2,"Two");
        hashMap.put(3,"Three");

        System.out.println("HashMap: " + hashMap);

        System.out.println("Get key 2: " + hashMap.get(2));

        hashMap.remove(1);

        System.out.println("After removing key 1: " + hashMap);

        System.out.println();

        /*
        ============================================================
        10. TREEMAP
        ============================================================
        */

        System.out.println("===== TREEMAP =====");

        Map<Integer,String> treeMap = new TreeMap<>();

        treeMap.put(3,"Three");
        treeMap.put(1,"One");
        treeMap.put(2,"Two");

        System.out.println("TreeMap (Sorted by key): " + treeMap);

        System.out.println();

        /*
        ============================================================
        11. PRIORITY QUEUE (HEAP)
        ============================================================
        */

        System.out.println("===== PRIORITY QUEUE =====");

        PriorityQueue<Integer> pq = new PriorityQueue<>();

        pq.offer(30);
        pq.offer(10);
        pq.offer(20);

        System.out.println("PriorityQueue: " + pq);

        System.out.println("Poll (smallest): " + pq.poll());

        System.out.println("After poll: " + pq);

        System.out.println();

        /*
        ============================================================
        12. CONCURRENTHASHMAP
        ============================================================
        */

        System.out.println("===== CONCURRENT HASHMAP =====");

        ConcurrentHashMap<Integer,String> concurrentMap = new ConcurrentHashMap<>();

        concurrentMap.put(1,"A");
        concurrentMap.put(2,"B");

        System.out.println("ConcurrentHashMap: " + concurrentMap);

        concurrentMap.putIfAbsent(2,"C");

        System.out.println("After putIfAbsent: " + concurrentMap);

        System.out.println();

        /*
        ============================================================
        13. COPYONWRITEARRAYLIST
        ============================================================
        */

        System.out.println("===== COPYONWRITEARRAYLIST =====");

        CopyOnWriteArrayList<Integer> cowList = new CopyOnWriteArrayList<>();

        cowList.add(1);
        cowList.add(2);
        cowList.add(3);

        System.out.println("CopyOnWriteArrayList: " + cowList);

        for(Integer i : cowList){
            if(i == 2){
                cowList.add(4); // safe during iteration
            }
        }

        System.out.println("After modification: " + cowList);

        System.out.println();

        /*
        ============================================================
        14. BLOCKING QUEUE
        ============================================================
        */

        System.out.println("===== BLOCKING QUEUE =====");

        BlockingQueue<Integer> blockingQueue = new ArrayBlockingQueue<>(5);

        try {

            blockingQueue.put(10);
            blockingQueue.put(20);

            System.out.println("BlockingQueue: " + blockingQueue);

            System.out.println("Take: " + blockingQueue.take());

        } catch (InterruptedException e) {
            e.printStackTrace();
        }

        System.out.println();
    }
}
