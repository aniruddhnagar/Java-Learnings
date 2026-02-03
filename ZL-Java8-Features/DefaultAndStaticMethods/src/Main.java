//    Why were default methods introduced?
//    They were added to provide backward compatibility, allowing new methods to be added to existing interfaces
//            (like forEach in Iterable) without breaking existing implementing classes.
//
//    What is the difference between default and static methods?
//    Default methods can be overridden by implementing classes and are invoked via instance references.
//    Static methods cannot be overridden and must be called using the interface name (e.g., MyInterface.staticMethod()).
//
//    Can a default method override Object methods like toString()?
//    No. Interfaces cannot provide default implementations for java.lang.Object methods because
//    a class-level implementation always takes precedence over an interface default.
//
//    How is the "Diamond Problem" resolved?
//    If a class implements two interfaces with the same default method signature, it must override the method
//    to provide its own implementation or explicitly choose one (e.g., InterfaceA.super.method()).
//
//    Can static methods in interfaces be private?
//    Yes, as of Java 9, interfaces can have private static and private instance methods to share common code between default and static methods.


public class Main {
    public static void main(String[] args) {

        Car myCar = new Car();
        myCar.blowHorn();       // Accessing default method via instance
        Vehicle.service();      // Accessing static method via interface name
    }
}