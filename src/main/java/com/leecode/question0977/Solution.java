package com.leecode.question0977;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Solution {
    public int[] sortedSquares(int[] A) {
        if (A == null) {
            return null;
        }
        int[] result = new int[A.length];
         //先找到中间位置，这里有两种情况，第一种包含0，第二种不包含0
        int middle = 0;
        for (int i = 0; i < A.length; i++) {
            if (A[0] >= 0) {
                middle = 0;
                break;
            }
            if (i == A.length - 1) {
                middle = A.length - 1;
                break;
            }
            if (A[i] <= 0 && A[i + 1] > 0) {
                middle = i;
                break;
            }

        }
        int resultPointer = 0;
        int head = middle;
        int tail = middle + 1;
        while (true) {
            // 如果head tail均未越界，则比较二者，谁的绝对值小就把谁添加到结果数组
            // 绝对值小的方向指针远离一个单位
            if (head >= 0 && tail < A.length) {
                int headValue = A[head];
                int tailValue = A[tail];
                if (-headValue > tailValue) {
                    result[resultPointer] = tailValue * tailValue;
                    resultPointer ++;
                    tail ++;
                } else {
                    result[resultPointer] = headValue * headValue;
                    resultPointer ++;
                    head --;
                }
            } else if (head < 0 && tail < A.length) {
                result[resultPointer] = A[tail] * A[tail];
                resultPointer ++;
                tail ++;
            } else if (head >= 0) {
                result[resultPointer] = A[head] * A[head];
                resultPointer ++;
                head --;
            } else {
                break;
            }
        }
        return result;
    }

    public static void main(String[] args) {
        int[] test = new int[]{1,2,3};
        System.out.println(Arrays.toString(new Solution().sortedSquares(test)));
    }
}
