package pck2;

public class GenericClass3 {

    public <T> void display(T val) {
        T obj1 = val;
        System.out.println("The GM val is: " + obj1);
    }
}
