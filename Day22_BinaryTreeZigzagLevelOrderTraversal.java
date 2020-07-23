//Problem:

Given a binary tree, return the zigzag level order traversal of its nodes values. (ie, from left to right, then right to left for the next level and alternate between).

For example:
Given binary tree [3,9,20,null,null,15,7],
    3
   / \
  9  20
    /  \
   15   7
return its zigzag level order traversal as:
[
  [3],
  [20,9],
  [15,7]
]


//Solution:

//  * Definition for a binary tree node.
//  * public class TreeNode {
//  *     int val;
//  *     TreeNode left;
//  *     TreeNode right;
//  *     TreeNode() {}
//  *     TreeNode(int val) { this.val = val; }
//  *     TreeNode(int val, TreeNode left, TreeNode right) {
//  *         this.val = val;
//  *         this.left = left;
//  *         this.right = right;
//  *     }
//  * }
//  * 

class Solution {
    // just use normal BFS with queue.
    // keep an indicator oddEvenIndicator.
    // if oddEvenIndicator % 2 == 0 use stack to reverse the list.
    // else use the list and insert in result list.
    public static List<List<Integer>> zigzagLevelOrder(TreeNode root) {
    
            List<List<Integer>> result = new ArrayList<>();
            Queue<TreeNode> integerQueue = new LinkedList<>();
    
    
            if (root != null) {
                integerQueue.offer(root);
            }
    
    
            int oddEvenIndicator = 0;
    
            while (!integerQueue.isEmpty()) {
    
    
                List<Integer> integerList = new ArrayList<>();
    
                int size = integerQueue.size();
                for (int i = 0; i < size; i++) {
                    TreeNode treeNode = integerQueue.poll();
                    integerList.add(treeNode.val);
    
                    if (treeNode.left != null) {
                        integerQueue.offer(treeNode.left);
                    }
                    if (treeNode.right != null) {
                        integerQueue.offer(treeNode.right);
                    }
    
                }
                oddEvenIndicator++;
                if (oddEvenIndicator % 2 == 0) {
                    Stack<Integer> stack = new Stack<>();
                    stack.addAll(integerList);
    
                    List<Integer> reverseList = new ArrayList<>();
                    while (!stack.isEmpty()) {
                        reverseList.add(stack.pop());
                    }
    
                    result.add(reverseList);
    
                } else {
                    result.add(integerList);
                }
            }
            return result;
        }
    }