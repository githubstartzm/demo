package com.ali.superbaby;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.ThreadPoolExecutor;
import java.util.concurrent.TimeUnit;

public class Play {
    public static void main(String[] args) throws InterruptedException {
        /**
         * int corePoolSize,                        表示线程池里面的核心线程数
         * int maximumPoolSize,                     表示线程池中能拥有的最大线程数
         * long keepAliveTime,                      表示空闲线程的存活时间
         * TimeUnit unit,                           表示keepAliveTime的单位。
         * BlockingQueue<Runnable> workQueue        阻塞队列
         * RejectedExecutionHandler handler         拒绝策略，有四个实现。1.抛弃队列里面最早没有执行的任务
         *                                                                2.默认的策略，抛出一个异常
         *                                                                3.谁提交的任务谁来执行，主线程提交的就主线程执行
         *                                                                4.直接丢弃当前任务
         *
         * 线程池工作机制:每次接收一个任务时，线程池就会创建一个任务，直到当前线程数等于corePoolSize，如果等于corePoolSize后
         * 还有任务过来，就会提交到BlockingQueue<Runnable> workQueue（阻塞队列）中，当阻塞队列也满了，他会又起一个线程池，但是数量不能超过maximumPoolSize，
         */
//        ExecutorService executorService = new ThreadPoolExecutor();
    }
}
