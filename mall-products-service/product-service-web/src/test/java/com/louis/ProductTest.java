package com.louis;

import org.junit.Test;

import java.math.BigDecimal;
import java.util.Random;

/**
 * @author louis
 * <p>
 * Date: 2019/9/27
 * Description:
 */

public class ProductTest {

    @Test
    public void test() {

        Random random = new Random();
        int index = random.nextInt(6);
        System.out.println(index);
    }

    private BigDecimal randomValue(int value) {
        double random = Math.random();
        System.out.println(random);
        return BigDecimal.valueOf(random);
    }
}
