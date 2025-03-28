package ThreadPool;

import java.util.List;

public class MyTask implements Runnable {

    List<Integer> output;

    public MyTask(List<Integer> list) {
        output = list;
    }

    @Override
    public void run() {
        output.add(80);
        output.add(100);
    }
}
