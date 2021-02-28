package com.ace.programming;

import org.apache.commons.lang3.time.StopWatch;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;

import java.math.BigInteger;
import java.util.List;

public class FibonacciTest {

    private static final List<Long> FIBONACCI_SEQUENCE = List.of(0L, 1L, 1L, 2L, 3L, 5L, 8L,
            13L, 21L, 34L, 55L, 89L, 144L);

    private final FibonacciService fibonacciService = new FibonacciService();

    @ParameterizedTest
    @ValueSource(ints = {0, 1, 2, 3, 4, 5, 6, 7, 8, 9, 10, 11, 12})
    void testFibOf(int i) {
        Assertions.assertEquals(BigInteger.valueOf(FIBONACCI_SEQUENCE.get(i)), fibonacciService.fibOf(i));
    }

    @Test
    void timeTest() {
        StopWatch stopWatch = new StopWatch();
        stopWatch.start();
        var result = fibonacciService.fibOf(48);
        stopWatch.stop();

        System.out.printf("Test ran in: %s With result %d\n",
                stopWatch.formatTime(), result);
    }

    @Test
    void memoTimeTest() {
        StopWatch stopWatch = new StopWatch();
        stopWatch.start();
        var result = fibonacciService.memoFibOf(10000);
        stopWatch.stop();

        System.out.printf("Memo Test ran in: %d With result %d\n",
                stopWatch.getNanoTime(), result);
    }

    @Test
    void loopTimeTest() {
        StopWatch stopWatch = new StopWatch();
        stopWatch.start();
        var result = fibonacciService.loopFibOf(10000);
        stopWatch.stop();

        System.out.printf("Memo Test ran in: %d With result: %d\n",
                stopWatch.getNanoTime(), result);
        Assertions.assertEquals(fibonacciService.memoFibOf(10000), fibonacciService.loopFibOf(10000));
    }


}
