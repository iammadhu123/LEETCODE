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

    public void dfs(TreeNode l, TreeNode r, int level) {
        if(l == null || r == null) {
            return;
        }

        if(level % 2 == 1) {
            //swap values
            int temp = l.val;
            l.val = r.val;
            r.val = temp;  
        }

        //call fornextlevel
        dfs(l.left, r.right, level + 1);
        dfs(l.right, r.left, level + 1);
    }
    public TreeNode reverseOddLevels(TreeNode root) {
        //Better Approach 2
        if(root == null) {
            return root;
        }

        dfs(root.left, root.right, 1);

        return root;

        //Approach 1

        // //BFS+AL+2 ptr

        // Queue<TreeNode> q = new LinkedList<>();

        // q.offer(root);
        // int level = 0;

        // while(!q.isEmpty()) {
        //     int size = q.size();

        //     List<TreeNode> nodes = new ArrayList<>();
        //     for(int i = 0; i<size; i++) {
        //         TreeNode node = q.poll();
        //         nodes.add(node);

        //         if(node.left != null) {
        //             q.offer(node.left);
        //         }
        //         if(node.right != null) {
        //             q.offer(node.right);
        //         }
        //     }
        //     if(level % 2 != 0) {
        //         //reverse
        //         int i = 0, j = nodes.size()-1;
        //         while(i<j) {
        //             int temp = nodes.get(i).val;
        //             nodes.get(i).val = nodes.get(j).val;
        //             nodes.get(j).val = temp;
        //             i++; j--;
        //         }
        //     }
        //     level++;
        // }
        // return root;
    }
}