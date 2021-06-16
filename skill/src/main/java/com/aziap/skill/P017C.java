package com.aziap.skill;

import java.util.*;
import java.util.stream.*;
import java.util.function.*;

public class P017C {
    public static void main(String[] args) {
        // 自分の得意な言語で
        // Let's チャレンジ！！
        Scanner sc = new Scanner(System.in);
        String line = sc.nextLine();
        
        // 子カードの行をList<Integer>にして取り出す関数
        final IntFunction<List<Integer>> pickUpListfunc = 
            index -> 
                Stream.of(sc.nextLine().split(" "))
                    .mapToInt(Integer::parseInt)
                    .mapToObj(Integer::valueOf)
                    .collect(Collectors.toList());
        
        // 親カード
        final List<Integer> parent = 
        Stream.of(line.split(" "))
            .mapToInt(Integer::parseInt)
            .mapToObj(Integer::valueOf)
            .collect(Collectors.toList());
        
        // High/Low判定関数
        final Function<List<Integer>, String> judgHighLow =
//            ch -> ch.get(0) < parent.get(0) ? "High" : ch.get(0) > parent.get(0) ? "Low" : ch.get(1) > parent.get(1) ? "High" : "Low";
            ch -> {
                if(ch.get(0) < parent.get(0)) {
                    return "High";
                } else if(ch.get(0) > parent.get(0)) {
                    return "Low";
                } else {
                    if(ch.get(1) > parent.get(1)) {
                        return "High";
                    } else {
                        return "Low";
                    }
                }
            };
        
        // 子カード
        IntStream.range(0, Integer.parseInt(sc.nextLine()))
            .mapToObj(pickUpListfunc)
            .map(judgHighLow)
            .forEach(System.out::println);
        
        sc.close();
    }
}
