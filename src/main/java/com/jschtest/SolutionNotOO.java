package com.jschtest;

public class SolutionNotOO {
	public ListNode addTwoNumbers(ListNode l1, ListNode l2) {
		ListNode pointer1 = l1;
		ListNode pointer2 = l2;
		boolean added = false;
		while (pointer1 != null && pointer2 != null) {
			//先检查是否为null
			if (pointer1.next == null && pointer2.next != null) {
				pointer1.next = pointer2.next;
			}
			if (pointer1 == pointer2) {
				if (added) {
					pointer1.val ++;
				}
				if (pointer1.val >= 10) {
					pointer1.val -= 10;
					added = true;
				}else {
					added = false;
				}
				pointer1 = pointer1.next;
				pointer2 = pointer2.next;
				continue;
			}
			//如果p1长于p2那么p2的值当作0处理1
			long p2 = pointer2 == null? 0: pointer2.val;
			pointer1.val += p2;
			//算进位
			if (added) {
				pointer1.val ++;
			}
			if (pointer1.val >= 10) {
				pointer1.val -= 10;
				added = true;
			}else {
				added = false;
			}
			pointer1 = pointer1.next;
			if (pointer2 != null) pointer2 = pointer2.next;
		}
		return l1;
	}

	
	
	public boolean solveAdded(ListNode l, boolean added) {
		if (added) {
			l.val ++;
		}
		if (l.val >= 10) {
			l.val -= 10;
			return true;
		}
		return false;
	}
	
	public static void main(String[] args) {
		SolutionNotOO so = new SolutionNotOO();

		ListNode l1 = Solution.parseNode(123445124);
		ListNode l2 = Solution.parseNode(421544321);
		long now = System.nanoTime();
		ListNode result = so.addTwoNumbers(l1, l2);
		System.out.println(System.nanoTime() - now);
		System.out.println(Solution.parseLong(result));
	}
}
