package com.ace.programming;

import java.math.BigInteger;
import java.util.HashMap;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;

public class FibonacciService {
    private final Map<Long, BigInteger> resultsMap =
            new ConcurrentHashMap<>(Map.of(0L, BigInteger.ZERO, 1L, BigInteger.ONE));

    public BigInteger fibOf(long i) {
        return (i < 2) ? BigInteger.valueOf(i) :
                fibOf(i - 2).add(fibOf(i - 1));
    }

    public BigInteger memoFibOf(long i) {
        BigInteger result;
        if(resultsMap.containsKey(i)) {
            result = resultsMap.get(i);
        } else {
            result = memoFibOf(i-2).add(memoFibOf(i-1));
            resultsMap.put(i, result);
        }
        return result;
    }

    public BigInteger loopFibOf(long n) {
        BigInteger last = BigInteger.ZERO;  // fib(0)
        BigInteger next = BigInteger.ONE; // fib(1)

        for (long i = 0; i < n; i++) {
            BigInteger oldLast = last;
            last = next;
            next = oldLast.add(next);
        }
        return last;
    }
}
