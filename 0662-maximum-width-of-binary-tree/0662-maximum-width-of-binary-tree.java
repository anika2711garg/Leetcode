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

    // Stores a node along with its index
    class Pair {

        TreeNode node;
        long index;

        Pair(TreeNode node, long index) {
            this.node = node;
            this.index = index;
        }
    }

    public int widthOfBinaryTree(TreeNode root) {

        if (root == null)
            return 0;

        // Queue for level order traversal
        Queue<Pair> q = new LinkedList<>();

        // Root starts with index 0
        q.offer(new Pair(root, 0));

        int ans = 0;

        while (!q.isEmpty()) {

            int size = q.size();

            // First index of this level
            long min = q.peek().index;

            long first = 0;
            long last = 0;

            for (int i = 0; i < size; i++) {

                Pair curr = q.poll();

                // Normalize index to avoid overflow
                long idx = curr.index - min;

                // First node of level
                if (i == 0)
                    first = idx;

                // Last node of level
                if (i == size - 1)
                    last = idx;

                // Left child gets index 2*i+1
                if (curr.node.left != null)
                    q.offer(new Pair(curr.node.left, 2 * idx + 1));

                // Right child gets index 2*i+2
                if (curr.node.right != null)
                    q.offer(new Pair(curr.node.right, 2 * idx + 2));
            }

            // Width of current level
            ans = Math.max(ans, (int) (last - first + 1));
        }

        return ans;
    }
}