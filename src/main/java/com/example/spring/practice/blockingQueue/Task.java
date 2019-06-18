package com.example.spring.practice.blockingQueue;

import java.util.List;

/**
 * @ClassName Task
 * @Descirption
 * @Author yizhendong
 * @Date 2019/3/20
 **/
public class Task {
    private List<String> job;

    public Task(List<String> job) {
        this.job = job;
    }

    public void printJob(){
        synchronized (this) {
            if (job != null && job.size() > 0){
                for (int i = 0;i<job.size();i++){
                    System.out.println(Thread.currentThread().getName() + ":" + job.get(i));
                }
            }
        }
    }

    public void moveJob(){
//        synchronized (this){
            if (job != null && job.size() > 0){
                for (int i = 0;i<job.size();i++){
                    System.out.println(Thread.currentThread().getName() + ":" + job.get(i));
                }
            }
//        }
    }
}
