package com.algorithms.chapter3;

public class CountDown {
    public static void main(String[] args) {
        countDown(5);
    }

    public static void countDown(int i) {
        System.out.println(i);
        if (i <= 0){
            return;
        }else {
            countDown(i - 1);
        }
    }
}
