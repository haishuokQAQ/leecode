package com.leecode.question0347;

import java.util.*;
import java.util.concurrent.atomic.AtomicInteger;

public class Solution {
    public int[] topKFrequent(int[] nums, int k) {
        Map<Integer, Node> nodeMap = new HashMap<>();
        Node tailNode = null;
        Node headNode = null;
        for (int num : nums) {
            Node node;
            if (!nodeMap.containsKey(num)) {
                node = new Node(1, num);
                node.setPrevious(tailNode);
                if (tailNode != null) {
                    tailNode.setNext(node);
                }
                if (tailNode == null) {
                    headNode = node;
                }
                tailNode = node;
                nodeMap.put(num, node);
            } else {
                node = nodeMap.get(num);
                node.increaseCounter();
            }
            while(node.getPrevious() != null && node.getCounter() > node.getPrevious().getCounter()) {
                Node previous = node.getPrevious();
                previous.setNext(node.getNext());
                node.setNext(previous);
                node.setPrevious(previous.getPrevious());
                previous.setPrevious(node);
            }
        }
        List<Integer> resultList = new ArrayList<>();
        int nowK = 0;
        Node pointer = headNode;
        while (nowK < k) {
            resultList.add(pointer.getValue());
            if (pointer.getNext() == null || pointer.getNext().getCounter() != pointer.getCounter()) {
                nowK ++;
            }
            pointer = pointer.getNext();
        }
        int[] result = new int[resultList.size()];
        final AtomicInteger index = new AtomicInteger(0);
        resultList.forEach(item -> {
            result[index.get()] = item;
            index.incrementAndGet();
        });
        return result;
    }
    public static void main(String[] args) {
        int[] nums = new int[]{1,1,1,2,2,3};
        System.out.println(Arrays.toString(new Solution().topKFrequent(nums, 2)));
    }
}
