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
    boolean status = true;

    public boolean isBalanced(TreeNode root) {
        if(root == null)
            return true;

        heightOfTree(root);
        return status;
    }

    private int heightOfTree(TreeNode root) {
        if(root == null) 
            return 0;

        int leftHeight = heightOfTree(root.left);
        int rightHeight = heightOfTree(root.right);
        
        if(!status)
            return 0;

        if(Math.abs(leftHeight - rightHeight) > 1) {
            status = false;
            return 0;
        }

        return Math.max(leftHeight, rightHeight) + 1;
    }
}
