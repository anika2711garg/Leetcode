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
        if (root == null) 
        return 0;

        int leftHt = getHt(root.left);
        int rightHt = getHt(root.right);

        int diaRoot = leftHt + rightHt;

        int diaLeft = diameterOfBinaryTree(root.left);
        int diaRight = diameterOfBinaryTree(root.right);

        return Math.max(diaRoot, Math.max(diaLeft, diaRight));
    }

    private int getHt(TreeNode node) {
        if (node == null) 
        return 0;
        return 1 + Math.max(getHt(node.left), getHt(node.right));
    }
}
