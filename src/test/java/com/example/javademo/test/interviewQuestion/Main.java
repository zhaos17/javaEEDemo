package com.example.javademo.test.interviewQuestion;

public class Main {

    public static void main(String[] args) {
        int[] ints = {0, 1, 0, 2, 1, 0, 1, 3, 2, 1, 2, 1};

        int sum = 0,leftMax = 0,rightMax = 0;

        for (int i = 1; i < ints.length - 1; i++) {
            leftMax = Math.max(leftMax,ints[i - 1]);
            rightMax = getMaxRight(ints,i,rightMax);
            int min = Math.min(leftMax,rightMax);
            if (min != 0) {
                sum += min - ints[i];
            }
        }
        System.out.println(sum);

    }

    public static int getMaxRight(int[] arrs,int i,int rightMax) {
        for (; i < arrs.length; i++) {
            rightMax = Math.max(rightMax,arrs[i]);
        }
        return rightMax;
    }

}
