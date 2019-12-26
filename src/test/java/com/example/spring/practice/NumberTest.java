package com.example.spring.practice;

import org.junit.Test;

/**
 * @ClassName NumberTest
 * @Descirption
 * @Author yizhendong
 * @Date 25/11/2019
 **/
public class NumberTest {
    @Test
    public void numberTest(){
        int COUNT_BITS = Integer.SIZE - 3;
        System.out.println(COUNT_BITS);
        System.out.println(Integer.MIN_VALUE);
        int CAPACITY = ((1 << COUNT_BITS) - 1);
        System.out.println(CAPACITY);

        // runState is stored in the high-order bits
        int RUNNING    = -1 << COUNT_BITS;
        System.out.println(Integer.MIN_VALUE == RUNNING * 4);
        System.out.println(RUNNING);
        int result = RUNNING | 0;
        System.out.println(result);
        System.out.println(CAPACITY);
        System.out.println(result & CAPACITY);
        System.out.println(result & ~CAPACITY);
    }
}
