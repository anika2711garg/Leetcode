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
    HashMap<Integer, Integer> map = new HashMap<>();
    int idx;

    public TreeNode buildTree(int[] inorder, int[] postorder) {
        int n = postorder.length;

        idx = n - 1;

        for (int i = 0; i < n; i++) {
            map.put(inorder[i], i);
        }

        return build(postorder, 0, n - 1);
    }

    public TreeNode build(int[] post, int i, int j) {
        if (i > j) return null;

        int curr = post[idx--];

        TreeNode root = new TreeNode(curr);

        int mid = map.get(curr);

        root.right = build(post, mid + 1, j);
        root.left = build(post, i, mid - 1);

        return root;
    }
}