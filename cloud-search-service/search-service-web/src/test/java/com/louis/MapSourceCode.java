package com.louis;

import org.junit.Test;

import java.util.HashMap;
import java.util.Map;

/**
 * @author louis
 * <p>
 * Date: 2019/7/12
 * Description:
 */
public class MapSourceCode {


    @Test
    public void mapTest() {

        HashMap<String, String> maps = new HashMap<>();
        maps.put("zhangsan", "1");
        maps.put("lisi", "2");
        String zhangsan = maps.get("zhangsan");
        System.out.println(maps);

    }

    @Test
    public void test2() {
        HashMap<Integer, String> map = new HashMap(16);
        map.put(7, "");
        map.put(11, "");
        map.put(43, "");
        map.put(59, "");
        map.put(19, "");
        map.put(3, "");
        map.put(35, "");

        System.out.println("遍历结果：");
        for (Integer key : map.keySet()) {
            System.out.print(key + " -> ");
        }
        System.out.println();

        HashMap<Integer, String> map1 = new HashMap(32);
        map1.put(7, "");
        map1.put(11, "");
        map1.put(43, "");
        map1.put(59, "");
        map1.put(19, "");
        map1.put(3, "");
        map1.put(35, "");

        System.out.println("遍历结果：");
        for (Integer key : map1.keySet()) {
            System.out.print(key + " -> ");
        }


    }
}
