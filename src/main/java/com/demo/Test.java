package com.demo;

/**
 * TODO
 *
 * @author wangchong35962
 * @date 2021-06-03 15:36
 */
public class Test {
    public static void main(String[] args) {
        ConcreteSubject subject = new ConcreteSubject();
        // 创建两个观察者 订阅主题
        OneObserver oneObserver = new OneObserver();
        TwoObserver twoObserver = new TwoObserver();
        subject.attach(oneObserver);
        subject.attach(twoObserver);
        // 发送内容
        subject.notifyObservers(" 哈哈哈哈哈");
        //输出结果  第一个观察者看到你发的内容了 哈哈哈哈哈
        //        第二个观察者看到你发的内容了 哈哈哈哈哈
        // 移除第二个观察者，取消订阅关系
        subject.detach(twoObserver);
        // 发送内容
        subject.notifyObservers(" 呵呵呵呵呵");
        //输出结果  第一个观察者看到你发的内容了 哈哈哈哈哈
    }
}
