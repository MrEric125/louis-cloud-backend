package com.louis.java8;

import java.util.concurrent.RecursiveTask;

/**
 * @author 80003996
 * <p>
 * Date: 2019/5/10
 * Description:
 */
public class ForkJoinSumCalculator extends RecursiveTask<Long> {

    private final long[] numbers;
    private final int start;
    private final int end;

    public static final long THRESHOLD = 10_000;

    public ForkJoinSumCalculator(long[] numbers) {
        this(numbers, 0, numbers.length);
    }
    private ForkJoinSumCalculator(long[] numbers, int start, int end) {
        this.numbers = numbers;
        this.start = start;
        this.end = end;
    }
    @Override
    protected Long compute() {
        int length = end - start;
        //等于阈值，顺序计算结果
        if (length <= THRESHOLD) {
            return computeSequentially();
        }
        //为数组的前半部分求和
        ForkJoinSumCalculator leftTask =
                new ForkJoinSumCalculator(numbers, start, start + length/2);
        leftTask.fork();
//        创建执行后半部分的结果
        ForkJoinSumCalculator rightTask =
                new ForkJoinSumCalculator(numbers, start + length/2, end);
        //同步执行第二个任务，有可能允许进一步递归划分
        Long rightResult = rightTask.compute();
//        读取第一个子任务的结果，如果尚未完成就等待
        Long leftResult = leftTask.join();

        return leftResult + rightResult;
    }
//    任务不可再分的时候执行计算的方法
    private long computeSequentially() {
        long sum = 0;
        for (int i = start; i < end; i++) {
            sum += numbers[i];
        }
        return sum;

    }
}
