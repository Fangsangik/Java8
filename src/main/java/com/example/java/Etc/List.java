package com.example.java.Etc;

import java.util.Arrays;
import java.util.Random;
import java.util.stream.IntStream;

/*
Fork/Join framework를 사용해서 배열을 정렬
알고리즘의 효율이 변화 한 것은 아니지만, paralle(sort)
 */
public class List {
    public static void main(String[] args) {
        int size = 1500;
        int [] numbers = new int[size];
        Random random = new Random();

        IntStream.range(0, size).forEach(i->numbers[i] = random.nextInt()); // 1500개를 랜덤하게 체워즈고
        long start = System.nanoTime();
        Arrays.sort(numbers);//sort는 thread를 하나만 사용
        System.out.println("serial sorting Took" + (System.nanoTime() - start));

        IntStream.range(0, size).forEach(i->numbers[i] = random.nextInt());//값을 다시 램덤하게 채워주고
        start=System.nanoTime();
        Arrays.parallelSort(numbers);
        //parrelsort의 경우 -> 배열있으면 2,4,1,5,9,8,7 =>2,4,1 || 5,9,8,7 => 2 || 4,1 나눈 후 다시 합침 124
        //쪼개고 합치고 한다. 이를 여러 스레드에 분산해서 사용
        System.out.println("parallel sorting took" + (System.nanoTime() - start));
    }

}
