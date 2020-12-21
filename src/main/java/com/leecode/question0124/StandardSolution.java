package com.leecode.question0124;

public class StandardSolution {
    int maxSum = Integer.MIN_VALUE;

    public int maxPathSum(TreeNode root) {
        maxGain(root);
        return maxSum;
    }

    public int maxGain(TreeNode node) {
        if (node == null) {
            return 0;
        }
        int leftGain = Math.max(maxGain(node.left), 0);
        int rightGain = Math.max(maxGain(node.right), 0);
        int currentPrice = node.val + leftGain + rightGain;
        maxSum = Math.max(maxSum, currentPrice);
        return node.val + Math.max(leftGain, rightGain);
    }
}
