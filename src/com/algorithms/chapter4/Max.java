package com.algorithms.chapter4;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Max {
    public static void main(String[] args) {
        List<Integer> list = new ArrayList<>(Arrays.asList(new Integer[]{3,4,6,7,8,8,9,9,100}));
        System.out.println(getMax(list));
    }

    public static int getMax(List<Integer> list){
        if (list.size() == 1){
            return list.get(0);
        }
        List<Integer> bottomHalf = list.subList(0,list.size() / 2);
        int bottom = getMax(bottomHalf);

        List<Integer> topHalf = list.subList(list.size() / 2, list.size());
        int top = getMax(topHalf);
        return top > bottom ? top : bottom;
    }
}
