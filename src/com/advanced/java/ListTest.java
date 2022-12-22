package com.advanced.java;

import java.util.ArrayList;
import java.util.List;

public class ListTest {

    public static void main(String[] args){
        Func();
    }
    static void Func() {

        List<Integer> list = new ArrayList<>();

        list.add(1);
        System.out.println(list.size());

        Func2(list);
        System.out.println(list.size());

        Func3(list);
        System.out.println(list.size());
    }

    static void Func2(List<Integer> list) {
        list = new ArrayList<>();
    }

    static void Func3(List<Integer> list) {
        list.add(2);
    }
}
