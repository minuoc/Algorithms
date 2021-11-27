package com.algorithms.chapter3;

public class Factorial {
    public static void main(String[] args) {
        int i = factorial(10);
        System.out.println(i);
    }

    public static int factorial(int i){
        if (i == 1){
            return 1;
        }else {
            return i * factorial(i - 1);
        }
    }
}
