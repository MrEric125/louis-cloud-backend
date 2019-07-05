package com.louis.security;

import lombok.Getter;
import lombok.Setter;
import org.assertj.core.util.Lists;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;

import java.util.Comparator;
import java.util.List;

/**
 * @author John·Louis
 * @date create in 2019/6/16
 */
public class PasswordEncoderTests {


    public static void main(String[] args) {
//        int a = 5, b = 10;
//        System.out.println("" + a + "   " + b);

        BCryptPasswordEncoder encoder = new BCryptPasswordEncoder();
        String zhangsan = encoder.encode("admin");
        System.out.println(zhangsan);

    }

    private static void swap(int a, int b) {
        int temp = a;
        a = b;
        b = temp;
    }
}

@Setter
@Getter
class Student implements Comparable<Student>,Comparator{
    String id;
    String name;
    int age;


    public int aa(Student o) {
        System.out.println(o.name);
        for (char c : o.getName().toCharArray()) {
            System.out.println(c);
        }
        return this.name.compareTo(o.name);
    }

    @Override
    public int compareTo(Student o) {
        return this.name.compareTo(o.name);
    }

    @Override
    public int compare(Object o1, Object o2) {
        return 0;
    }

}
