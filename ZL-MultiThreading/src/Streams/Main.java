package Streams;

import java.util.Arrays;
import java.util.List;
import java.util.Optional;
import java.util.stream.Stream;

public class Main {

    public static void main(String[] args) {

        Stream<String> list0 = Stream.of("Hello", "All", "All", "How", "Are", "Are", "You", "Doing");

        Integer[] arr = {10, 20, 30, 40, 50};
        Stream<Integer> list1 = Arrays.stream(arr);

        List<Integer> list = Arrays.asList(arr);
        Stream<Integer> list2 = list.stream();

        Stream.Builder<Integer> sBuilder = Stream.builder();
        sBuilder.add(10).add(20).add(30).add(40).add(50);
        Stream<Integer> list3 = sBuilder.build();

        List<String> list4 = Stream.of("Hello", "All", "All", "How", "Are", "Are", "You", "Doing")
                .filter((String name) -> name.length() <= 3)
                .distinct()
                .map(String::toUpperCase)
                .sorted()
                .limit(3)
                .skip(1)
                .peek(System.out::println)
                .toList();
        System.out.println("===================================");

        Stream.of("Hello", "All", "All", "How", "Are", "Are", "You", "Doing")
                .filter((String name) -> name.length() <= 3)
                .distinct()
                .map(String::toUpperCase)
                .sorted()
                .limit(3)
                .skip(1)
                .peek(System.out::println)
                .forEach(System.out::println);
        System.out.println("===================================");

        Long cnt = Stream.of(10, 20, 30, 15, 7, 22, 35, 25)
                .filter((Integer val) -> val > 20)
                .distinct()
                .count();
        System.out.println(cnt);
        System.out.println("===================================");

        Optional<Integer> valx = Stream.of(10, 20, 30, 15, 7, 22, 35, 25)
                .filter((Integer val) -> val > 20)
                .sorted()
                .distinct()
                .peek(System.out::println)
                .reduce((Integer val1, Integer val2) -> val1 + val2);
        System.out.println(valx.get());
        System.out.println("===================================");

        Optional<Integer> valy = Stream.of(10, 20, 30, 15, 7, 22, 35, 25)
                .filter((Integer val) -> val > 20)
                .sorted()
                .distinct()
                .peek(System.out::println)
                .min((Integer val1, Integer val2) -> val1 - val2); //increasing
        System.out.println(valy.get());
        System.out.println("===================================");
    }
}
