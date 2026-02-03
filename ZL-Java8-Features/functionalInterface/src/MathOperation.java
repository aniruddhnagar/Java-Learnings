@FunctionalInterface
public interface MathOperation {

    int operate(int a, int b);
}

//    Can you use local variables in a Lambda?
//    Yes, but they must be final or effectively final (never modified after initialization).
//
//    What is "Target Type"?
//    It is the functional interface expected by the compiler in a given context (like a method parameter)
//    to determine which method the lambda is implementing.
//
//    Lambda vs. Method Reference:
//    If a lambda only calls an existing method, use a Method Reference (::) for better readability.
//
//    Lambda: list.forEach(s -> System.out.println(s));
//    Method Reference: list.forEach(System.out::println);