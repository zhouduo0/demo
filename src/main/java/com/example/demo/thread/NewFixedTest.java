package com.example.demo.thread;

import java.util.concurrent.Executor;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

/**
 * @author zhouduo
 * @date 2023/6/21
 */
public class NewFixedTest {
    public static void main(String[] args) {
        /**
         * newFixedThreadPool使用了无界的阻塞队列的LinkedBlockingQueue，如果线程获取一个任务后，
         * 任务的执行时间比较长(比如，上面demo代码设置了10秒)，会导致队列的任务越积越多，导致机器内存使用不停飙升， 最终出现OOM
         */
        ExecutorService executor = Executors.newFixedThreadPool(10);
        for (int i = 0; i < Integer.MAX_VALUE; i++) {
            executor.execute(() -> {
                try {
                    Thread.sleep(10000);
                } catch (InterruptedException e) {

                }
            });
        }
    }
}
