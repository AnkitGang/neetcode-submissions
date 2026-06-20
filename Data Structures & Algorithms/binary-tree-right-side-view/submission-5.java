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
    public List<Integer> rightSideView(TreeNode root) {
        if(root == null)
            return new ArrayList<>();

        Deque<TreeNode> dq = new ArrayDeque<>();
        List<Integer> list = new ArrayList<>();

        dq.addFirst(root);

        while(!dq.isEmpty()) {
            int n = dq.size();

            for(int i=0; i<n; i++){            
                TreeNode curr = dq.removeFirst();
                if(i == 0)
                    list.add(curr.val);

                if(curr.right != null)
                    dq.addLast(curr.right);
                if(curr.left != null)
                    dq.addLast(curr.left);
            }
        }

        return list;
    }
}
