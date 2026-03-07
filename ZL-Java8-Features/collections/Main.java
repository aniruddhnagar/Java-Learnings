package collections;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Iterator;
import java.util.List;

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
    }

}
