package com.leecode.question0002;

public class SolutionNotOO {
	public ListNode addTwoNumbers1(ListNode l1, ListNode l2) {
        ListNode dummyHead = new ListNode(0);
    ListNode p = l1, q = l2, curr = dummyHead;
    int carry = 0;
    while (p != null || q != null) {
        int x = (p != null) ? p.val : 0;
        int y = (q != null) ? q.val : 0;
        int sum = carry + x + y;
        carry = sum / 10;
        curr.next = new ListNode(sum % 10);
        curr = curr.next;
        if (p != null) p = p.next;
        if (q != null) q = q.next;
    }
    if (carry > 0) {
        curr.next = new ListNode(carry);
    }
    return dummyHead.next;
    }
	public ListNode addTwoNumbers(ListNode l1, ListNode l2) {
		ListNode pointer1 = l1;
		ListNode pointer2 = l2;
		int add = 0;
		while (pointer1 != null || pointer2 != null) {
			//先检查是否为null
			if (pointer1 != null &&pointer1.next == null && pointer2 != null &&pointer2.next != null) {
				pointer1.next = pointer2.next;
			}
			int valA = pointer1.val;
			int valB = pointer2 == null? 0 :pointer2.val;
			if (pointer1 == pointer2) {
				valA += add;
				add = valA / 10;
				pointer1.val  = valA % 10;
			}else {
			//如果p1长于p2那么p2的值当作0处理1
			valA += valB + add;
			add = valA / 10;
			pointer1.val = valA % 10;
			}
			if (pointer1 != null && pointer1.next == null && (pointer2 == null || pointer2.next == null) && add > 0) {
				pointer1.next = new ListNode(0);
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

		ListNode l1 = Solution.parseNode(99);
		ListNode l2 = Solution.parseNode(9);
		long now = System.nanoTime();
		ListNode result = so.addTwoNumbers(l1, l2);
		System.out.println(System.nanoTime() - now);
		System.out.println(Solution.parseLong(result));
	}
}
