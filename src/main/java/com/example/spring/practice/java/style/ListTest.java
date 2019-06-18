package com.example.spring.practice.java.style;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

/**
 * @ClassName listTest
 * @Descirption
 * @Author yizhendong
 * @Date 2019/4/4
 **/
public class ListTest {
    public static void main(String[] args) {
        List<String> list = new ArrayList<>();
        list.add("1");
        list.add("2");
        Iterator<String> iterator = list.iterator();
        while (iterator.hasNext()){
            String item = iterator.next();
            if (item != null){
                iterator.remove();
            }
        }
        for (String item : list){
            if (item.equals("2")){
                list.remove(item);
            }
        }


    }
}
