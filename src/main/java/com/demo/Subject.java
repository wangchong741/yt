package com.demo;

/**
 * TODO
 *
 * @author wangchong35962
 * @date 2021-06-03 15:30
 */

public interface Subject {
    // 添加订阅关系
    void attach(Observer observer);
    // 删除订阅关系
    void detach(Observer observer);
    // 通知订阅者
    void notifyObservers(String message);
}
