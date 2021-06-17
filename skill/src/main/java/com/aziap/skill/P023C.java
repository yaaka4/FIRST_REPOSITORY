package com.aziap.skill;

import java.util.*;
import java.util.stream.*;

public class P023C {
    public static void main(String[] args) {
        // 自分の得意な言語で
        // Let's チャレンジ！！
        Scanner sc = new Scanner(System.in);
        String line = sc.nextLine();
        
        // 当選番号
        final List<Integer> tousen = 
        Stream.of(line.split(" "))
            .mapToInt(Integer::parseInt)
            .mapToObj(Integer::valueOf)
            .collect(Collectors.toList());
        
        // くじ
        IntStream.range(0, Integer.parseInt(sc.nextLine()))
            .mapToObj(index -> Stream.of(sc.nextLine().split(" "))
                                .mapToInt(Integer::parseInt)
//                                .mapToObj(Integer::valueOf)
//                                .peek(System.out::println)
                                .map(num -> tousen.contains(num) ? 1 : 0)
                                .sum())
//            .peek(System.out::println)
            .forEach(System.out::println);
        
        sc.close();
    }
}
