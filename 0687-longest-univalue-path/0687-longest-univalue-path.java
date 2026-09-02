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
    int lengthOfLongestPath = 0;
    public int dfs(TreeNode root) {
        if(root == null) {
            return 0;
        }

        int left = dfs(root.left);
        int right = dfs(root.right);

        int leftPath = 0;
        int rightPath = 0;

        if(root.left != null && root.left.val == root.val) {
            leftPath = left + 1;
        }
        if(root.right != null && root.right.val == root.val) {
            rightPath = right + 1;
        }

        // Path passing through current node
        lengthOfLongestPath = Math.max(lengthOfLongestPath, leftPath+rightPath);

        // Return only one side to parent
        return Math.max(leftPath, rightPath);
    }
    public int longestUnivaluePath(TreeNode root) {
        dfs(root);
        return lengthOfLongestPath;
    }
}