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
    public List<List<Integer>> levelOrder(TreeNode root) {
        if(root == null) 
            return new ArrayList<>();
        
        Deque<TreeNode> dq = new ArrayDeque<>();
        List<List<Integer>> list = new ArrayList<>();

        dq.addFirst(root);

        while(!dq.isEmpty()) {
            List<Integer> subList = new ArrayList<>();
            int n = dq.size();

            for(int i=0; i<n; i++) {
                TreeNode first = dq.removeFirst();
                subList.add(first.val);

                if(first.left != null)
                    dq.addLast(first.left);
                if(first.right != null)
                    dq.addLast(first.right);
            }
            
            list.add(subList);
        }

        return list;
    }
}
