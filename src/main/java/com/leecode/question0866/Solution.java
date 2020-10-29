package com.leecode.question0866;

public class Solution {
    public int primePalindrome(int N) {
        return 0;
    }

    private boolean isPalindrome(int number){
        String numberString = String.valueOf(number);
        int head = 0;
        int tail = numberString.length() - 1;
        while (head < tail) {
            if (numberString.charAt(head) != numberString.charAt(tail)) {
                return false;
            }
            head++;
            tail--;
        }
        return true;
    }
    private int findNextPalindrome(int number) {
        String numberString = String.valueOf(number);
        int stringLength = numberString.length();
        
        return 0;
    }

    public static void main(String[] args) {
        System.out.println(new Solution().isPalindrome(12321));
    }
}
