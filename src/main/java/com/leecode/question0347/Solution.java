package com.leecode.question0347;

import java.util.HashMap;
import java.util.Map;

public class Solution {
    public int[] topKFrequent(int[] nums, int k) {
        Map<Integer, Node> nodeMap = new HashMap<>();
        Node tailNode = null;
        for (int num : nums) {
            Node node;
            if (!nodeMap.containsKey(num)) {
                node = nodeMap.get(num);
                node.increaseCounter();
                nodeMap.put(num, node);
            } else {
                node = new Node(1);
                node.setPrevious(tailNode);
                tailNode = node;
            }
            while(node.getPrevious() != null && node.getCounter() > node.getPrevious().getCounter()) {
                Node previous = node.getPrevious();
                previous.setNext(node.getNext());
                node.setNext(previous);
                node.setPrevious(previous.getPrevious());
                previous.setPrevious(node);
            }
        }

        return null;
    }
    public static void main(String[] args) {

    }
}
