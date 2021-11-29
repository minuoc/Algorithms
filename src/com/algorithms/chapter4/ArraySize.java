package com.algorithms.chapter4;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class ArraySize<T> {
    public static void main(String[] args) {
        List<Integer> list = new ArrayList<>(Arrays.asList(new Integer[]{3,4,6,7,8,8,9,9,9,9,9}));
        System.out.println(list.size());
        ArraySize<Integer> s = new ArraySize<>();
        System.out.println(s.getArraySize(list));
    }

    public int getArraySize(List<T> array) {
        if (array.size() == 0){
            return 0;
        } else {
            return 1 + getArraySize(array.subList(1,array.size()));
        }
    }


}
