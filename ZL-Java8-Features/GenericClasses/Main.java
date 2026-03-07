package pck2;

public class Main {

    public static void main(String[] args) {

        GenericClass<String> obj1 = new GenericClass<>("Aniruddh");
        GenericClass<Integer> obj11 = new GenericClass<>(32);

        GenericClass2<String, Integer> obj2 = new GenericClass2<>("Anjali", 30);

        GenericClass3 obj3 = new GenericClass3();
        obj3.display(new String("Anvi"));

        GenericClass4<String, Integer> obj4 = new GenericClass4<>("Anvi", 18);
    }
}
