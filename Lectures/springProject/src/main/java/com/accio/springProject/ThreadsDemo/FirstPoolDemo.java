package com.accio.springProject.ThreadsDemo;

import org.springframework.http.converter.json.GsonBuilderUtils;

import java.util.concurrent.*;

public class FirstPoolDemo {

    public static void main(String[] args){
        try(ExecutorService pool = Executors.newFixedThreadPool(2)){
            Runnable report = () -> {
                System.out.println("Generating report on pool : " + Thread.currentThread().getName() );
            };

            //Callable --> Configure return types
            Callable<Integer> task = () -> {
                System.out.println("Generating report using callable on  : " + Thread.currentThread().getName());
                Thread.sleep(2000);
                return 50;
            };
            Future<Integer> res = pool.submit(task);
            Integer result = res.get();

            pool.submit(report);

            System.out.println(result);
        } catch (ExecutionException e) {
            throw new RuntimeException(e);
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }

    }
}
