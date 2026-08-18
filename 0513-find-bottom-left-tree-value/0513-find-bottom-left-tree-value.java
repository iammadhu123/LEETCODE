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
    int maxDepth = -1;
    int ans;

    public void dfs(TreeNode node, int depth) {
        if(node == null) {
            return;
        }
        if (depth > maxDepth) {
            maxDepth = depth;
            ans = node.val;
        }
        //left first
        dfs(node.left, depth + 1);
        //right 2nd
        dfs(node.right, depth + 1);
    }

    public int findBottomLeftValue(TreeNode root) {
        //DFS Approach
        dfs(root, 0);

        return ans;

        //BFS Approach

        // Queue<TreeNode> q = new LinkedList<>();

        // //insert the root node
        // q.offer(root);

        // int ans = root.val;

        // while(!q.isEmpty()) {
        //     int size = q.size();

        //     // // current level ka first node
        //     // ans = q.peek().val;  //OR

        //     for(int i = 0; i<size; i++) {
        //         TreeNode node = q.poll();

        //         // last level ka first node
        //         if (i == 0) {
        //             ans = node.val;
        //         }

        //         if(node.left != null) {
        //             q.offer(node.left);
        //         }
        //         if(node.right != null) {
        //             q.offer(node.right);
        //         }
        //     }
        // }

        // return ans;
    }
}