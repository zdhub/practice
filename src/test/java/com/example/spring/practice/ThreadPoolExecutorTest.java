package com.example.spring.practice;

import org.springframework.util.CollectionUtils;
import org.springframework.util.StopWatch;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.concurrent.*;

/**
 * @Description:
 * @vertion:1.0
 * @author:yizhendong
 * @date:2020/1/6 0:48
 */
public class ThreadPoolExecutorTest {


    public static void main(String[] args) {

        ExecutorService threadPoolExecutor = Executors.newFixedThreadPool(100);

        Long end = 1000000000L;
        StopWatch stopWatch1 = new StopWatch();
        stopWatch1.start();
        List<Future> futureList = new ArrayList<>();
        int partition = 20;
        for (int k = 0; k < partition; k++) {
            Future<Long> future = threadPoolExecutor.submit(new dataCallable(k * (end / partition), (k + 1) * (end / partition)));
            futureList.add(future);
        }

        if (!CollectionUtils.isEmpty(futureList)) {
            Long total = 0L;
            for (Future<Long> future : futureList) {
                try {
                    Long subResult = future.get(10, TimeUnit.SECONDS);
                    total = total + subResult;
                } catch (Throwable e) {
                    e.printStackTrace();
                }
            }
            System.out.println(total);
        }
        stopWatch1.stop();
        System.out.println(stopWatch1.getTotalTimeMillis());

        StopWatch stopWatch = new StopWatch();
        stopWatch.start();
        Map<Long, Long> map = new HashMap<>();
        Long result = 0L;

        for (Long i = 1L; i <= end; i++) {
            Long j = i % 10;
            result = result + j;
        }
        System.out.println(result);
        stopWatch.stop();
        System.out.println(stopWatch.getTotalTimeMillis());
    }

    static class dataCallable implements Callable<Long> {

        private long start;
        private long end;

        public dataCallable(long start, long end) {
            this.start = start;
            this.end = end;
        }

        @Override
        public Long call() throws Exception {
            Long result = 0L;
            for (Long i = start + 1; i <= end; i++) {
                result = result + i % 10;
            }
            return result;
        }
    }
}
