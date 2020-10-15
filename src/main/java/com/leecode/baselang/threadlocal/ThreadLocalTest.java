package com.leecode.baselang.threadlocal;

import java.util.concurrent.ThreadPoolExecutor;
import java.util.concurrent.atomic.AtomicInteger;

public class ThreadLocalTest {
    private ThreadLocal<AtomicInteger> currentThreadLocal = ThreadLocal.withInitial(() -> {
        return new AtomicInteger(0);
    });
    public void TestThread(int number) {
        currentThreadLocal.get().addAndGet(number);
    }

    public void PrintThreadNumber() {
        System.out.println(currentThreadLocal.get().get());
    }

    public void TestForKeyAndGC () {
        for (;;) {

        }
    }
    public static void main(String[] args) {
        ThreadLocalTest threadLocalTest = new ThreadLocalTest();
        threadLocalTest.currentThreadLocal.get().incrementAndGet();
        System.out.println(threadLocalTest.currentThreadLocal.get().get());
    }
}
