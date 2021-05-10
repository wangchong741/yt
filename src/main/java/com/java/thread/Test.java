package com.java.thread;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

/**
 * TODO
 *
 * @author wangchong35962
 * @date 2021-03-29 18:40
 */
public class Test {
    public static void main(String[] args) {
        List<User> users=new ArrayList<>();
        users.add(new User("1","a"));
        users.add(new User("1","a"));
        users.add(new User("3","b"));
        users.add(new User("3","b"));
        System.out.println(users);
        Map<String, Long> collect = users.stream().collect(Collectors.groupingBy(User::union, Collectors.counting()));
        System.out.println(collect);
        List<String> collect1 = collect.entrySet().stream().filter(x -> x.getValue() > 1).map(y -> y.getKey()).collect(Collectors.toList());
        System.out.println(collect1);
    }

}
