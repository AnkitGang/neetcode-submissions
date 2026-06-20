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
    public boolean isValidBST(TreeNode root) {
        if (root == null)
            return true;

        return validate(root, Integer.MIN_VALUE, Integer.MAX_VALUE);
    }
    
    private boolean validate(TreeNode root, int minVal, int maxVal) {
        if (root == null)
            return true;

        if(root.val <= minVal || root.val >= maxVal)
            return false;

        boolean left = validate(root.left, minVal, root.val);
        boolean right = validate(root.right, root.val, maxVal);

        return left && right;
    }
}
