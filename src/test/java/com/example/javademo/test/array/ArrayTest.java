package com.example.javademo.test.array;

import com.example.javademo.utils.UUIDUtils;
import org.junit.jupiter.api.Test;

/**
 * @author: zhaos
 * @date: 2021/3/5
 */
public class ArrayTest {

    public static void main(String[] args) {
        System.out.println(UUIDUtils.fromString("1e8e89993bc1f60bb389785267527d9"));
    }

    /**
     * 是否为奇数
     * @param n
     * @return
     */
    public boolean isOdd (int n) {
        return (n & 1) == 1;
    }

    @Test
    public void arrayTest01() {
        /**
         * 1 2 3 4
         * 8 7 6 5
         * 9 10 11 12
         */
        int[][] arr = {{1,2,3,4},{8,7,6,5},{9,10,11,12}};
        for(int i = 0;i < arr.length;i++) {
            if (!isOdd(i)) {
                for (int j = 0; j < arr[i].length; j++) {
                    System.out.printf("%d ",arr[i][j]);
                }
            } else {
                for (int j = arr[i].length - 1; j > -1 ; j--) {
                    System.out.printf("%d ",arr[i][j]);
                }
            }
        }
    }

    @Test
    public void arrayTest02() {
        /**
         * 1 2 3 4
         * 8 7 6 5
         * 9 10 11 12
         *
         * 1 2 3 4 5 12 11 10 9 8 7 6
         */
        int[][] arr = {{1,2,3,4},{8,7,6,5},{9,10,11,12}};

        int row_start = 0,row_end = arr.length,col_start = 0,col_end = arr[0].length;
        huiwen(arr,row_start,row_end,col_start,col_end);

    }

    /**
     * 二维数组由外到内遍历
     * @param row_start
     * @param row_end
     * @param col_start
     * @param col_end
     */
    public void huiwen(int[][] arr,int row_start,int row_end,int col_start,int col_end) {
        /**
         * 1 2 3 4
         * 8 7 6 5
         * 9 10 11 12
         *
         * 1 2 3 4 5 12 11 10 9 8 7 6
         */
        // 从左到右
        for(int i = col_start;i < col_end;i++) {
            System.out.printf("%d ",arr[row_start][i]);
        }
        row_start++;
        // 从上到下
        for (int i = row_start; i < row_end; i++) {
            System.out.printf("%d ",arr[i][col_end - 1]);
        }
        col_end--;
        // 从右到左
        for (int i = col_end; i > col_start ; i--) {
            System.out.printf("%d ",arr[row_end - 1][i - 1]);
        }
        row_end--;
        // 从下到上
        for (int i = row_end; i > row_start ; i--) {
            System.out.printf("%d ",arr[i - 1][col_start]);
        }
        col_start++;
        col_end--;
        System.out.printf("%nrow_start:%d row_end:%d col_start:%d col_end:%d%n",row_start,row_end,col_start,col_end);
        if ((row_end - row_start) > 1 || (col_end - col_start) > 1) {
            huiwen(arr,row_start,row_end,col_start,col_end);
        }

    }

}
