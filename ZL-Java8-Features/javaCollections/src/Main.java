import java.util.ArrayList;
import java.util.HashSet;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;
import java.util.Set;

//TIP To <b>Run</b> code, press <shortcut actionId="Run"/> or
// click the <icon src="AllIcons.Actions.Execute"/> icon in the gutter.
public class Main {

    public static void main(String[] args) {

//        Used when:
//            Ordered data
//            Duplicates allowed
//            Index access needed
        List<String> list = new ArrayList<>();
        list.add("David");
        list.add("john");
        list.add("EFM");
        list.add(1, "Travis");
        list.remove("EFM");

        System.out.println(list);
        System.out.println(list.get(1));
        System.out.println(list.contains("john"));
        System.out.println(list.size());
        System.out.println(list.isEmpty());


        LinkedList<String> queue = new LinkedList<>();
        queue.add("abc");
        queue.addFirst("cde");
        queue.addLast("fgh");
        System.out.println(queue.getFirst());
        System.out.println(queue.isEmpty());
        queue.removeLast();
        System.out.println(queue);



//        Used when:
//            No duplicates
//            Fast membership check
        Set<Integer> set = new HashSet<>();
        set.add(5);
        set.add(3);
        set.add(8);
        set.forEach((i) -> i = i+1);
        set.forEach(System.out::println);

        Iterator<Integer> itr = set.iterator();
        while(itr.hasNext()){
            System.out.println(itr.next());
        }



    }
}