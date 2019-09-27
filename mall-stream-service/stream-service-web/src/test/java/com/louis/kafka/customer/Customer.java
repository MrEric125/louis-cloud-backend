package com.louis.kafka.customer;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
 * @author John·Louis
 * @date create in 2019/8/7
 * description:
 */
@AllArgsConstructor
@NoArgsConstructor
@Data
public class Customer {

    private String name;
    private String address;
}
