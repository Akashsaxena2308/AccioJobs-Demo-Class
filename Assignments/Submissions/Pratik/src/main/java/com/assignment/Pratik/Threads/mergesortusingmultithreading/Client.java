package com.assignment.Pratik.Threads.mergesortusingmultithreading;

import java.util.List;
import java.util.concurrent.*;

public class Client {
    public static void main(String args[]) throws InterruptedException, ExecutionException {
        ExecutorService ex = Executors.newCachedThreadPool();

        List<Integer> ls = List.of(1, 4, 56, 3, 2, 43, 2, 3);

        Sorter t = new Sorter(ls, ex);

        Future<List<Integer>> res = ex.submit(t);
        ls = res.get();

        System.out.println(ls);
    }
}
