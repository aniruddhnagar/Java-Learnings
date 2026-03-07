@FunctionalInterface
public interface funcInterface extends funInterface2 {

    //Functional interface can have only one abstract method
    //If it is extending some other interface, that should not
    //have abstract method, it can have default methods
    void getSpeed();
}
