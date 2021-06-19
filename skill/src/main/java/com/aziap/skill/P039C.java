package com.aziap.skill;

import java.util.*;

public class P039C {
    public static void main(String[] args) {
        // 自分の得意な言語で
        // Let's チャレンジ！！
        Scanner sc = new Scanner(System.in);
        String line = sc.nextLine();

        final int result = Arrays.asList(line.split(""))
            .stream()
            .mapToInt(ch -> ch.equals("<") ? 10 : (ch.equals("/") ? 1 : 0))
//            .peek(System.out::println)
            .sum();
        
        System.out.println(result);
        sc.close();
    }
}
