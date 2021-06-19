package com.aziap.skill;

import java.util.*;

public class P090C {
    public static void main(String[] args) {
        // 自分の得意な言語で
        // Let's チャレンジ！！
        Scanner sc = new Scanner(System.in);
        String line = sc.nextLine();
        
        final int result = 
        Arrays.asList(line.split(""))
            .stream()
            .filter(ch -> !ch.equals("-"))
            .mapToInt(Integer::parseInt)
            .map(num -> num == 0 ? ((num + 12) * 2) : ((num + 2) * 2))
//            .peek(System.out::println)
            .sum();
        
        System.out.println(result);
        sc.close();
    }
}
