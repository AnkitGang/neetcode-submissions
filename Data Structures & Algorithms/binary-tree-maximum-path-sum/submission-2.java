/**
 * Definition for a binary tree node.
 * public class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode() {}
 *     TreeNode(int val) { this.val = val; }
 *     TreeNode(int val, TreeNode left, TreeNode right) {
 *         this.val = val;
 *         this.left = left;
 *         this.right = right;
 *     }
 * }
 */

class Solution {
    int globalMax = Integer.MIN_VALUE;

    public int maxPathSum(TreeNode root) {
        maxSum(root);
        return globalMax;
    }

    private int maxSum(TreeNode root) {
        if(root == null)
            return 0;

        int leftMax = Math.max(0, maxSum(root.left));
        int rightMax = Math.max(0, maxSum(root.right));

        int sum = root.val + leftMax + rightMax;
        globalMax = Math.max(globalMax, sum);
        
        return root.val + Math.max(leftMax, rightMax);
    }
}
