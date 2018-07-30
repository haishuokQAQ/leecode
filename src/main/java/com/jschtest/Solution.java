package com.jschtest;

class Solution {
    public ListNode addTwoNumbers(ListNode l1, ListNode l2) {
    	long l1Num = parseLong(l1);
    	long l2Num = parseLong(l2);
    	
    	return parseNode(l1Num + l2Num);
    }
    
    
    public static long parseLong(ListNode l) {
    	long realValue = 0;
    	long plus = 1;
    	ListNode pos = l;
    	while (pos != null) {
    		realValue += pos.val * plus;
    		plus *= 10;
    		pos = pos.next;
    	}
    	return realValue;
    }
    
    public static ListNode parseNode(long l) {
    	ListNode root = new ListNode(-1);
    	ListNode now = root;
    	if (l == 0) {
    		return new ListNode(0);
    	}
    	while (l > 0) {
    		now.next = new ListNode((int) (l % 10));
    		now = now.next;
    		l /= 10;
    	}
    	return root.next;
    }
    
    
    public static void main(String[] args) {
		long l = Long.parseLong("12314124142");
		ListNode root = parseNode(l);
		ListNode p = root;
		while (p != null) {
			System.out.print(p.val + " -> ");
			p = p.next;
		}
		System.out.println(parseLong(root));
		ListNode l1 = parseNode(123445124);
		ListNode l2 = parseNode(421544321);
		long now = System.nanoTime();
		Solution so = new Solution();
		ListNode result = so.addTwoNumbers(l1, l2);
		System.out.println(System.nanoTime() - now);
		System.out.println(parseLong(result));
    }
    
    static class LinkNumber{
        private long realValue;
        
        public void parseNum(String str){
            String value = str;
            if (str.startsWith("(") && str.endsWith(")"))
                value = value.substring(1, str.length() - 1);
            String[] nums = value.split("->");
            int plus = 1;
            for (String num : nums) {
            	int current = Integer.parseInt(num.trim());
            	realValue += current * plus;
            	plus *= 10;
            }
        }
     
    }
    
}