package com.algorithms;

/**
 * 求出最大连续子序列和
 */
public class MaxSubSum1 {
    public static void main(String[] args) {
        int[] a = new int[]{0,-2,11,-4,13,-5,-2};
        int max = findGreatestSumOfArray(a);
        System.out.println(max);
    }

    /**
     * 暴力解法
     * @param a
     * @return
     */
    public static int maxSubSum1(int a[]) {
        int i, j, k;
        int maxSum = 0, thisSum;
        for (i = 0; i < a.length -1; i++) {
            for (j = i; j < a.length - 1; j++) {
                thisSum = 0;
                for (k = i; k <= j; k++) {
                    thisSum += a[k];
                    if (thisSum > maxSum) {
                        maxSum = thisSum;
                    }
                }
            }

        }
        return maxSum;

    }

    public static int maxSubSum2(int a[]) {
        int i, j;
        int maxSum = 0, thisSum;
        for (i = 0; i < a.length - 1; i++) {
            thisSum = 0;
            for (j = i; j < a.length - 1; j++) {
                thisSum += a[j];
                if (thisSum > maxSum) {
                    maxSum = thisSum;
                }
            }
        }
        return maxSum;
    }

    /**
     * 分治
     */
    public static int findGreatestSumOfArray(int[] arr){
        if (arr.length == 1){
            return arr[0];
        }
        int max = arr[0];
        int cur = arr[0];
        for (int i = 1; i < arr.length; i++){
            cur += arr[i];
            if (cur < arr[i]){
                cur = arr[i];
            }
            max = Math.max(cur,max);
        }
        return max;
    }


}
