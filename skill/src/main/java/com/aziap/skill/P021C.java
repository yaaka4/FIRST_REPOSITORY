package com.aziap.skill;

import java.util.*;
import java.util.stream.*;
import java.util.function.*;

public class P021C {
    public static void main(String[] args) {
        // 自分の得意な言語で
        // Let's チャレンジ！！
        Scanner sc = new Scanner(System.in);
        String line = sc.nextLine();
        
        // 台風
        final List<Integer> tyfoon = 
            Stream.of(line.split(" "))
                .mapToInt(Integer::parseInt)
                .mapToObj(Integer::valueOf)
                .collect(Collectors.toList());
        
        // 座標の行をList<Integer>にして取り出す関数
        final IntFunction<List<Integer>> positionListfunc = 
            index -> 
                Stream.of(sc.nextLine().split(" "))
                    .mapToInt(Integer::parseInt)
                    .mapToObj(Integer::valueOf)
                    .collect(Collectors.toList());
        
        // 暴風域判定関数
        final Function<List<Integer>, String> judgInTyfoon =
            pos -> {
                final int r = (int)Math.pow(pos.get(0) - tyfoon.get(0), 2)
                    + (int)Math.pow(pos.get(1) - tyfoon.get(1), 2);
                return (int)Math.pow(tyfoon.get(2), 2) <= r && r <= (int)Math.pow(tyfoon.get(3), 2) ? "yes" : "no";
            };
        
        // 暴風域判定
        IntStream.range(0, Integer.parseInt(sc.nextLine()))
            .mapToObj(positionListfunc)
            .map(judgInTyfoon)
            .forEach(System.out::println);
        
        sc.close();
    }
}
