class Solution {
    public int diameterOfBinaryTree(TreeNode root) {
        if (root == null) return 0;
        int d = height(root.left) + height(root.right);
        return Math.max(d, Math.max(
            diameterOfBinaryTree(root.left),
            diameterOfBinaryTree(root.right)
        ));
    }

    private int height(TreeNode root) {
        if (root == null) return 0;
        return 1 + Math.max(height(root.left), height(root.right));
    }
}