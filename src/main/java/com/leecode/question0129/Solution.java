package com.leecode.question0129;

import java.util.concurrent.BlockingQueue;
import java.util.concurrent.LinkedBlockingDeque;

/**
 * Definition for a binary tree node.
 * public class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode(int x) { val = x; }
 * }
 */
class Solution {
    public int sumNumbers(TreeNode root) {
        if (root == null){
            return 0;
        }
        BlockingQueue<TreeNode> queue = new LinkedBlockingDeque<>();
        int result = 0;
        TreeNode rootTemp = new TreeNode(root.val);
        rootTemp.left = root.left;
        rootTemp.right = root.right;
        queue.add(rootTemp);
        while (queue.size() > 0) {
            TreeNode currentNode = queue.poll();
            if (currentNode.left != null) {
                TreeNode leftTemp = new TreeNode(10 * currentNode.val + currentNode.left.val);
                leftTemp.left = currentNode.left.left;
                leftTemp.right = currentNode.left.right;
                queue.add(leftTemp);
            }
            if (currentNode.right != null) {
                TreeNode rightTemp = new TreeNode(10 * currentNode.val + currentNode.right.val);
                rightTemp.left = currentNode.right.left;
                rightTemp.right = currentNode.right.right;
                queue.add(rightTemp);
            }
            if (currentNode.left == null && currentNode.right == null) {
                result += currentNode.val;
            }
        }
        return result;
    }

    public static void main(String[] args) {
        TreeNode root = new TreeNode(4);
        root.left = new TreeNode(9);
        root.right = new TreeNode(0);
        root.left.left = new TreeNode(5);
        root.left.right = new TreeNode(1);
        System.out.println(new Solution().sumNumbers(root));
    }


}