public interface Bird {

    void makeSound();
    void getLegs();

    default void makeEat() {
        System.out.println("Bird can eat");
    }

    //Nested interface
    public interface ColorBirds {
        void getColor();
    }

}
