package pck4;

public class Pegion implements Bird, Bird.ColorBirds {
    @Override
    public void makeSound() {
        System.out.println("Pegion GhuGhu");
    }

    @Override
    public void getLegs() {
        System.out.println("Pegion 2 legs");
    }

    @Override
    public void getColor() {
        System.out.println("Pegion is Gray color");
    }
}
