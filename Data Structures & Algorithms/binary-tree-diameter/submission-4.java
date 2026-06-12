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
    public int diameterOfBinaryTree(TreeNode root) {
        if(root == null) 
            return 0;

        return dfs(root);
    }

    private int dfs(TreeNode root) {
        int maxDiameter = 0;
        Stack<TreeNode> stack = new Stack<>();
        Map<TreeNode, Integer> depthMap = new HashMap<>();          
        TreeNode lastVisited = null;
        TreeNode curr = root;

        while(curr != null || !stack.isEmpty()) {
            while(curr != null) {
                stack.push(curr);
                curr = curr.left;
            }

            TreeNode peekNode = stack.peek();

            if(peekNode.right != null && lastVisited != peekNode.right) {
                curr = peekNode.right;
            }
            else {
                stack.pop();

                int leftHeight = depthMap.getOrDefault(peekNode.left, 0);
                int rightHeight = depthMap.getOrDefault(peekNode.right, 0);

                maxDiameter = Math.max(leftHeight + rightHeight, maxDiameter);

                int currentHeight = Math.max(leftHeight, rightHeight) + 1;

                depthMap.put(peekNode, currentHeight);

                lastVisited = peekNode;
            }
        }

        return maxDiameter;
    }
}
