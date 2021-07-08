package com.list;

import com.google.common.collect.ArrayListMultimap;
import com.google.common.collect.Multimap;

import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;

/**
 * TODO
 *
 * @author wangchong35962
 * @date 2021-06-24 15:57
 */
public class TestMap {
    public static void main(String[] args) {
        Map<String,String> map=new ConcurrentHashMap<>(4);
        map.put("2","a");
        System.out.println(map.getOrDefault("1","").toUpperCase());

        Multimap<String,Object> multimap= ArrayListMultimap.create();
        multimap.put("a","a");
        multimap.put("a","b");
        multimap.put("a",1);
        System.out.println(multimap);
        System.out.println(multimap.keySet());
        System.out.println(multimap.get("a"));
        System.out.println(multimap.entries());
        System.out.println(multimap.values());
    }
}
