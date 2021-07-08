package com.demo;

/**
 * TODO
 *
 * @author wangchong35962
 * @date 2021-06-03 17:17
 */
public class SendSuccessMessageObserver implements Observer{
    @Override
    public void update(String message) {
        System.out.println("发送注册成功短信息");
    }


    public static void main(String[] args) {
        ConcreteSubject subject = buildSubject();
        subject.notifyObservers("注册成功");
    }

    private static ConcreteSubject buildSubject() {
        ConcreteSubject subject = new ConcreteSubject();
        subject.attach(new SendSuccessMessageObserver());
        subject.attach(new SendNewPersonCouponObserver());
        return subject;
    }
}
