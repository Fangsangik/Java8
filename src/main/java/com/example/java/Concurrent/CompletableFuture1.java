package com.example.java.Concurrent;

import java.util.concurrent.*;
import java.util.concurrent.CompletableFuture;

/*
비동기 프로그램에 가까운 코딩에 가능 => 예외처리 X, 예외처리용 api 제공 X, 여러 Future를 조합 어려움

CompletableFuture의 경우 Future와 CompletionStage을 구현
Completable은 명시적으로 외부에서 complete을 시킬 수 있다.

몇 초 이내에 답이 없으면 미리 케쉬 해준 값이나 결과를 리턴
 */
public class CompletableFuture1 {
    public static void main(String[] args) throws ExecutionException, InterruptedException {
        ExecutorService executorService = Executors.newFixedThreadPool(4);
        Future<String> future = executorService.submit(() -> "hello");

        future.get(); // future을 갖고 get을 하기 전까지 그 어떠한 것도 할 수 없다.
        //future에서 준 결과값을 갖고 무언가를 하는 작업
        //future에서 뒤에서 준 결과값은 get 뒤에서 해야 한다.

        CompletableFuture<String> future1 = new CompletableFuture<>();
        future1.complete("Sangik");//future의 기본 값은 sangik이라고 지정

        System.out.println(future1.get());//get이 없어지는 것은 아니다.

        //비동기적 방식
        CompletableFuture<String> future2 = CompletableFuture.completedFuture("Sangik");
        System.out.println(future2.get());


        //실제로 어떤 작업을 실행하고 싶으면 -> return이 있고 없고
        //Return이 없는 경우 runAsync를 사용 -> return type이 달라짐 (generic type이 void로 바뀜)
        CompletableFuture<Void> future3 = CompletableFuture.runAsync(() -> {
            System.out.println("hello" + Thread.currentThread().getName());
        });// future을 정의 한거기에 여기 까지는 아무 일도 발생 X
        future3.get();

        //Returntype이 없는 경우
        CompletableFuture<String> future4 = CompletableFuture.supplyAsync(() -> {
            System.out.println("Hello" + Thread.currentThread().getName());
            return "Hello";
        }).thenApply((s) -> {
            System.out.println(Thread.currentThread().getName());
            return s.toUpperCase();
        }); // 결과가 왔을때 해당하는 콜백을 실행 하고 싶을때 thenApply + get을 호출 해야 함
        // callback을 get 호출 하기 전에는 불가능 했으나 get 호출 후에도 가능

        System.out.println(future4.get()); // get을 했을 때 위에 있는 코드 작업

        CompletableFuture<Void> future5 = CompletableFuture.supplyAsync(() -> {
            System.out.println("hello" + Thread.currentThread().getName());
            return "Hello";
        }).thenAccept((s) -> { // 콜백은 리턴 X => 받아서 사용 하기만 하면 된다. (thenAccept) -> consumer가 된다.
            System.out.println(Thread.currentThread().getName());
            System.out.println(s.toUpperCase());
        });
        future5.get();

        CompletableFuture<Void> future6 = CompletableFuture.supplyAsync(() -> {
            System.out.println("hello" + Thread.currentThread().getName());
            return "Hello";
        }).thenRun(() -> { //리턴을 받을 필요 X 무언가를 하기만 하면 된다 => thenRun
            System.out.println(Thread.currentThread().getName());//Runnable이 온다.
        });
        future6.get();

        /*
        비동기적으로 작업을 처리 했는데 Thread Pool을 형성 하지 않고 어찌 결과를 처리 한걸까?
         ==> ForkJoinPool로 인해서 가능
         이는 executor 구현체에서 구현한 것인데, 작업을 workstealing (DQ를 사용 = 마지막으로 들어온것 먼저 나감)
         자기 스레드가 할일 이 없으면 스레드가 디큐에서 할일을 가져 와서 함
         서브테스크들을 다른 스레드에 일을 부여
         */
/*
       // ExecutorService executorService1 = Executors.newFixedThreadPool(4);

        만든 것을 supplyAsync라는 메소드 호출 할때 두번째 인자로 줄 수 있다.
        supplyAsync, RunAsync 두개 function 호출하는 작업을 thread pool 호출 하는데 사용 => pool의 이름이 달라짐
        thenApply, thenRun 또한 마찬가지

        이러한 콜백을 실현한 어떤 pool을 다른 곳에서 사용 하고 싶을 때는 thenRunAsync을 사용
         */

    }
}

