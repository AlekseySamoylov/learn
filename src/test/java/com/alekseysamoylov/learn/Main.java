package com.alekseysamoylov.learn;

import java.util.Arrays;
import java.util.List;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;

public class Main {
    public static void main(String[] args) {
        Map<List<Long>, List<Integer>> map = new ConcurrentHashMap<>(6);
        List<Integer> list = map.get(Arrays.asList(1L, 2L));
        System.out.println(list);

    }
}
