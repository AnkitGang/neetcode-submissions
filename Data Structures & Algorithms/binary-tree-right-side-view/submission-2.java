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
    List<Integer> list = new ArrayList<>();

    public List<Integer> rightSideView(TreeNode root) {
        if(root != null)
            rsv(root, 1);
        
        return list;
    }

    private void rsv(TreeNode root, int depth) {
        if(root == null)
            return;

        if(depth > list.size())
            list.add(root.val);
        
        rsv(root.right, depth + 1);
        rsv(root.left, depth + 1);
    }
}
