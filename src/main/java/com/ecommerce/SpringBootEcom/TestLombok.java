package com.ecommerce.SpringBootEcom;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.ToString;

@Builder
@ToString
@Data
@AllArgsConstructor
public class TestLombok {
    private String name;
    private int age;
}
