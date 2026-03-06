//    Streams allow for declarative processing of data collections (filtering, mapping, reducing).
//
//    What is the difference between Intermediate and Terminal operations?
//      Intermediate operations (e.g., filter, map) are lazy and return a new stream.
//      Terminal operations (e.g., collect, forEach) trigger the processing and return a final result.

//    What is the difference between a Collection and a Stream?
//      Collections are data structures used to store and manage data (e.g., List, Set). They can be iterated multiple times.
//      Streams are fixed-use pipelines for processing data. They do not store elements and can only be traversed once.

//    What is the difference between groupingBy and partitioningBy?
//        PartitioningBy always returns a Map<Boolean, List<T>> with exactly two keys: true and false.
//            Even if one group is empty, the key still exists in the map.
//        GroupingBy is more general and can have any number of keys.

//    How do you format a list into a CSV-style string with a prefix and suffix?
//        Use the overloaded version of joining(delimiter, prefix, suffix).
//        Simple Join: collect(Collectors.joining()) results in "ABC".
//        With Delimiter: collect(Collectors.joining(", ")) results in "A, B, C"


import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.Comparator;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.Set;
import java.util.stream.Collectors;

public class Main {
    public static void main(String[] args) {

        // Filtering and Mapping
        List<String> names = Arrays.asList("Alice", "Bob", "Charlie", "David");
        names.stream()
                .filter(s -> s.startsWith("C"))  // Intermediate
                .map(String::toUpperCase)              // Intermediate
                .peek(System.out::println)
                .collect(Collectors.toList());         // Terminal


        // 1. Create a list of strings
        List<String> words = Arrays.asList("apple", "bat", "cat", "banana", "kiwi", "pear");

        // 2. Group strings by their length
        // Result is a Map where Key = length (Integer) and Value = list of matching strings
        Map<Integer, List<String>> groupedByLength = words.stream()
                .collect(Collectors.groupingBy(String::length));

        // 3. Print the result
        System.out.println("Strings grouped by length:");
        groupedByLength.forEach((length, list) ->
                System.out.println("Length " + length + ": " + list));


        // Separate even and odd numbers
        List<Integer> nums = Arrays.asList(1, 2, 3, 4, 5, 6);
        Map<Boolean, List<Integer>> evenOdd = nums.stream()
                .collect(Collectors.partitioningBy(n -> n % 2 == 0));
        System.out.println("EvenOdd: " + evenOdd);
                // Output: {false=[1, 3, 5], true=[2, 4, 6]}

        Map<Boolean, Long> counts = nums.stream()
                .collect(Collectors.partitioningBy(n -> n > 3, Collectors.counting()));
        System.out.println("Counts: " + counts);

        List<String> list = Arrays.asList("Java", "Python", "C++");
        String result = list.stream()
                .collect(Collectors.joining(", ", "[", "]"));
        System.out.println("Result: " + result);


        // Partition a list of employees by salary and then collect only their names into
        // a comma-separated string for each partition.
        List<Employee> employees = Arrays.asList(
                new Employee("Alice", 7000),
                new Employee("Bob", 4000),
                new Employee("Charlie", 8000),
                new Employee("David", 3000)
        );
        Map<Boolean, String> partitionedNames = employees.stream()
            .collect(Collectors.partitioningBy(
                    e -> e.getSalary() > 5000, // Partition criteria
                    Collectors.mapping(Employee::getName, Collectors.joining(", ")) // Downstream collector
            ));

        System.out.println("High Salary (>5000): " + partitionedNames.get(true));
        System.out.println("Low Salary (<=5000): " + partitionedNames.get(false));

        //----------------------------------------------
        // Find the second-highest element
        List<Integer> num = new ArrayList<>();
        num = Arrays.asList(5,2,1,4,2,6);
        Integer ans = num.stream()
                .sorted(Collections.reverseOrder())
                .skip(1)
                .findFirst()
                .orElse(null);
        System.out.println(ans);

        //----------------------------------------
        // Count frequency of characters in a string
        String input = "abcdbcacdd";
        // Changed Map types: String (from split) and Long (from counting)
        Map<String, Long> mp = Arrays.stream(input.split(""))
                .collect(Collectors.groupingBy(
                        c -> c,
                        Collectors.counting()
                ));
        System.out.println(mp);

        //-----------------------------------------------
        // Find duplicate elements
        List<Integer> num2 = Arrays.asList(5,2,1,4,2,6);
        Set<Integer> ans2 = num2.stream()
                .filter(c -> Collections.frequency(num2, c) > 1)
                .collect(Collectors.toSet());
        System.out.println("Duplicate:" + ans2);

        //----------------------------
        List<Integer> num3 = Arrays.asList(5, 2, 1, 4, 2, 6);
        Set<Integer> seen = new HashSet<>();

        Set<Integer> ans3 = num3.stream()
                .filter(n -> !seen.add(n)) // .add() returns false if the element is already present
                .collect(Collectors.toSet());

        System.out.println("Duplicate:" + ans3);

        //--------------------------------------------------
        // 3. Find the longest string
        List<String> words1 = Arrays.asList("apple", "banana", "cherry", "date");
        String longest = words1.stream()
                .max(Comparator.comparingInt(String::length))
                .orElse("");
        System.out.println("Longest string: " + longest);

        //---------------------------------------------------
        // 4. Sort strings by length
        List<String> sortedByLength = words1.stream()
                .sorted(Comparator.comparingInt(String::length))
                .collect(Collectors.toList());
        System.out.println("Sorted by length: " + sortedByLength);

    }
}