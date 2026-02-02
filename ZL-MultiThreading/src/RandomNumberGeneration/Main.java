package RandomNumberGeneration;

import java.util.Random;

//An Atomic Operation is an action that happens all at once. In a multithreaded environment, it implies:
//    Indivisibility: The operation cannot be interrupted;
//                    other threads see the value either before the change or after, but never in an inconsistent middle state.
//    Thread-Safety without Locks: It achieves safety using low-level CPU instructions
//                    like Compare-And-Swap (CAS) instead of expensive Monitor Locks.


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
        txn.generateTransactionId1();
        txn.generateTransactionId1();
        txn.generateTransactionId1();
        txn.generateTransactionId2();
    }
}
