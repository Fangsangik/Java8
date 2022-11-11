package com.example.java.Concurrent;

import java.util.Arrays;
import java.util.List;
import java.util.Objects;
import java.util.concurrent.CompletableFuture;
import java.util.concurrent.ExecutionException;
import java.util.function.BiFunction;
import java.util.stream.Collectors;

public class CompletableFuture2 {
    static boolean throwError = false;

    //hello가 끝난 후 world 호출
    public static void main(String[] args) throws ExecutionException, InterruptedException {
      /*
        CompletableFuture<String> hello = CompletableFuture.supplyAsync(() -> {
            System.out.println("Hello" + Thread.currentThread().getName());
            return "Hello";
        });

        CompletableFuture<String> future = hello.thenCompose(CompletableFuture2::getWorld);
        //이 작업 뒤에 이어서 추가적 작업을 할 수 있다. hello가 들어오면 그 뒤에 compose로 할 수 있다.
        System.out.println(future.get()); // => 둘을 연결한 하나의 future가 나오고, 이 future를 get을 하면 HelloWorld를 받을 수 있다.
        //두 future간에 의존성이 있는 경우


        private static CompletableFuture<String> getWorld (String message){
            return CompletableFuture.supplyAsync(() -> {
                System.out.println(message + Thread.currentThread().getName());
                return message + "World";
            });

        }

       */

        //둘이 서로 연관관계가 없는 경우, 둘이 동시에 비동기적으로 실행을 하는 방법
        // -> 둘이 따로 실행 하는 것 (의존해 있는 경우가 아니기에 따로 보내고, 둘다 결과가 왔을 때 무언가 하고 싶은 경우

        CompletableFuture<String> hello1 = CompletableFuture.supplyAsync(() -> {
            System.out.println("Hello" + Thread.currentThread().getName());
            return "Hello1";
        });

        CompletableFuture<String> world2 = CompletableFuture.supplyAsync(() -> {
            System.out.println("Hello" + Thread.currentThread().getName());
            return "World2";
        });

        //입력 값은 두개 결과값은 하나 => Bifunction을 사용
        CompletableFuture<String> future = hello1.thenCombine(world2, (h, w) -> h + "" + w);
        System.out.println(future.get()); // Bifunction에 해당하는 람다가 실행 (world2, (h, w) -> h + "" + w)
/*
        List<CompletableFuture> futures = Arrays.asList(hello1, world2);

        CompletableFuture<Void> future1= CompletableFuture.allOf(futures.toArray(futures.toArray(new CompletableFuture[futures.size()])))
                //두개 이상일때 여러 테스크를 합쳐서 실행 가능 -> allof에 해당하는 모든 task가 끝났을때 추가적인 callback을 실행 할 수 있다.
                //.thenAccept(System.out::println); // 특정한 결과를 가져 올 수 가 없는 이유 -> 모든 테스크들의 결과가 모두 동일하다는 보장 없고, Error 가능성 있다.
                        .thenApply(v->{
                            return futures.stream()
                                    .map(CompletableFuture::join)
                                    .collect(Collectors.toList());//future에서 발생하는 결과값을 모아서 List로
                            //get을 쓰게 되면 checkrecpetion이 발생한다. 대신 join을 발생 시킨다. join의 경우 unchecked exception을 발생한다.
                        })
                             //thenApply가 호출되는 시점에는 모든 future의 작업이 끝남
        System.out.println(future1.get()); // -> null
        //감싸면 void타입 결과가 초례

 */
        /*

        List<CompletableFuture<String>> futures = Arrays.asList(hello1, world2);
        CompletableFuture[] futuresArray = futures.toArray(new CompletableFuture[futures.size()]);

        CompletableFuture<List<Objects>> results = CompletableFuture.allOf(futuresArray)
                .thenApply(v -> futures.stream()
                        .map(CompletableFuture::join)
                        .collect(Collectors.toList());

          //List<String> objects = results.get();
    results.get().forEach(System.out::println);
    //이렇게 진행을 하면 아무것도 Blocking이 진행 되지 않는다. => 모든 작업을 기다렸다가 처리하는 방법

    }

         */

        //빨리 끝나는 결과 하나를 갖고 아무거나 결론
        CompletableFuture<Void> futures = CompletableFuture.anyOf(hello1, world2).thenAccept(System.out::println);
        futures.get();

        //예외처리
        //비동기적으로 작동하는 task안에서 error가 발생한다.
        BiFunction<? super String, Throwable, String> result;
        CompletableFuture<String> hello2 = CompletableFuture.supplyAsync(() -> {
            if (throwError) {
                throw new IllegalStateException();
            }

            System.out.println("Hello" + Thread.currentThread().getName());
            return "Hello";
        }).exceptionally(ex -> { //에러가 발생하면 exceptionally에서 에러 타입을 받아서 무언가를 리턴
            System.out.println(ex.toString());
            return "Error";
       /*
        }).handle(result, ex) -> {//handle의 경우 정상적과 비정상적 둘다 다룸
            if (ex ! = null ){
                System.out.println(ex);
                return "ERROR";
            }

            return result;
        }



        System.out.println(hello2.get());//Error를 무조건 던짐 => }).exceptionally(ex -> { 들어옴 => Error를 갖고 
    }        */

        });
    }
}