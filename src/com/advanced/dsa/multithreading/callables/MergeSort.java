package com.advanced.dsa.multithreading.callables;

import java.util.Arrays;
import java.util.List;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.Future;

public class MergeSort {
    public static void main(String[] args) throws ExecutionException, InterruptedException {
        List<Integer> list = Arrays.asList(7, 4, 3, 9, 1, 8, 2, 6);
        ExecutorService exec = Executors.newCachedThreadPool();
        Sorter s = new Sorter(list);
        Future<List<Integer>> sortedListFuture = exec.submit(s);
        List<Integer> res = sortedListFuture.get();
        System.out.println(res);
        exec.shutdown();
    }
}
