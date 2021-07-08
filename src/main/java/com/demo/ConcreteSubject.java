package com.demo;

import java.util.ArrayList;
import java.util.List;

/**
 * TODO
 *
 * @author wangchong35962
 * @date 2021-06-03 15:33
 */

public class ConcreteSubject implements Subject {
    // 订阅者容器
    private List<Observer> observers=new ArrayList<>();

    @Override
    public void attach(Observer observer) {
        observers.add(observer);
    }

    @Override
    public void detach(Observer observer) {
        observers.remove(observer);
    }

    @Override
    public void notifyObservers(String msg) {
        observers.forEach(x->x.update(msg));
    }
}
