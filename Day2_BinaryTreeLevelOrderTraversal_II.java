//Problem:

// Given a binary tree, return the bottom-up level order traversal of its nodes' values. (ie, from left to right, level by level from leaf to root).

// For example:
// Given binary tree [3,9,20,null,null,15,7],
//     3
//    / \
//   9  20
//     /  \
//    15   7
// return its bottom-up level order traversal as:
// [
//   [15,7],
//   [9,20],
//   [3]
// ]

//Solution
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
    public List<List<Integer>> levelOrderBottom(TreeNode root) {
        if(root==null){
            return new ArrayList<>();
        }
        Queue<TreeNode> q1=new ArrayDeque<>();
        Queue<TreeNode> q2=new ArrayDeque<>();
        List<Integer> al=new ArrayList<>();
        List<List<Integer>> f=new ArrayList<>();
        q1.add(root);
        while(q1.size()>0){
            //remove
            TreeNode temp=q1.remove();
            //print
            
            al.add(temp.val);
            //add
            if(temp.left!=null){
                q2.add(temp.left);
            }
            if(temp.right!=null){
                q2.add(temp.right);
            }
            if(q1.size()==0){
                q1=q2;
                q2=new ArrayDeque<>();
                f.add(al);
                al = new ArrayList();
            }
        }
        Collections.reverse(f);
        return f;
    }
}