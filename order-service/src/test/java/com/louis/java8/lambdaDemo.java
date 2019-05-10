package com.louis.java8;

import com.google.common.collect.Comparators;
import com.google.common.collect.Maps;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.assertj.core.util.Lists;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import java.util.*;
import java.util.concurrent.Callable;
import java.util.concurrent.ForkJoinPool;
import java.util.concurrent.ForkJoinTask;
import java.util.function.Function;
import java.util.function.Supplier;
import java.util.stream.Collectors;
import java.util.stream.IntStream;
import java.util.stream.LongStream;
import java.util.stream.Stream;

/**
 * @author 80003996
 * <p>
 * Date: 2019/5/10
 * Description:
 * 关于函数式编程，记住几个要点，参数为什么类型（Function,Consumer,Supplier,Predicate）
 * 它的泛型类型是什么，最后返回的是什么，name在满足条件的所有方法都可以作为行为参数化
 */
public class lambdaDemo {

    private Map<String,String> map = Maps.newHashMap();
    private long beganTime;
    private long end;

    private List<String> list = Lists.newArrayList();
    @After
    public void after() {
        end = System.currentTimeMillis();
        System.out.println(end - beganTime);
    }

    @Before
    public void before() {
        String keyA = "A";
        String keyB = "B";
        String keyC = "C";
        String keyD = "D";
        String keyE = "E";
        String keyF = "F";
        String keyG = "G";
        String keyH = "H";
        map.put(keyA, "str01A");
        map.put(keyB, "str01B");
        map.put(keyC, "str01C");

        list.add("hello");
        list.add("world");
        beganTime = System.currentTimeMillis();

    }

    @Test
    public void test1() {

        Runnable runnable = () -> System.out.println("hello world 1");
        runnable.run();
    }




    @Test
    public void testBiConsumer() {
        map.forEach((x,y)-> System.out.println(x + y));
    }

    @Test
    public void testBiFunction() {

        map.merge("A", "mergeA", String::concat);
        String message = "message";
        map.compute("D", (s, str) -> str != null ? s.concat(str) : message);
        System.out.println(map);
    }

    @Test
    public void testBinaryOperator() {
        Map<Integer, Integer> integerMap = Maps.newHashMap();
        List<Integer> numList = Lists.newArrayList();
        Integer integer = numList.stream().reduce(Integer::sum).orElse(0);
        System.out.println(integer);
        Integer reduce = numList.stream().reduce(10, Integer::sum);
        System.out.println(reduce);
    }

    private void process(Function<String, String> function) {
        function.apply("z");
    }

    private String get(String s) {
        System.out.println(s);
        return s;
    }

    @Test
    public void test2() throws Exception {
        Callable<Apple> aNew = Apple::new;
        Supplier<Apple> appleSupplier = Apple::new;
        System.out.println(appleSupplier.get().country);
        Apple call = aNew.call();
        System.out.println(call.weight);
        process(this::get);

    }
    @Test
    public void test3() {
//        Comparator<Apple> appleComparator = Comparator
//                .comparing(Apple::getWeight)
//                .reversed()
//                .thenComparing(Apple::getCountry);
        long began = System.currentTimeMillis();
        Function<Integer, Integer> f = x -> x + 1;
        Function<Integer, Integer> g = x -> x * 2;
        Function<Integer, Integer> h = f.andThen(g);
        Integer apply = h.apply(9);
        long endTime = System.currentTimeMillis();
        System.out.println(endTime-began);
        System.out.println(apply);
    }
    @Test
    public void test4(){
        List<String> collect = map
                .entrySet()
                .stream()
                .filter(Objects::nonNull)
                .map(x -> x.getKey() + x.getValue()).collect(Collectors.toList());
//                .limit(2)
        collect.forEach(System.out::println);
        List<String[]> collect1 = list
                .stream()
                .map(x -> x.split(""))
                .distinct()
                .collect(Collectors.toList());
        for (String[] strings : collect1) {
            for (String string : strings) {
                System.out.println(string);
            }
        }
    }

    @Test
    public void test5() {
        List<String> collect2 = list.stream().map(x -> x.split("")).flatMap(Arrays::stream).collect(Collectors.toList());
        collect2.forEach(System.out::println);
        List<Integer> integerList = Lists.newArrayList(1,2,3);
        int sum = 0;
        for (Integer integer : integerList) {
            sum += integer;
        }
        System.out.println(sum);
        Integer reduce = integerList.stream().reduce(0, Integer::sum);
        System.out.println(reduce);
        //计算流所消耗的时间是否为线性增加的
        test4();
        test3();
        try {
            test2();
        } catch (Exception e) {
            e.printStackTrace();
        }
        test1();
        test7();
        test6();

//        integerList.stream().collect(Collectors::groupingBy)
    }

