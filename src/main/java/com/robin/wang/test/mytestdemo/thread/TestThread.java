package com.robin.wang.test.mytestdemo.thread;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

public class TestThread {
    static int THREAD_SIZE = 20;
    static int TOTAL_COUNT = 4120;
    static int SIZE = 20;

    public static void main(String[] args) {
        int step = TOTAL_COUNT / THREAD_SIZE;
        int count = step / SIZE;
        ExecutorService executorService = Executors.newFixedThreadPool(THREAD_SIZE);
        for (int index = 0; index < THREAD_SIZE; index++) {
            int finalIndex = index;
            executorService.submit(() -> {

                int leftIndex = finalIndex * step;
                int rightIndex = (finalIndex + 1) * step;

                for (int innerIndex = 0; innerIndex <= count; innerIndex++) {
                    System.out.println(Thread.currentThread().getName() + "," + (leftIndex+innerIndex*SIZE ));
                }
            });
        }
        executorService.shutdown();
    }
}
