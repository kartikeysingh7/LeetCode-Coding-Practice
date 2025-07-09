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
    public List<List<Integer>> levelOrderBottom(TreeNode root) {
        List<List<Integer>> output = new ArrayList<>();
        Queue<TreeNode> q = new LinkedList<>();
        List<Integer> level = new ArrayList<>();

        if(root == null) {
            return output;
        }

        q.add(root);
        q.add(null);

        while(!q.isEmpty()) {
            TreeNode curr = q.remove();

            if(curr != null) {
                level.add(curr.val);
            }

            if(curr == null) {
                output.add(level);
                level = new ArrayList<>();
                if(q.isEmpty()) {
                    break;
                } else {
                    q.add(null);
                }
            } else {
                if(curr.left != null) {
                    q.add(curr.left);
                }
                if(curr.right != null) {
                    q.add(curr.right);
                }
            }
        }

        Collections.reverse(output);
        return output;
    }
}