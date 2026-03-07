package pck2;

public class GenericClass<T> {
    T obj1;

    GenericClass(T val) {
        obj1 = val;
        System.out.println("The GC obj1 val is: " + obj1);
    }
}
