package com.designpatterns.prototype.registry;

import java.util.HashMap;
import java.util.Map;

public class StudentRegistry<T> {
    private Map<String,T> map;

    public StudentRegistry() {
        this.map = new HashMap<>();
    }

    void register(String s,T student){
        map.put(s,student);
    }

    T get(String batchName){
        return map.get(batchName);
    }
}
