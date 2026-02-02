package ReadWriteLock;

//    A ReadWriteLock is a specialized synchronization mechanism that allows for higher concurrency
//    by separating access into two distinct locks: one for reading and one for writing.
//
//    In a standard synchronized block or ReentrantLock, only one thread can access the data at a time.
//    A ReadWriteLock changes the rules:
//    Multiple Readers: Many threads can read the data simultaneously as long as no one is writing.
//    Single Writer: Only one thread can write at a time.
//    Mutual Exclusion: If someone is writing, no one can read. If someone is reading, the writer must wait.

public class Main {

    public static void main(String[] args) throws InterruptedException {

        ReadWriteLockExample.SharedData sharedData = new ReadWriteLockExample.SharedData();

        // 1. Create a Writer Thread
        Runnable writer = () -> {
            for (int i = 0; i < 3; i++) {
                sharedData.incrementCount();
                try { Thread.sleep(100); } catch (InterruptedException e) {}
            }
        };

        // 2. Create a Reader Thread
        Runnable reader = () -> {
            for (int i = 0; i < 5; i++) {
                int val = sharedData.readCount();
                System.out.println(Thread.currentThread().getName() + " READ value: " + val);
                try { Thread.sleep(50); } catch (InterruptedException e) {}
            }
        };

        // 3. Start multiple Readers and one Writer
        new Thread(writer, "Writer-1").start();
        new Thread(reader, "Reader-1").start();
        new Thread(reader, "Reader-2").start();
        new Thread(reader, "Reader-3").start();

    }
}
