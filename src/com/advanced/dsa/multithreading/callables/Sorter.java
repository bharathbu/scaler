package com.advanced.dsa.multithreading.callables;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.Callable;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.Future;

public class Sorter implements Callable<List<Integer>> {

    private List<Integer> arrayToSort;
    private ExecutorService exec = Executors.newCachedThreadPool();

    public Sorter(List<Integer> arrayToSort){
        this.arrayToSort = arrayToSort;
    }
    /**
     * @return
     * @throws Exception
     */
    @Override
    public List<Integer> call() throws Exception {
        int n = arrayToSort.size();
        if(n<=1){
            return arrayToSort;
        }
        int mid = n/2;

        List<Integer> leftArray = new ArrayList<>();
        List<Integer> rightArray = new ArrayList<>();

        for (int i = 0; i < mid; i++) {
            leftArray.add(arrayToSort.get(i));
        }
        for (int i = mid; i < n; i++) {
            rightArray.add(arrayToSort.get(i));
        }

        Sorter leftSorter = new Sorter(leftArray);
        Sorter rightSorter = new Sorter(rightArray);

        Future<List<Integer>> leftSortedFuture = exec.submit(leftSorter);
        Future<List<Integer>> rightSortedFuture = exec.submit(rightSorter);

        List<Integer> result = new ArrayList<>();
        int i=0,j=0;
        List<Integer> leftHalf = leftSortedFuture.get(); // code will not go ahead if we dont get the actual sorted array here
        List<Integer> rightHalf = rightSortedFuture.get();
        while(i<leftHalf.size() && j <rightHalf.size()){
            if(leftHalf.get(i) < rightHalf.get(j))
                result.add(leftHalf.get(i++));
            else result.add(rightHalf.get(j++));
        }
        while(i<leftHalf.size())
            result.add(leftHalf.get(i++));
        while(j<rightHalf.size())
            result.add(rightHalf.get(j++));

        return result;
    }
}
