package com.leecode.question0124;

import java.util.HashMap;
import java.util.Map;

public class Solution {
    private Map<TreeNode, NodeInfo> nodeMap = new HashMap<>();

    public int maxPathSum(TreeNode root) {
        if (root == null) {
            return 0;
        }
        getMaxOfChildTree(root);
        NodeInfo rootInfo = nodeMap.get(root);
        return max(rootInfo.outerMax, rootInfo.selfMax);
    }

    private void getMaxOfChildTree(TreeNode node) {
        nodeMap.putIfAbsent(node, new NodeInfo());
        NodeInfo currentInfo = nodeMap.get(node);
        if (node.left != null) {
            getMaxOfChildTree(node.left);
        }
        if (node.right != null) {
            getMaxOfChildTree(node.right);
        }
        if (node.left != null && node.right != null) {
            NodeInfo leftInfo = nodeMap.get(node.left);
            NodeInfo rightInfo = nodeMap.get(node.right);
            currentInfo.outerMax = max(node.val + leftInfo.outerMax, node.val + rightInfo.outerMax, node.val);
            currentInfo.selfMax = max(node.val + leftInfo.outerMax + rightInfo.outerMax, leftInfo.selfMax, rightInfo.selfMax, leftInfo.outerMax + node.val, rightInfo.outerMax + node.val, node.val);
        } else if (node.left != null) {
            NodeInfo leftInfo = nodeMap.get(node.left);
            currentInfo.outerMax = max(leftInfo.outerMax + node.val, node.val);
            currentInfo.selfMax = max(leftInfo.selfMax, node.val, leftInfo.outerMax + node.val, leftInfo.outerMax);
        } else if (node.right != null) {
            NodeInfo rightInfo = nodeMap.get(node.right);
            currentInfo.outerMax = max(rightInfo.outerMax + node.val, node.val);
            currentInfo.selfMax = max(rightInfo.selfMax, node.val, rightInfo.outerMax + node.val, rightInfo.outerMax);
        } else {
            currentInfo.outerMax = node.val;
            currentInfo.selfMax = node.val;
        }
    }

    private int max(int... args) {
        int maxValue = Integer.MIN_VALUE;
        for (int arg : args) {
            if (maxValue < arg) {
                maxValue = arg;
            }
        }
        return maxValue;
    }

    public static void main(String[] args) {
        TreeNode root = new TreeNode(-1);
        root.right = new TreeNode(9);
        root.right.left = new TreeNode(-6);
        root.right.right = new TreeNode(3);
        root.right.right.right = new TreeNode(-2);
        System.out.println(new Solution().maxPathSum(root));
    }
}

class NodeInfo {
    int outerMax;
    int selfMax;
}
