package com.aziap.skill;

import java.util.*;
import java.util.stream.*;

public class P049C {
    public static void main(String[] args) {
        // 自分の得意な言語で
        // Let's チャレンジ！！
        Scanner sc = new Scanner(System.in);
        String line = sc.nextLine();
        
        final List<Integer> inputList = 
        IntStream.range(0, Integer.parseInt(line) + 1)
            .map(index -> index == 0 ? 1 : Integer.parseInt(sc.nextLine()))
            .mapToObj(Integer::valueOf)
            .collect(Collectors.toList());
        
        final int result = 
        IntStream.range(0, inputList.size() - 1)
            .map(index -> Math.abs(inputList.get(index) - inputList.get(index + 1)))
            .sum();

        System.out.println(result);
        sc.close();
    }
}
