//    Optional<T> is a container object used to represent a value that
//    may or may not be present, effectively helping avoid NullPointerException.

//    How does Optional help handle null values?
//    Instead of checking if (obj != null),
//    you use methods like isPresent(), ifPresent(), or orElse() to provide default behavior.

//    Q1: What is the main purpose of the Optional class?
//    Answer:
//      The main purpose is to represent an optional value (presence or absence) explicitly in the API return types,
//      removing the need for null checks and reducing NullPointerException. It signals to the caller,
//      "This method might not return a value, so handle it."

//    Q2: What is the difference between Optional.of() and Optional.ofNullable()?
//    Answer:
//        Optional.of(value) throws a NullPointerException if the passed value is null.
//            It is used when you are strictly expecting a non-null value.
//        Optional.ofNullable(value) handles null gracefully by returning Optional.empty() if the value is null.

//    Q3: Is Optional Serializable?
//    Answer:
//        No. The Optional class does not implement Serializable.
//    Therefore, it should generally not be used as a field in a class (POJO/Bean) that might need to be serialized.

import java.util.Optional;

public class Main {
    public static void main(String[] args) {

        // ----- A. Creating an Optional
        // Optional.empty(): Creates an empty Optional (no value).
        Optional<String> emptyOpt = Optional.empty();

        // Optional.of(T value): Creates an Optional with a non-null value. Throws NPE if null is passed.
        // Optional.of(null); // Throws NullPointerException immediately
        String name1 = "Java";
        Optional<String> opt1 = Optional.of(name1); // Safe

        // Optional.ofNullable(T value): Best for handling unknown data.
        // Creates an Optional if the value is non-null; otherwise, returns an empty Optional.
        String name2 = null;
        Optional<String> opt2 = Optional.ofNullable(name2); // Returns Optional.empty

        // ----- B. Retrieving Values Safely
        // orElse(T other): Returns the value if present; otherwise returns a default value.
        String result1 = opt1.orElse("Default Name");

        // orElseGet(Supplier<? extends T> other): Lazy evaluation.
        // The default value is only created if the Optional is empty (better performance).
        // "Generating..." is only printed if opt is empty
        String result2 = opt2.orElseGet(() -> {
            System.out.println("Generating...");
            return "Generated Name";
        });

        // orElseThrow(Supplier<? extends X> exceptionSupplier): Throws a custom exception if the value is missing.
        // User user = userOpt.orElseThrow(() -> new IllegalArgumentException("User not found"));

    }
}