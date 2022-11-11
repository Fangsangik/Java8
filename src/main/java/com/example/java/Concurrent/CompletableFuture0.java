package com.example.java.Concurrent;

public class CompletableFuture0 {}
    /*
    Concurrent Programing
    Concurrent Software => 동시에 작업 할 수 있는 소프트웨어
    한 어플리케이션 안에서도 동시에 여러 작업들이 동작을 한다.
    자바에서도 멀티스레드 멀티프로세싱이 가능

    자바에서 멀티스레드 하기
    메인 스레드 만드는 방법 두가지
    1) Thread 상속 받는 법 => Thread 나오는 순서는 정해져 있지 않음
       code 상으로는 Thread가 우선 실행 되었지만 Hello => Thread
    2) Runnabel을 만든다
    3) 람다를 만든다

    만든 Thread의 주요 기능 3가지
    1) sleep => 현재 Thread를 대기
    2) Interrupt => 자는 Thread를 깨우는 방법/ 인터럽트를 갖고 다른 스레드를 종료 시킴
    3) Join => 다른 스레드를 기다릐는 것


     */

    /*
    public static void main(String[] args) throws InterruptedException {
        MyThread myThread = new MyThread();
        myThread.start();
        System.out.println("Hello!");

     */

/*

        //Runnable 사용
        Thread thread = new Thread(new Runnable() {
            @Override
            public void run() {
                System.out.println("Thread1:" + Thread.currentThread().getName());
            }
        });
        thread.start();

 */

        /*
        //람다 (runnable이 functuional interface로 변환 되었기에 사용 가능)
        Thread thread1 = new Thread(() -> {
            //Thread 재움 => 다른 Thread가 먼저 처리 => 자버리기 때문에 메인 Thread 먼저 실행
            try {
                Thread.sleep(1000L);
            } catch (InterruptedException e) { // InterruptedException 자는 동안에 이 Thread를 깨우면 발생한다.

            }
            System.out.println("Thread2:" + Thread.currentThread().getName());

        });
        thread.start();

        System.out.println("Hello:" + Thread.currentThread().getName());

 */

/*
        //Interrupt 사용 => 무한 루프를 만들고, Thread를 제움/ 누군가가 Interrupt 하면 return 타입 X => 종료
        Thread thread2 = new Thread(() -> {
            while (true) {
                System.out.println("Thread:" + Thread.currentThread().getName());
            }
            try {
                Thread.sleep(1000L);
            } catch (InterruptedException e) { // <= 이 에러를 받으면 Thread를 종료
                System.out.println("Exit");
                return; // 종료를 하지 않으면 무한 루프를 돈다.
            }
        });
        thread2.start();

        //3초 정도 있다가 Thread를 Interrupt 단 Interrupt 자체는 종료는 아니다.
        System.out.println("Hello:" + Thread.currentThread().getName());
        Thread.sleep(3000L);
        thread2.interrupt();

 */
        //인터럽트를 받았음에도 리턴을 하지 않으면 => 무한루프를 돈다.
/*
        Thread thread3 = new Thread(() -> {
            while (true) {
                System.out.println("Thread:" + Thread.currentThread().getName());
            }
            try {
                Thread.sleep(1000L);
            } catch (InterruptedException e) {
                throw new IllegalStateException(e);
            }
        });

        //메인 스레드가 기다리도록 함 => Join을 하면 3초 스레드가 끝날때 까지 기다렸다가 그다음 라인이 실행이 된다.
        //스레드가 대기하는 도중에 누군가가 메인 스레드를 인터럽트를 하면 => InterruptedException이 발생한디
        thread3.start();
        System.out.println("Hello:" + Thread.currentThread().getName());
        thread3.join();
        System.out.println(thread3 + "is finished");
    }

    //1) Thread를 상속 받는 방법
    static class MyThread extends Thread {
        @Override
        public void run() {
            System.out.println("Thread:" + Thread.currentThread().getName());
        }
    }
}



 */