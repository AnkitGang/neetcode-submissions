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
    int count = 0;
    
    public int goodNodes(TreeNode root) {
        if(root == null)
            return count;

        countGoodNodes(root, root.val);

        return count;
    }

    private void countGoodNodes(TreeNode root, int maxVal) {
        if(root == null)
            return;

        if(root.val >= maxVal) { 
            count++;
            maxVal = root.val;
        }
        
        countGoodNodes(root.left, maxVal);
        countGoodNodes(root.right, maxVal);
    }
}
