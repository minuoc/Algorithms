package com.algorithms.chapter4;

import java.util.Arrays;
import java.util.List;

public class Sum {
    public static void main(String[] args) {
        List<Integer> list = Arrays.asList(new Integer[]{4,5,6,10});
        int sum = sum(list);
        System.out.println(sum);
    }

    public static int sum(List<Integer> list) {
        if (list.size() == 0){
            return 0;
        }else {
            List<Integer> subList = list.subList(1, list.size());
            return list.get(0) + sum(subList);
        }

    }
}
