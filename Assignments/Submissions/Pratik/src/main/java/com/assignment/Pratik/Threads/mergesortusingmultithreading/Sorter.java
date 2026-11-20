package com.assignment.Pratik.Threads.mergesortusingmultithreading;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.Callable;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Future;

public class Sorter implements Callable<List<Integer>> {
    List<Integer> arrayToSort;
    ExecutorService ex;

    Sorter(List<Integer> arrayToSort, ExecutorService ex){
        this.arrayToSort = arrayToSort;
        this.ex = ex;
    }

    public List<Integer> call() throws Exception{
        if (arrayToSort.size() <= 1){
            return arrayToSort;
        }

        int mid = arrayToSort.size() / 2;

        List<Integer> leftHalf = new ArrayList<>();
        for (int i = 0; i < mid; i++){
            leftHalf.add(arrayToSort.get(i));
        }

        List<Integer> rightHalf = new ArrayList<>();
        for (int i = mid; i < arrayToSort.size(); i++){
            rightHalf.add(arrayToSort.get(i));
        }

        Sorter task1 = new Sorter(leftHalf, ex);
        Sorter task2 = new Sorter(rightHalf, ex);

        Future<List<Integer>> leftSortedArray = ex.submit(task1);
        Future<List<Integer>> rightSortedArray = ex.submit(task2);

        leftHalf = leftSortedArray.get();
        rightHalf = rightSortedArray.get();

        List<Integer> finalMergedArray = new ArrayList<>();
        int i = 0, j = 0;

        while (i < leftHalf.size() && j < rightHalf.size()){
            if (leftHalf.get(i) < rightHalf.get(j)){
                finalMergedArray.add(leftHalf.get(i));
                i++;
            }else{
                finalMergedArray.add(rightHalf.get(j));
                j++;
            }
        }

        while (i < leftHalf.size()){
            finalMergedArray.add(leftHalf.get(i));
            i++;
        }

        while (j < rightHalf.size()){
            finalMergedArray.add(rightHalf.get(j));
            j++;
        }

        return finalMergedArray;
    }
}
