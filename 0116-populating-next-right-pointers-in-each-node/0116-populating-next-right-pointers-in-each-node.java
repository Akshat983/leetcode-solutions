/*
// Definition for a Node.
class Node {
    public int val;
    public Node left;
    public Node right;
    public Node next;

    public Node() {}
    
    public Node(int _val) {
        val = _val;
    }

    public Node(int _val, Node _left, Node _right, Node _next) {
        val = _val;
        left = _left;
        right = _right;
        next = _next;
    }
};
*/

class Solution {
    public Node connect(Node root) {
        Queue<Node> q = new LinkedList<>();
        q.offer(root);

        if(root == null) return null;

        while(!q.isEmpty()) {
            int levelSize = q.size();
            for(int i = 0; i < levelSize - 1; i++) {
                Node currNode = q.poll();
                if(currNode.left != null) q.offer(currNode.left);
                if(currNode.right != null) q.offer(currNode.right);
                currNode.next = q.peek();
            }
            Node last = q.poll();
            if(last.left != null) q.offer(last.left);
            if(last.right != null) q.offer(last.right);
            last.next = null;
        }
        return root;
    }
}