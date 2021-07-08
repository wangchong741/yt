package com.demo;

/**
 * TODO
 *
 * @author wangchong35962
 * @date 2021-06-03 15:35
 */
public class OneObserver implements Observer{
    @Override
    public void update(String message) {
        System.out.println("第一个观察者看到你发的内容了" + message);
    }
}
