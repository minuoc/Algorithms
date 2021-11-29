package com.algorithms.chapter1;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;

public class SelectSort {
//    public static List<Integer> selectionSort(List<Integer> arr){
//        List<Integer> arr2 = new ArrayList<>();
//        while(!arr.isEmpty()){
//            int smallextIndex = findSmallest(arr);
//            arr2.add(arr.remove(smallextIndex));
//        }
//        return arr2;
//
//    }
//    public static  int findSmallest(List<Integer> arr){
//        int smallest = arr.get(0);
//        int index = 0;
//        for (int i = 0; i < arr.size(); i++){
//            if (arr.get(i) < smallest){
//                smallest = arr.get(i);
//                index = i;
//            }
//        }
//        return index;
//    }

    public static List<Integer> selectionSort(List<Integer> arr){
        for (int i = 0; i < arr.size(); i ++) {
            int min = i;
            for (int j = i+1; j < arr.size(); j++){
                if (arr.get(j) < arr.get(min)){
                    min = j;
                }
            }
            if (i != min){
                Collections.swap(arr,i,min);
            }
        }
        return arr;
    }

    public static void main(String[] args) {
        List<Integer> list = new ArrayList<Integer>(Arrays.asList(5,3,6,2,10));
        List<Integer> sortedList = selectionSort(list);
        System.out.println(sortedList);
    }
}
