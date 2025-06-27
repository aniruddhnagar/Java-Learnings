package RandomNumberGeneration;

import java.util.Random;
import java.util.concurrent.atomic.AtomicLong;

public class Main {

    public static void main(String[] args) {

        int min = 11;
        int max = 30;

        Random random1 = new Random();
        int num1 = random1.nextInt(max - min + 1) + min;
        System.out.println(num1);

        int num2 = (int)(Math.random() * (max - min + 1)) + min;
        System.out.println(num2);

        //Unique IDs
        Transaction txn = new Transaction();
        txn.generateTransactionId();
        txn.generateTransactionId();
        txn.generateTransactionId();

    }
}
