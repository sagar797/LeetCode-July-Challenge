//Problem:

Given a binary tree, write a function to get the maximum width of the given tree. The width of a tree is the maximum width among all levels. The binary tree has the same structure as a full binary tree, but some nodes are null.

The width of one level is defined as the length between the end-nodes (the leftmost and right most non-null nodes in the level, where the null nodes between the end-nodes are also counted into the length calculation.

Example 1:
Input: 
           1
         /   \
        3     2
       / \     \  
      5   3     9 

Output: 4
Explanation: The maximum width existing in the third level with the length 4 (5,3,null,9).

Example 2:
Input: 
          1
         /  
        3    
       / \       
      5   3     

Output: 2
Explanation: The maximum width existing in the third level with the length 2 (5,3).

Example 3:
Input: 

          1
         / \
        3   2 
       /        
      5      

Output: 2
Explanation: The maximum width existing in the second level with the length 2 (3,2).

Example 4:
Input: 

          1
         / \
        3   2
       /     \  
      5       9 
     /         \
    6           7
Output: 8
Explanation:The maximum width existing in the fourth level with the length 8 (6,null,null,null,null,null,null,7).

Note: Answer will in the range of 32-bit signed integer.

//Solution:

//Since the value of the treenode is irrelevant to our problem, we can change the value to represent treenode's horizontal position, e.g. one node's value is set to x, its left child(if exists) will contain the value 2x - 1 and right child(if exists) 2x. And the root node's value is set to 1 at the beginning.

class Solution {
    public int widthOfBinaryTree(TreeNode root) {
        if (root == null) return 0;
        root.val = 1;
        Queue<TreeNode> q = new LinkedList<>();
        q.offer(root);
        int maxWidth = 1;
        while(!q.isEmpty()){
            int size = q.size();
            int left = q.peek().val;
            int right = left;
            for (int i = 0; i < size; i++){
                root = q.poll();
                if (root.val > right) right = root.val;
                if (root.left != null) {
                    root.left.val = root.val * 2 - 1;
                    q.offer(root.left);
                }
                if (root.right != null){
                    root.right.val = root.val * 2;
                    q.offer(root.right);
                }
            }
            if ((right - left + 1) > maxWidth) maxWidth = right - left + 1;
        }
        return maxWidth;
    }
}

//Other Solutions:

There are 2 verions.
Both of solutions are using BFS but one is with queue and another is with queue and hashmap.
Of course, queue version is faster than queue and hashmap version !!

1. using queue version (95%)

class Solution {
    public class Node {
        TreeNode node;
        int pos;
        Node(TreeNode node, int pos) {
            this.node = node;
            this.pos = pos;
        }
    }
    public int widthOfBinaryTree(TreeNode root) {
        Node curr = new Node(root, 1);
        Queue<Node> queue = new LinkedList<>();
        queue.add(curr);
        int max = Integer.MIN_VALUE;
        while(!queue.isEmpty()) {
            int size = queue.size();
            int left = -1;
            for(int i = 0; i < size; i++) {
                Node n = queue.poll();
                if(i == 0) left = n.pos; //first polled node from queue is the left side of the tree in same level

                if(n.node.left != null) queue.offer(new Node(n.node.left, n.pos * 2));
                if(n.node.right != null) queue.offer(new Node(n.node.right, n.pos * 2 + 1));
                max = Math.max(max, n.pos - left + 1);
            }
        }
        return max;
    }
}

2. Using queue and hashmap version (45%)

class Solution {
    public int widthOfBinaryTreeWithHashMap(TreeNode root) {
        TreeNode curr = root;
        Queue<TreeNode> queue = new LinkedList<>();
        queue.add(curr);
        Map<TreeNode, Integer> posDic = new HashMap<>();
        int max = Integer.MIN_VALUE;
        while(!queue.isEmpty()) {
            int size = queue.size();
            int left = -1;
            for(int i = 0; i < size; i++) {
                TreeNode n = queue.poll();
                if(i == 0) left = posDic.getOrDefault(n, 1); //first polled node from queue is the left side of the tree in same level
                if(n.left != null) {
                    queue.offer(n.left);
                    posDic.put(n.left, posDic.getOrDefault(n, 1) * 2);
                }
                if(n.right != null) {
                    queue.offer(n.right);
                    posDic.put(n.right, posDic.getOrDefault(n, 1) * 2 + 1);
                }
                max = Math.max(max, posDic.getOrDefault(n, 1) - left + 1);
            }
        }
        return max;
    }
}