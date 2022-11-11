package com.example.java.Concurrent;

import java.util.concurrent.*;

public class CallableFuture {
    public static void main(String[] args) throws ExecutionException, InterruptedException {
        ExecutorService executorService = Executors.newSingleThreadExecutor();

        //Runnable과 차이는 Return 할 수 있는 값이 다르다.
        Callable<String> hello = () -> {
            Thread.sleep(2000L);
            return "Hello";
        };

        //executorService.submit(hello); // submit을 하면 Future를 받을 수 있었다.
        Future<String> helloFuture = executorService.submit(hello);
        //isDone => 끝났으면 True, 아직 안끝났으면 False
        System.out.println(helloFuture.isDone());
        System.out.println("Started");

        //helloFuture.get();//get을 만난 순간 멈춤 = 블로킹
        helloFuture.cancel(true);//취소할 수 있는 기능 - true -> 취소 , false -> 기다림

        // 하지만 cancel을 하게 되면 get을 해서 가져 올 수 없다. 그리고 cancle을 하게 되면 isdone은 무조건 True가 된다.
        // 아무리 인터럽트를 한다 한들 값을 가져오려고 하면 Error가 된다.

        System.out.println(helloFuture.isDone());
        System.out.println("End");
        executorService.shutdown();
    }
}
