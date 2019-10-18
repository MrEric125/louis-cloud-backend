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
        String payChannel = null;
        BigDecimal price = BigDecimal.valueOf(54.21);

        int value=payChannel == null ? null : (int) (price.doubleValue() * 0.2);
    }

    private BigDecimal randomValue(int value) {
        double random = Math.random();
        System.out.println(random);
        return BigDecimal.valueOf(random);
    }
}
