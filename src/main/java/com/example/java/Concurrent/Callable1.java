package com.example.java.Concurrent;

import java.util.Arrays;
import java.util.List;
import java.util.concurrent.*;

/*
Hello가 1초, Java가 5초, Script가 3초 , Hello1 4초
=> invokeAll의 경우 앞에 내용들이 끝났더라도 다른 내용이 끝나지 않았으면 기다린다.
그 후에 4개의 result를 다 가져온다.

Server가 3대 인데 같은 file을 다 복사 해놓음
3군대에서 다 가져오라고 했을때 (동일 파일임) => 가장 먼저 온 것만 가져 올 수 있는 것 = invokeAny = Blocking call

 */

public class Callable1 {
    public static void main(String[] args) throws InterruptedException, ExecutionException {
       // ExecutorService executorService = Executors.newSingleThreadExecutor();
        ExecutorService executorService = Executors.newFixedThreadPool(4);

        Callable<String> hello = () -> {
            Thread.sleep(1000L);
            return "Hello";
        };

        Callable<String> Java = () -> {
            Thread.sleep(5000L);
            return "Java";
        };

        Callable<String> JavaScprit = () -> {
            Thread.sleep(3000L);
            return "Script";
        };

        Callable<String> hello1 = () -> {
            Thread.sleep(4000L);
            return "Hello1";
        };

        String s = executorService.invokeAny(Arrays.asList(hello, Java, JavaScprit, hello1));
        System.out.println(s); // 가장 짧은 시간이 호출이 되고 끝난다. => Hello1이 호출이 된 이유는
        // hello가 들어갔는데 그후 나머지가 들어 갈 자리가 없어서 다른 값이 나오게 됨


        //한번에 보낼 수 있다.
        List<Future<String>> futures = executorService.invokeAll(Arrays.asList(hello, Java, JavaScprit, hello1));
        for (Future<String> f:futures){
            System.out.println(f.get());
        }

        executorService.shutdown();


    }
}
