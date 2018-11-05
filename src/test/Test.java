package test;

import java.util.HashSet;
import java.util.Set;

/**
 * Should be improved to reduce calculation time.
 * <p>
 * Change it or create new one. (max threads count is com.fitechsource.test.TestConsts#MAX_THREADS)
 * Do not use `executors`, only plain threads.
 */
public class Test {
    public static void main(String[] args) throws TestException {
        Set<Double> res = new HashSet<>();
        CalculatorThreadPool pool = new CalculatorThreadPool(TestConsts.MAX_THREADS);
        res.addAll(pool.startTreads(TestConsts.N));
        System.out.println(res);
    }
}
