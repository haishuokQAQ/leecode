package com.leecode.question5;

public class Solution {
	 public String longestPalindrome(String s) {
		 String result = "";
		 int length = s.length();
		 for (int i = 1; i < length; i++){
			 String currentResult = null;
			 int head = i - 1;
			 int tail = i;
			 if (s.charAt(head) == s.charAt(tail)) {
				 currentResult = getBackWord(s, head, tail);
			 }else if (tail + 1 < length && s.charAt(head) == s.charAt(tail + 1)) {
				 tail += 1;
				 currentResult = getBackWord(s, head, tail);
			 }else {
				 currentResult = "";
			 }
			 if (currentResult.length() > result.length()) {
				 result = currentResult;
			 }
			 
			 
		 }
		 return result;
	 }
	 
	 private String getBackWord(String s, int head, int tail) {
		 int length = s.length();
		 String result = "";
		 while (head >= 0 && tail <= length - 1 && s.charAt(head) == s.charAt(tail)) {
			 head --;
			 tail ++;
		 }
		 int resultLen = tail - head - 2 + 1;
		 result = s.substring(head + 1, resultLen);
		 return result;
	 }
	 
	 public static void main(String[] args) {
		Solution so = new Solution();
		System.out.println(so.longestPalindrome("aaaaaaaa"));;
	}
}
