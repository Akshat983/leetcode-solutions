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
    public boolean isCousins(TreeNode root, int x, int y) {
        TreeNode xx = findNode(root, x);
        TreeNode yy = findNode(root, y);

        return ((level(xx, root, 0) == level(yy, root, 0)) && !siblings(xx, yy, root));
            
    }

    public TreeNode findNode(TreeNode root, int val) {
        if (root == null) return null;
        if (root.val == val) return root;
        TreeNode l = findNode(root.left, val);
        if (l != null) return l;
        return findNode(root.right, val);
}

    public int level(TreeNode node, TreeNode root, int i) {
        if (root == null) return -1;

        if(root == node) return i;
        int l = -1, r = -1;
        l = level(node, root.left, i+1);
        r = level(node, root.right, i+1);
        if(l != -1) return l;
        return r;
    }

    public boolean siblings(TreeNode node1, TreeNode node2, TreeNode root) {
        if (node1 == null || node2 == null || root == null) {
            return false;
        }

        if ((root.left == node1 && root.right == node2) ||
            (root.left == node2 && root.right == node1)) {
            return true;
        }

        return siblings(node1, node2, root.left) ||
               siblings(node1, node2, root.right);
        }
}