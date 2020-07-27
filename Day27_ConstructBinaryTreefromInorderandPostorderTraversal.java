//Problem:

Given inorder and postorder traversal of a tree, construct the binary tree.

Note:
You may assume that duplicates do not exist in the tree.

For example, given

inorder = [9,3,15,20,7]
postorder = [9,15,7,20,3]
Return the following binary tree:

    3
   / \
  9  20
    /  \
   15   7


//Solution:

Explanation is

We always know the root is at rightmost of postorder array. Lets call this value rootValue and its index rootIndex.
We know there is no duplicate elements. Lets say inorderIndex is the index of rootValue in inorder array.
Left subtree of root is left subarray of inorderIndex
inorder=[9,3,15,20,7]
postorder=[9,15,7,20,3]
Right subtree of root is right subarray of inorderIndex.
inorder=[9,3,15,20,7]
postorder=[9,15,7,20,3]
We optimize this lookup in HashTable for O(1)
It becomes a problem of building trees & subtrees from subarrays, hence a recursive call.
Extra: To calculate the left subarray in postorder array, we calculate how many elements are in the right subtree / subarray, and minus it from rootIndex.
This is important as we need to know the root element of the left subarray (which is rightmost element of left subarray).
public TreeNode buildTree(int[] inorder, int[] postorder) {
	int N = inorder.length;

	Map<Integer, Integer> inorderInvertedIndex = new HashMap<>(N);
	for (int i = 0; i < N; i++) {
		inorderInvertedIndex.put(inorder[i], i);
	}

	return buildTree(inorder, postorder, 0, N-1, 0, N-1, inorderInvertedIndex);
}

// LMR
// LRM

// [1,9,3,4,15,10,20,7] inorderL=0, inorderR=7, postorderL=0, postorderR=7
// [1,9,4,10,15,7,20,3] rootValue=3, inorderRootIndex=2. rightLength=5.

// [4,15,10,20,7] inorderL=3, inorderR=7, postorderL=2, postorderR=6.
// [4,10,15,7,20] rootValue=20, inorderRootIndex=6. rightLength=1.

// [7] inorderL=7, inorderR=7, postorderL=5, postorderR=5.
// [7] rootValue=7. 

// [4,15,10] inorderL=3, inorderR=5, postorderL=2, postorderR=4
// [4,10,15] rootValue=15.
private TreeNode buildTree(int[] inorder, int[] postorder, int inorderL, int inorderR, int postorderL, int postorderR, Map<Integer, Integer> inorderInvertedIndex) {
	if (inorderL > inorderR) {
		return null;
	}

	int rootValue = postorder[postorderR];
	TreeNode root = new TreeNode(rootValue);

	int inorderRootIndex = inorderInvertedIndex.get(rootValue);

	int rightTreeLength = inorderR - inorderRootIndex;
	int rootLength = 1;

	root.right = buildTree(inorder, postorder, inorderRootIndex+rootLength, inorderR, postorderR-rightTreeLength, postorderR-rootLength, inorderInvertedIndex);

	root.left = buildTree(inorder, postorder, inorderL, inorderRootIndex-rootLength, postorderL, postorderR-rightTreeLength-rootLength, inorderInvertedIndex);

	return root;
}




//Another Solution:

class Solution {
    public TreeNode buildTree(int[] inorder, int[] postorder) {
        return helper(inorder, 0, inorder.length-1, postorder, postorder.length-1);
    }
	// Everytime we just need to know the root index in postorder array
    private TreeNode helper(int[] in, int lo, int hi, int[] post, int index) {
        if (lo > hi) return null;
        TreeNode root = new TreeNode(post[index]);
		// i is the count ot nodes in right sub tree
        int i = 0;
        while (in[hi - i] != post[index]) ++i;
        root.left = helper(in, lo, hi - i - 1, post, index - 1 - i);
        root.right = helper(in, hi - i + 1, hi, post, index - 1);
        return root;
    }
}