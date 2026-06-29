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
    int preIdx = 0;

    public TreeNode buildTree(int[] preorder, int[] inorder) {
        return helper(preorder, inorder, 0, inorder.length - 1);
    }

    private TreeNode helper(int[] preorder, int[] inorder, int leftIdx, int rightIdx) {
        if(leftIdx > rightIdx)
            return null;

        TreeNode root = new TreeNode(preorder[preIdx++]);
        int splitIdx = 0;

        for(int i=leftIdx; i<=rightIdx; i++) {
            if(inorder[i] == root.val) {
                splitIdx = i;
                break;
            }
        }

        root.left = helper(preorder, inorder, leftIdx, splitIdx - 1);
        root.right = helper(preorder, inorder, splitIdx + 1, rightIdx);

        return root;
    }
}
