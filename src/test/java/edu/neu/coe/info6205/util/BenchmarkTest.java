/*
 * Copyright (c) 2017. Phasmid Software
 */

package edu.neu.coe.info6205.util;

import org.junit.Test;

import static org.junit.Assert.assertEquals;

@SuppressWarnings("ALL")
public class BenchmarkTest {

    int pre = 10;
    int run = 0;
    int post = 10;

    @Test // Slow
    public void testWaitPeriods() throws Exception {
        int nRuns = 10;
        int warmups = 0;
        Benchmark<Boolean> bm = new Benchmark_Timer<>(
                "testWaitPeriods",
            //GoToSleep(100L, -1);
            null,

                b -> {
                    GoToSleep(200L, 0);
                },
                null);

        double x = bm.run(true, nRuns);
        assertEquals(nRuns, post);
        assertEquals(nRuns + 2, run);
        assertEquals(nRuns + warmups, pre);
        assertEquals(200, x, 10);
    }

    private void GoToSleep(long mSecs, int which) {
        try {
            Thread.sleep(mSecs);
            if (which == 0) run++;
            else if (which > 0) post++;
            else pre++;
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }

    @Test
    public void getWarmupRuns() {
        assertEquals(2, Benchmark_Timer.getWarmupRuns(0));
        assertEquals(2, Benchmark_Timer.getWarmupRuns(20));
        assertEquals(3, Benchmark_Timer.getWarmupRuns(30));
        assertEquals(10, Benchmark_Timer.getWarmupRuns(100));
        assertEquals(10, Benchmark_Timer.getWarmupRuns(1000));
    }
}