package com.leecode.question116;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;

// Definition for a Node.
class Node {
    public int val;
    public Node left;
    public Node right;
    public Node next;

    public Node() {}

    public Node(int _val) {
        val = _val;
    }

    public Node(int _val, Node _left, Node _right, Node _next) {
        val = _val;
        left = _left;
        right = _right;
        next = _next;
    }
};

class Solution {
    public Node connect(Node root) {
        if (root == null) {
            return root;
        }
        Node currentNode = root;
        Node currentLevelHead = root;
        while(true) {
            if (currentNode.left != null) {
                currentNode.left.next = currentNode.right;
                if (currentNode.next != null) {
                    currentNode.right.next = currentNode.next.left;
                }
            }
            if (currentNode.next != null) {
                currentNode = currentNode.next;
            } else if (currentLevelHead.left != null) {
                currentLevelHead = currentLevelHead.left;
                currentNode = currentLevelHead;
            } else {
                break;
            }
        }
        return root;
    }

    public static void main(String[] args) throws JsonProcessingException {
        String testData = "{\"left\":{\"left\":{\"left\":null,\"next\":null,\"right\":null,\"val\":4},\"next\":null,\"right\":{\"left\":null,\"next\":null,\"right\":null,\"val\":5},\"val\":2},\"next\":null,\"right\":{\"left\":{\"left\":null,\"next\":null,\"right\":null,\"val\":6},\"next\":null,\"right\":{\"left\":null,\"next\":null,\"right\":null,\"val\":7},\"val\":3},\"val\":1}";
        Node root = testDecode(testData);
        Node result = new Solution().connect(root);
        System.out.println(encode(result));
    }

    private static Node testDecode(String nodeJson) throws JsonProcessingException {
        ObjectMapper mapper = new ObjectMapper();
        return mapper.readValue(nodeJson, Node.class);
    }
    private static String encode(Node root) throws JsonProcessingException {
        ObjectMapper mapper = new ObjectMapper();
        return mapper.writeValueAsString(root);
    }
}