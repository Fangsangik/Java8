package com.example.java.Java8to11.InterFaceAndLambda;

public class Foo {
    public static void main(String[] args) {
/*
        // 이러한 클래스를 익명 내부 클래스
        RunSomething runSomething = new RunSomething() {
            @Override
            public void doit() {
                System.out.println("Hello");
            }
        };
 */
/*
//alt + shift Enter = 람다 표현식 (함수형 인터페이스를 람다 형태의 표현하는 식) & 출력 값이 한줄일 경우에만 람다식으로 가능
        RunSomething runSomething1 = () ->
                System.out.println("Hello"); // 코드를 많이 줄일 수 있음.
        runSomething1.doit();
//여러 줄일 경우
        RunSomething runSomething2 = () ->
            System.out.println("Hello");
            System.out.println("Lambda");
        };

 */

/*
람다 익스프레션을 사용 하면 다른 언어에 있는 것을 사용 한 것 처럼 보이지만
특수한 형태의 Object라고 보면 된다
() -> System.out.println("Hello"); =할당=> runSomething
특수한 형태를 메소드의 파라미터에 전달을 하거나 이 자체를 리턴한다. => 즉, 자바에서 함수형 프로그래밍을 할때 firstclassObject를 할 수 있다

/*

/*
고차함수란
함수가 함수를 파라미터로 받는 다던가
함수가 함수를 리턴 할때 가능
자바에서는 특수한 함수의 형태가 Object이기에 가능
*/

/*
순수함수란
수학적인 함수
return type 있으면 좋음
 */

/*
      RunSomething runSomething3 = (number) -> {
          return number + 10;// 입력 받은 값의 결과 값이 동일 해야 한다.
// 보장 해주지 못하는 상황이 나타나면 함수형 프로그램밍이라고 보기 어려움
          // Interface에서 int (int number); 값 설정
        // 결과는 11로 동일해야 함
*/
/*
        // 함수 안에서 밖에 있는 값을 참조 해서 쓰는 겨우 or 외부에 있는 값을 변경 하려는 경우 => 순수한 함수라고 X
        RunSomething runSomething = new RunSomething() {
            int baseNumber = 10; // 함수 밖에 있는 값

            @Override
            public void doit( int number) {
                baseNumber++;
                return number+baseNumber; // error
            }
        };// 이런 경우에는 pure한 함수로 보기 힘들다

   }

 */
 /*
        //밖에 있는 값을 참조만 하는경우 가능 이는 local variable로 참조만 하는 겨우 단, final이라는 가정 하에 사용
       final int baseNumber = 10; // 함수 밖에 있는 값
        RunSomething runSomething = new RunSomething() {
            @Override
            public int doit( int number) {
                return number+baseNumber; // error
            }
        };
        basenumber ++ ;
  */

    }
}






