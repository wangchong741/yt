package com.demo;

/**
 * TODO
 *
 * @author wangchong35962
 * @date 2021-06-03 15:37
 */
public class TwoObserver implements Observer{
    @Override
    public void update(String message) {
        System.out.println("第二个观察者看到你发的内容了" + message);
    }
}
