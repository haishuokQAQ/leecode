package com.leecode.question0143;

import java.util.ArrayList;
import java.util.List;

public class Solution {
    public void reorderList(ListNode head) {
        int length = 0;
        List<ListNode> listNodeList = new ArrayList<>();
        ListNode pointer = head;
        while (pointer != null) {
            listNodeList.add(pointer);
            length ++;
            pointer = pointer.next;
        }
        for (int i = 0; i < length; i++) {
            if (length - i - 2<= i) {
                break;
            }
            int tailPos = length - i - 1;
            ListNode tailNode = listNodeList.get(tailPos);
            ListNode originNext = listNodeList.get(i).next;
            ListNode originFormer = listNodeList.get(tailPos - 1);
            originFormer.next = tailNode.next;
            listNodeList.get(i).next = tailNode;
            tailNode.next = originNext;
        }
    }

    public static void main(String[] args) {
        ListNode head = new ListNode(1);
        ListNode two = new ListNode(2);
        ListNode three = new ListNode(3);
        ListNode four = new ListNode(4);
        ListNode five = new ListNode(5);
        head.next = two;
        two.next = three;
        three.next = four;
        four.next = five;
        new Solution().reorderList(head);
        ListNode pointer = head;
        while (pointer != null) {
            System.out.println(pointer.val);
            pointer = pointer.next;
        }
    }
}
