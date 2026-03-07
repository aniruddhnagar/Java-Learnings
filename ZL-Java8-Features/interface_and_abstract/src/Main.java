public class Main {

    public static void main(String[] args) {

//        FlyingBird obj1 = new Eagle();
        Eagle obj1 = new Eagle();
        obj1.makeSound();
        obj1.getLegs();
        obj1.makeFly();
        obj1.getWings();

//        Bird obj2 = new Pegion();
        Pegion obj2 = new Pegion();
        obj2.makeSound();
        obj2.getLegs();
        obj2.getColor();
        obj2.makeEat();
    }
}
