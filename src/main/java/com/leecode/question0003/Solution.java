package com.leecode.question0003;

import java.util.HashMap;
import java.util.Map;

public class Solution {
	public int lengthOfLongestSubstring(String s) {
		int max = 0;
        Map<Character, Integer> posMap = new HashMap<>();
        /*for (int head = 0,tail = 0, length = s.length(); head < length && tail < length;) {
        	while(tail < length && !posMap.containsKey(s.charAt(tail)) ) {
            	max = Integer.max(max, tail - head + 1);
        		posMap.put(s.charAt(tail), tail + 1);
        		tail ++;
        	}
        	if (tail < length) {
        		posMap.put(s.charAt(tail), tail);
        		head = Integer.max(posMap.get(s.charAt(tail)),head);
        		tail ++;
        		
        	}
        }*/
        for (int head = 0, tail = 0, length = s.length();tail < length; tail ++) {
        	if (posMap.containsKey(s.charAt(tail))) {
        		head = Math.max(posMap.get(s.charAt(tail)), head);
        	}
        	max = Math.max(max, tail - head + 1);
        	posMap.put(s.charAt(tail), tail + 1);
        }
		return max;
    }
	public static void main(String[] args) {
		Solution solution = new Solution();
		System.out.println(solution.lengthOfLongestSubstring("dvbdf"));
	}
}
