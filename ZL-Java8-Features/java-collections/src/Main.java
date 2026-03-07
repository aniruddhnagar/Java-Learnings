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
    ARRAY
    ============================================================
    */

            System.out.println("===== ARRAY =====");

            int[] arr = {5,2,8,1,9};

            System.out.println("Original Array: " + Arrays.toString(arr));

            // Access element
            System.out.println("Element at index 2: " + arr[2]);

            // Sorting
            Arrays.sort(arr);
            System.out.println("Sorted Array: " + Arrays.toString(arr));

            // Reverse
            reverseArray(arr);
            System.out.println("Reversed Array: " + Arrays.toString(arr));

            System.out.println();



    /*
    ============================================================
    ARRAYLIST
    ============================================================
    */

            System.out.println("===== ARRAYLIST =====");

            List<Integer> list = new ArrayList<>();

            // add elements
            list.add(10);
            list.add(20);
            list.add(30);

            // insert at index
            list.add(1,15);

            System.out.println("ArrayList: " + list);

            // get
            System.out.println("Element at index 2: " + list.get(2));

            // set/update
            list.set(2,99);
            System.out.println("ArrayList: " + list);

            // remove
            list.remove(Integer.valueOf(15));

            // contains
            System.out.println("Contains 30? " + list.contains(30));

            // sort
            Collections.sort(list);

            // reverse
            Collections.reverse(list);

            System.out.println("After sort + reverse: " + list);

            // iteration
            for(Integer num : list){
                System.out.print(num + " ");
            }

            System.out.println("\n");



    /*
    ============================================================
    LINKEDLIST
    ============================================================
    */

            System.out.println("===== LINKEDLIST =====");

            LinkedList<Integer> linkedList = new LinkedList<>();

            linkedList.add(10);
            linkedList.add(15);
            linkedList.addFirst(5);
            linkedList.addLast(20);

            System.out.println("LinkedList: " + linkedList);

            System.out.println("First: " + linkedList.getFirst());
            System.out.println("Last: " + linkedList.getLast());

            linkedList.removeFirst();
            linkedList.removeLast();

            System.out.println("After removals: " + linkedList);

            Collections.reverse(linkedList);

            System.out.println("Reversed: " + linkedList);

            System.out.println();



    /*
    ============================================================
    STACK
    ============================================================
    */

            System.out.println("===== STACK =====");

            Stack<Integer> stack = new Stack<>();

            stack.push(10);
            stack.push(20);
            stack.push(30);
            stack.push(40);

            System.out.println("Stack: " + stack);

            System.out.println("Peek: " + stack.peek());

            System.out.println("Pop: " + stack.pop());

            System.out.println("Search element 10 position: " + stack.search(10));
            System.out.println("Search element 20 position: " + stack.search(20));
            System.out.println("Search element 30 position: " + stack.search(30));
            System.out.println("Search element 40 position: " + stack.search(40));

            System.out.println("Stack after pop: " + stack);

            System.out.println();



    /*
    ============================================================
    QUEUE
    ============================================================
    */

            System.out.println("===== QUEUE =====");

            Queue<Integer> queue = new LinkedList<>();

            queue.offer(10);
            queue.offer(20);
            queue.offer(30);

            System.out.println("Queue: " + queue);

            System.out.println("Peek: " + queue.peek());

            System.out.println("Poll: " + queue.poll());

            System.out.println("Queue after poll: " + queue);

            System.out.println();



    /*
    ============================================================
    DEQUE
    ============================================================
    */

            System.out.println("===== DEQUE =====");

            Deque<Integer> deque = new ArrayDeque<>();

            deque.addFirst(10);
            deque.addLast(20);
            deque.addLast(30);

            System.out.println("Deque: " + deque);

            System.out.println("First: " + deque.peekFirst());
            System.out.println("Last: " + deque.peekLast());

            deque.removeFirst();
            deque.removeLast();

            System.out.println("After removals: " + deque);

            System.out.println();



    /*
    ============================================================
    HASHSET
    ============================================================
    */

            System.out.println("===== HASHSET =====");

            Set<Integer> hashSet = new HashSet<>();

            hashSet.add(5);
            hashSet.add(2);
            hashSet.add(8);
            hashSet.add(5); // duplicate ignored

            System.out.println("HashSet: " + hashSet);

            System.out.println("Contains 2? " + hashSet.contains(2));

            hashSet.remove(8);

            System.out.println("After remove: " + hashSet);

            System.out.println();



    /*
    ============================================================
    TREESET (SORTED SET)
    ============================================================
    */

            System.out.println("===== TREESET =====");

            TreeSet<Integer> treeSet = new TreeSet<>();

            treeSet.add(30);
            treeSet.add(10);
            treeSet.add(20);

            System.out.println("Sorted TreeSet: " + treeSet);

            System.out.println("First: " + treeSet.first());
            System.out.println("Last: " + treeSet.last());

            System.out.println("Higher than 10: " + treeSet.higher(10));
            System.out.println("Lower than 20: " + treeSet.lower(20));

            System.out.println();



    /*
    ============================================================
    HASHMAP
    ============================================================
    */

            System.out.println("===== HASHMAP =====");

            Map<Integer,String> map = new HashMap<>();

            map.put(1,"One");
            map.put(2,"Two");
            map.put(3,"Three");

            System.out.println("HashMap: " + map);

            System.out.println("Get key 2: " + map.get(2));

            System.out.println("Contains key 1? " + map.containsKey(1));

            map.remove(3);

            System.out.println("After remove: " + map);

            // Iteration
            for(Map.Entry<Integer,String> entry : map.entrySet()){
                System.out.println(entry.getKey() + " -> " + entry.getValue());
            }

            System.out.println();



    /*
    ============================================================
    TREEMAP (SORTED MAP)
    ============================================================
    */

            System.out.println("===== TREEMAP =====");

            TreeMap<Integer,String> treeMap = new TreeMap<>();

            treeMap.put(3,"C");
            treeMap.put(1,"A");
            treeMap.put(2,"B");

            System.out.println("Sorted TreeMap: " + treeMap);

            System.out.println("First Entry: " + treeMap.firstEntry());
            System.out.println("Last Entry: " + treeMap.lastEntry());

            System.out.println("Higher Key than 1: " + treeMap.higherKey(1));

            System.out.println();



    /*
    ============================================================
    PRIORITY QUEUE (HEAP)
    ============================================================
    */

            System.out.println("===== PRIORITY QUEUE (MIN HEAP) =====");

            PriorityQueue<Integer> pq = new PriorityQueue<>();

            pq.offer(30);
            pq.offer(10);
            pq.offer(20);

            System.out.println("PriorityQueue: " + pq);

            while(!pq.isEmpty()){
                System.out.println("Poll: " + pq.poll());
            }

            System.out.println();


    /*
    MAX HEAP USING COMPARATOR
    */

            System.out.println("===== PRIORITY QUEUE (MAX HEAP) =====");

            PriorityQueue<Integer> maxHeap =
                    new PriorityQueue<>(Comparator.reverseOrder());

            maxHeap.offer(10);
            maxHeap.offer(30);
            maxHeap.offer(20);

            while(!maxHeap.isEmpty()){
                System.out.println("Poll: " + maxHeap.poll());
            }

            System.out.println();



    /*
    ============================================================
    CONCURRENTHASHMAP
    ============================================================
    */

            System.out.println("===== CONCURRENT HASHMAP =====");

            ConcurrentHashMap<Integer,String> concurrentMap =
                    new ConcurrentHashMap<>();

            concurrentMap.put(1,"A");
            concurrentMap.putIfAbsent(2,"B");

            concurrentMap.computeIfPresent(2,(k,v)->v+" updated");

            System.out.println("ConcurrentHashMap: " + concurrentMap);

            System.out.println();



    /*
    ============================================================
    COPYONWRITEARRAYLIST
    ============================================================
    */

            System.out.println("===== COPYONWRITEARRAYLIST =====");

            CopyOnWriteArrayList<Integer> cowList =
                    new CopyOnWriteArrayList<>();

            cowList.add(1);
            cowList.add(2);
            cowList.add(3);

            for(Integer num : cowList){
                if(num == 2){
                    cowList.add(4); // safe modification
                }
            }

            System.out.println("CopyOnWriteArrayList: " + cowList);

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

    /*
    ============================================================
    HELPER METHOD - REVERSE ARRAY
    ============================================================
    */

    public static void reverseArray(int[] arr){

        int left = 0;
        int right = arr.length - 1;

        while(left < right){

            int temp = arr[left];
            arr[left] = arr[right];
            arr[right] = temp;

            left++;
            right--;
        }
    }

}
