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
    int totalTilt = 0;
    public int findTilt(TreeNode root) {
        calculateSum(root);
        return totalTilt;
    }
    public int calculateSum(TreeNode root) {
        if(root == null) {
            return 0;
        }

        int leftSum = calculateSum(root.left);
        int rightSum = calculateSum(root.right);

        totalTilt += Math.abs(leftSum - rightSum);

        return leftSum + rightSum + root.val; //subtreeSum
    }
}