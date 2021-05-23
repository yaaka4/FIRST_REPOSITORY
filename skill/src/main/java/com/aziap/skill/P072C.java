package com.aziap.skill;

import java.util.*;
import java.util.stream.*;
import java.util.function.*;

public class P072C {
    public static void main(String[] args) {
        // 自分の得意な言語で
        // Let's チャレンジ！！
        Scanner sc = new Scanner(System.in);
        String line = sc.nextLine();
        
        // ステータス
        final List<Integer> status = 
            Stream.of(line.split(" "))
                .mapToInt(Integer::parseInt)
                .mapToObj(Integer::valueOf)
                .collect(Collectors.toList());
        
        // 進化先をList<String>にして取り出す関数
        final IntFunction<List<String>> evolutionTable = 
            index -> 
                Stream.of(sc.nextLine().split(" "))
                    .collect(Collectors.toList());
        
        // 進化先判定関数
        final Function<List<String>, String> judgEvolution =
            table -> {
                if(Integer.parseInt(table.get(1)) <= status.get(0)
                        && status.get(0) <= Integer.parseInt(table.get(2)) 
                        && Integer.parseInt(table.get(3)) <= status.get(1) 
                        && status.get(1) <= Integer.parseInt(table.get(4))
                        && Integer.parseInt(table.get(5)) <= status.get(2)
                        && status.get(2) <= Integer.parseInt(table.get(6))) {
                    return table.get(0);
                } else {
                    return "";
                }
            };
        
        // 進化先表示
        final long streamCount = IntStream.range(0, Integer.parseInt(sc.nextLine()))
            .mapToObj(evolutionTable)
            .map(judgEvolution)
            .filter(evo -> evo.length() > 0)
            .peek(System.out::println)
            .count();
        
        if(streamCount == 0) {
            System.out.println("no evolution");
        }
    }
}