    @Test
    public void test6() {
        for (String s : list) {
            String[] split = s.split("");
            for (String s1 : split) {
                System.out.println(s1);
            }
        }
    }

    @Test
    public void test7() {
        Apple apple1 = new Apple(11, "china");
        Apple apple2 = new Apple(21, "china");
        Apple apple3 = new Apple(31, "china");
        Apple apple4 = new Apple(12, "Japan");
        Apple apple5 = new Apple(22, "Japan");
        Apple apple6 = new Apple(32, "Japan");
        List<Apple> appleList = Lists.newArrayList(apple1, apple2, apple3, apple4, apple5, apple6);
        String collect = appleList.stream().map(Apple::getCountry).collect(Collectors.joining(","));
        System.out.println(collect);
        Map<String, List<Apple>> collect1 = appleList.stream().collect(Collectors.groupingBy(Apple::getCountry));
        collect1.entrySet().forEach(System.out::println);
    }

    @Test
    public void test8() {
        System.out.println("Parallel range sum done in:" +
                measureSumPerf(this::forkJoinSum, 10_000_0000) +
                " msecs");

    }
    @Test
    public void test9() {
        System.out.println("Parallel range sum done in:" +
                measureSumPerf(this::forkJoinSum, 10_000_0000) +
                " msecs");
    }

    @Test
    public void test10() {
        final String SENTENCE =
                " Nel mezzo del cammin di nostra vita " +
                        "mi ritrovai in una selva oscura" +
                        " ché la dritta via era smarrita ";

        Stream<Character> characterStream = IntStream.range(0, SENTENCE.length()).mapToObj(SENTENCE::charAt);

        System.out.println("found " + countWords(characterStream) + " words");

    }

    private int countWords(Stream<Character> stream) {
        WordCounter wordCounter = stream.reduce(new WordCounter(0, true),
                WordCounter::accumulate,
                WordCounter::combine);
        return wordCounter.getCounter();
    }





    public long forkJoinSum(long n) {
        long[] array = LongStream.rangeClosed(0, n).toArray();

        long l = System.currentTimeMillis();
        ForkJoinTask<Long> joinSumCalculator = new ForkJoinSumCalculator(array);
        Long invoke = new ForkJoinPool().invoke(joinSumCalculator);
        long l1 = System.currentTimeMillis();
        System.out.println("true time"+(l1-l));
        return invoke;

    }

    public long sequentialSum(long l) {
        return Stream
                .iterate(1L, i -> i + 1)
                .limit(l)
                .reduce(0L, Long::sum);
    }

    public long parallelSum(long n) {
        return Stream
                .iterate(1L, i -> i + 1)
                .limit(n)
                .parallel()
                .reduce(0L, Long::sum);
    }




    public long measureSumPerf(Function<Long, Long> adder, long n) {
        long fastest = Long.MAX_VALUE;
        for (int i = 0; i < 10; i++) {
            long start = System.currentTimeMillis();
            long sum = adder.apply(n);
            long duration = (System.currentTimeMillis() - start) ;
            System.out.println("Result: " + sum);
            if (duration < fastest) fastest = duration;
        }
        return fastest;
    }

    public  long rangedSum(long n) {
        return LongStream.rangeClosed(1, n).reduce(0, Long::sum);
    }

    public  long parallelRangedSum(long n) {
        return LongStream.rangeClosed(1, n).parallel().reduce(0, Long::sum);
    }








    @Setter
    @Getter
    @AllArgsConstructor
    @NoArgsConstructor
    private class Apple{


        private int weight;

        private String country;
    }
}

class WordCounter {
    private final int counter;
    private final boolean lastSpace;
    public WordCounter(int counter, boolean lastSpace) {
        this.counter = counter;
        this.lastSpace = lastSpace;
    }
    public WordCounter accumulate(Character c) {
        if (Character.isWhitespace(c)) {
            return lastSpace ?
                    this :
                    new WordCounter(counter, true);
        } else {
            return lastSpace ?
                    new WordCounter(counter + 1, false) :
                    this;
        }
    }
    public WordCounter combine(WordCounter wordCounter) {
        return new WordCounter(counter + wordCounter.counter,
                wordCounter.lastSpace);
    }
    public int getCounter() {
        return counter;
    }
}






