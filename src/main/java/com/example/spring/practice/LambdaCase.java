package com.example.spring.practice;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

/**
 * @ClassName LambdaCase
 * @Descirption
 * @Author yizhendong
 * @Date 2019/4/3
 **/
public class LambdaCase {
    public static void main(String[] args) {
        List<String> list = new ArrayList<>();
        list.add("123");
        list.add("234");
        List<String> list2 = new ArrayList<>();
        list2 = list.stream().map(string -> {
            return string + "test";
        }).collect(Collectors.toList());
        list2.stream().forEach(str->System.out.println(str));

    }
}
