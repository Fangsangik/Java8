package com.example.java.Concurrent;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.ScheduledExecutorService;
import java.util.concurrent.TimeUnit;


/*
Executors는 Thread나 Runnable 처럼 low level api를 직접 다루는 것이 아닌
Thread를 만들고 관리하는 작업을 조금더 고수준의 api에 위임

Executors가 Thread를 만들고 Runnable 만 제공해주면 된다. Runnable 안에다가 해야 할 일만 제공해주면 된다.
Thread를 만들고 제거, 해당 스레드가 필요 없으면 종료 => 일련의 작업들을 Executor가 작업 해줌
 */
public class Executors1 {
    public static void main(String[] args) {

        //ScheduledExecutorService => ExecutorService를 상속을 받았음, Scheduled라는 메소드 제공
        // 특정시간 이후에 delay, 주기적으로 작업을 실행
        //Executors => shutdown, collarborate, runnable,
        ExecutorService executorService = Executors.newSingleThreadExecutor(); //static factory method를 사용, newSingleThreadExecutor => Thread 하나만 사용
        executorService.execute(new Runnable() { //  ExecutorService는 실행이 되면 다음 작업이 실행 될때 까지 대기를 하기 때문에 계속 실행중
            @Override
            public void run() {
                System.out.println("Thread:" + Thread.currentThread().getName());
            }
        }); // 내부에 Threadpool이 있음

        executorService.shutdown(); //graceful shutdowm - 현재 진행중인 프로그램을 끝내고 죽인다.
        //executorService.shutdownNow(); - 현재 돌고 있는 스레드를 바로 죽임

        ExecutorService executorService2 = Executors.newFixedThreadPool(2); // Thread를 2개 갖고 있는 executorservice
        executorService2.submit(getRunnable("Hello"));
        executorService2.submit(getRunnable("sangik"));
        executorService2.submit(getRunnable("papa"));
        executorService2.submit(getRunnable("mama"));
        executorService2.submit(getRunnable("pjy"));

        executorService2.shutdown();
        //Thread가 두개인데 처리가 다 된다.
        //main application에서 작업들을 -> executorservice에 작업 5개를 보내고, Thread Pool
        // -> Thread가 2개가 있는데, (T1, T2) & Blocking Queue => Thread가 처리양이 너무 많으면 작업들을 Queue에 쌓아둔다.

        ScheduledExecutorService executorService1 = Executors.newSingleThreadScheduledExecutor();
        executorService1.schedule(getRunnable("Hello"), 5, TimeUnit.SECONDS); //Hello를 5초 정도 있다가 실행을 해라
        executorService1.scheduleAtFixedRate(getRunnable("GoodBye"), 1,2, TimeUnit.SECONDS); // 1초 쉬고 2번씩 찍어라
        //executorService1.shutdown();

    }

    private static Runnable getRunnable(String message) {
        return () -> System.out.println(message + Thread.currentThread().getName());
        }
    }

    /*
    Future의 경우 부가적인 별도의 Thread에서 실행을 했는데 결과를 가져 오고 싶을때는 Runnable로 할 수 없다
    Runnable의 경우 => Void이기 때문이다

    단 Callable이라는 것이 있음 , Runnable과 동일한 기능이지만
    Return이 있다.
     */
