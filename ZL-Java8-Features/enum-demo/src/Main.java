public class Main {

    public static void main(String[] args) {

        enumSample obj1 = enumSample.getComment(5);

        enumSample obj2 = enumSample.TUESDAY;
        System.out.println(obj2.key);
        System.out.println(obj2.val);

        enumSample obj3 = enumSample.valueOf("WEDNESDAY");
        System.out.println(obj3.name());
    }
}
