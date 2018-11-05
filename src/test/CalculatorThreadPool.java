package test;

import java.util.*;
import java.util.concurrent.ConcurrentLinkedQueue;

public class CalculatorThreadPool {
    private int countTreads;
    private Queue<Integer> taskQueue;

    public CalculatorThreadPool(int countTreads) {
        this.countTreads = countTreads;
    }

    public Set<Double> startTreads(int n) {
        fillQueue(n);
        List<Thread> threads = new ArrayList<>();
        Set<Double> res = new HashSet<>();
        for (int i = 0; i < countTreads; i++) {
            if (!taskQueue.isEmpty()) {
                Thread thread = new CalculateThread(taskQueue, res);
                thread.start();
                threads.add(thread);
            }
        }
        threads.forEach(thread -> {
            try {
                thread.join();
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        });
        return res;
    }

    private void fillQueue(int n) {
        taskQueue = new ConcurrentLinkedQueue<>();
        for (int i = 0; i < n; i++) {
            taskQueue.add(i);
        }
    }
}