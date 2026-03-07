package pck2;

public class GenericClass2 <K,V> {
    K obj1;
    V obj2;
    GenericClass2(K val1, V val2) {
        obj1 = val1;
        obj2 = val2;
        System.out.println("The key is: " + obj1 + "\n" + "The val is: " +  obj2);
    }
}
