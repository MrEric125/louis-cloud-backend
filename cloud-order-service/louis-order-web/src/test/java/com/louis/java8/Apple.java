package com.louis.java8;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.io.Serializable;

@Setter
@Getter
@AllArgsConstructor
@NoArgsConstructor
public class Apple implements Serializable {

    private static final long serialVersionUID = -7507952202119661787L;

    private int weight;
    private String country;
    private int cost;

    public Apple(int weight, String country) {
        this.weight = weight;
        this.country = country;
    }
}