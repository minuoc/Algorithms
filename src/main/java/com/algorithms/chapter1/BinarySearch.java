package com.algorithms.chapter1;

import java.util.ArrayList;
import java.util.List;

public class BinarySearch<T>{
    public static <T extends Comparable<? super T>> int binarySearch(List<T> list, T item){
        int low = 0;
        int high = list.size() - 1;

        while(low <= high){
            int mid = (low + high) / 2;
            T guess = list.get(mid);
            if (guess.compareTo(item) == 0){
                return mid;
            }else if(guess.compareTo(item) < 0){
                low = mid + 1;
            }else if (guess.compareTo(item) > 0){
                high = mid - 1;
            }
        }
        return -1;

    }


    public static void main(String[] args) {
        List<Integer> list = new ArrayList<>();
        for (int i = 1; i < 21; ++i) {
            list.add(i);
        }
        find(12,list);
        find(5,list);
        find(7,list);

    }

    public static void find(Integer value,List<Integer> list){
        System.out.println("value ["+value+"]" + " in position : " + BinarySearch.binarySearch(list,value));
    }




}
