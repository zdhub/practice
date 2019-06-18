package com.example.spring.practice.blockingQueue;

import java.util.ArrayList;
import java.util.concurrent.Callable;

/**
 * @ClassName ListCheck
 * @Descirption
 * @Author yizhendong
 * @Date 2019/3/20
 **/
public class ListCheck implements Callable<Integer> {
    private String checkValue;
    private ArrayList<String> checkList;

    public ListCheck(String checkValue, ArrayList<String> checkList) {
        this.checkValue = checkValue;
        this.checkList = checkList;
    }


    @Override
    public Integer call() throws Exception {
        int result = 0;
        if (checkList != null && checkList.size() > 0){
            for (int i = 0; i< checkList.size();i++){
                if (checkList.get(i).equals(checkValue)){
                    result++;
                }
            }
        }
        return result;
    }
}
