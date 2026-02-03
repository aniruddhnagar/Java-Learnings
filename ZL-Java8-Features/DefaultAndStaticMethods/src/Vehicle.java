interface Vehicle {

    void start(); // Abstract method

    default void blowHorn() {
        System.out.println("Blowing horn...");
    }

    static void service() {
        System.out.println("Vehicle service check.");
    }
}


class Car implements Vehicle {

    public void start() {
        System.out.println("Car started.");
    }
}
