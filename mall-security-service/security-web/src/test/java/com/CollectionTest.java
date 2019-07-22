package com;

import com.google.common.collect.Maps;
import org.junit.Test;

import java.util.HashMap;


/**
 * @author John·Louis
 * <p>
 * Date: 2019/5/20
 * Description:
 */
public class CollectionTest {

    @Test
    public void test01() {
        HashMap<Object, Integer> hashMap = Maps.newHashMap();
        hashMap.putIfAbsent("K", 1);
        hashMap.merge("K", 2, (oldVal, newVal) -> oldVal + newVal);
        System.out.println(hashMap.get("K"));

    }
}
