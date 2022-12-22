package com.advanced.java;

import java.sql.SQLOutput;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Collector;
import java.util.stream.Collectors;

public class StreamTest {
    public static void main(String[] args){
        int[] arr = {1,2,3,4,5,6,7,8,9};
        //foreach
        Arrays.stream(arr).filter(i -> i%2==1).forEach(y -> System.out.println(y));
        //reduce to single value
        int odd = Arrays.stream(arr).filter((i -> i%2==1)).sum();
        int even = Arrays.stream(arr).filter((i -> i%2==0)).reduce(0,(ans,i1) -> ans+i1);
        System.out.println(even);
        System.out.println(odd);

        List<Integer> numsList = new ArrayList<>();
        numsList.add(1);numsList.add(2);numsList.add(3);numsList.add(4);numsList.add(5);numsList.add(6);numsList.add(7);numsList.add(8);numsList.add(9);
        //collect
        List<Integer> list = numsList.stream().filter(x -> x % 2 == 0).collect(Collectors.toList());
        list.stream().forEach(x->System.out.println(x));
        int ans1 = list.stream().reduce(0,(ans,i)->ans+i);
        //int ans1 = list.stream().filter((i -> i%2 == 0) ).
        System.out.println(ans1);

    }
}
