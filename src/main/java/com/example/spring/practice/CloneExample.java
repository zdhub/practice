package com.example.spring.practice;

/**
 * @ClassName CloneExample
 * @Descirption
 * @Author yizhendong
 * @Date 2019/4/3
 **/
public class CloneExample implements Cloneable{
    private int a;
    private int b;

    @Override
    public CloneExample clone() throws CloneNotSupportedException {
        return (CloneExample) super.clone();
    }
    public static void main(String[] args) {
        CloneExample cloneExample = new CloneExample();
        cloneExample.a = 1;
        cloneExample.b = 2;
        CloneExample copy;
        try {
            copy = cloneExample.clone();
            System.out.println(copy.a);
        } catch (CloneNotSupportedException e) {
            e.printStackTrace();
        }
    }
}
