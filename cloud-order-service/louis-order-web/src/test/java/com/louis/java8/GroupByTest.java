package com.louis.java8;

import org.assertj.core.util.Lists;
import org.junit.Before;

import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

/**
 * @author 80003996
 * <p>
 * Date: 2019/5/10
 * Description:
 */
public class GroupByTest {


     List<Apple> apples = null;

    @Before
    public void before() {
        Apple apple1 = new Apple(11, "china",9);
        Apple apple2 = new Apple(21, "china",13);
        Apple apple3 = new Apple(31, "china",17);
        Apple apple4 = new Apple(12, "Japan",11);
        Apple apple5 = new Apple(22, "Japan",15);
        Apple apple6 = new Apple(32, "Japan", 19);
        apples = Lists.newArrayList(apple1, apple2, apple3, apple4, apple5, apple6);

    }


    public  void test() {

        Map<String, Integer> collect = apples
                .stream()
                .collect(Collectors.groupingBy(Apple::getCountry, Collectors.summingInt(Apple::getCost)));
        System.out.println(collect);

    }




}

