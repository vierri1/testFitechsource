package test;

import java.util.Queue;
import java.util.Set;

public class CalculateThread extends Thread {
    private Queue<Integer> tasksQueue;
    private Set<Double> res;

    public CalculateThread(Queue<Integer> tasksQueue, Set<Double> res) {
        this.tasksQueue = tasksQueue;
        this.res = res;
    }

    @Override
    public void run() {
        while (!tasksQueue.isEmpty()) {
            try {
                Set<Double> set = TestCalc.calculate(tasksQueue.poll());
                synchronized (res) {
                    res.addAll(set);
                }
            } catch (TestException e) {
                tasksQueue.clear();
                e.printStackTrace();
            }
        }
    }
}
