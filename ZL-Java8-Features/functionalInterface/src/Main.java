//    What is a Functional Interface?
//    It is an interface with exactly one abstract method (SAM - Single Abstract Method).
//    It can have multiple default or static methods.
//
//    What is a Lambda Expression?
//    It is a concise way to represent an anonymous function that implements a functional interface.
//
//    Why use @FunctionalInterface?
//    This optional annotation informs the compiler to verify that the interface has exactly one abstract method,
//    preventing accidental additions that would break lambda compatibility.

//    Interface	          Purpose	                             Method	          Example
//------------------------------------------------------------------------------------------------------------
//    Supplier	          Provides a value (no input)            get()	          () -> Math.random()
//    Consumer	          Consumes data (no return)	             accept(T t)	  s -> System.out.println(s)
//    Predicate	          Conditional check (returns boolean)	 test(T t)	      n -> n % 2 == 0
//    Function<T, R>	  Transforms T to R	                     apply(T t)	      s -> s.length()

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

public class Main {

    public static void main(String[] args) {

        // Implement a custom Functional Interface using a Lambda
        MathOperation addition = (a,b) -> a+b;
        System.out.printf("Sum: " + addition.operate(5,7));


        // Traditional Anonymous Inner Class
        Runnable r1 = new Runnable() {
            @Override
            public void run() {
                System.out.println("\nThread running...");
            }
        };
        // Modern Lambda Expression
        Runnable r2 = () -> System.out.println("\nLambda thread running...");
        Thread th = new Thread(r2);
        th.start();


        // Filter and Transform a List
        List<String> names = Arrays.asList("Alice", "Bob", "Charlie");
        List<String> result = names.stream()
                .filter(name -> name.startsWith("A")) // Uses Predicate
                .map(String::toUpperCase)                   // Uses Function/Method Reference
                .peek(System.out::println)                  // Output: [ALICE]
                .collect(Collectors.toList());



        SampleClass obj1 = new SampleClass();
        obj1.getSpeed();
        obj1.getColor();

        //Lambda expression can only support with Functional interface
        funcInterface obj2 = ()-> System.out.println("Speed is 50 km/hr");
        obj2.getSpeed();

        //Using Reflection to get the metadata of a particular class
        Class classObj = SampleClass.class;
        System.out.println(classObj.getName());

        Method[] methods = classObj.getDeclaredMethods();
        for(Method method : methods){
            System.out.println(method);
        }

    }
}
