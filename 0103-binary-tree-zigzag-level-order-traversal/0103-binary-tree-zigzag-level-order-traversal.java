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
    public List<List<Integer>> zigzagLevelOrder(TreeNode root) {
        List<List<Integer>> ans = new ArrayList<>();

        if(root == null) return ans;

        Deque<TreeNode> q = new LinkedList<>();
        q.offer(root);
        boolean rev = false;
        while(!q.isEmpty()) {
            int levelSize = q.size();
            List<Integer> levelList = new ArrayList<>();
            if(!rev) {
                for (int i = 0; i < levelSize; i++) {
                    TreeNode currNode = q.pollFirst();
                    levelList.add(currNode.val);
                    if(currNode.left != null) q.offerLast(currNode.left);
                    if(currNode.right != null) q.offerLast(currNode.right);
                }
            }
            else {
                for (int i = 0; i < levelSize; i++) {
                    TreeNode currNode = q.pollLast();
                    levelList.add(currNode.val);
                    if(currNode.right != null) q.offerFirst(currNode.right);
                    if(currNode.left != null) q.offerFirst(currNode.left);
                }
            }
            rev = !rev;
            
            ans.add(levelList);
        }
        return ans;
    }
}