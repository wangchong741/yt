package com.demo;

import lombok.SneakyThrows;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.Future;
import java.util.concurrent.TimeUnit;

/**
 * TODO
 *
 * @author wangchong35962
 * @date 2021-06-03 17:03
 */
public class SendNewPersonCouponObserver implements Observer {
    ExecutorService pool = Executors.newFixedThreadPool(2);

    @Override
    public void update(String message) {
        //       第一种 异步发优惠券，有返回值
        Future<String> future = pool.submit(() -> {
            TimeUnit.SECONDS.sleep(3);
            return "发送新人优惠券1，返回结果";
        });
        try {
            System.out.println(future.get(4000,TimeUnit.MILLISECONDS));
        } catch (Exception e) {
//            执行异步获取失败
//            记录日志，定时任务重试等
            System.out.println("获取结果失败");
        }

//       第二种发优惠券的方式 不关心返回值结果
        Thread thread=new Thread(new Runnable() {
            @SneakyThrows
            @Override
            public void run() {
//                模拟服务调用
                TimeUnit.SECONDS.sleep(3);
                System.out.println("发送新人优惠券2");
            }
        });

        thread.start();
        System.out.println("执行异步返回");
    }

}
