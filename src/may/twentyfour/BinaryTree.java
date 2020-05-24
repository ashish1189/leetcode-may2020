package may.twentyfour;

import node.BinaryNode;

public class BinaryTree {
	class TreeNode {
		int val;
		TreeNode left;
		TreeNode right;
		TreeNode() {}
		TreeNode(int val) { this.val = val; }
		TreeNode(int val, TreeNode left, TreeNode right) {
			this.val = val;
			this.left = left;
			this.right = right;
		}
	}
	
	TreeNode root;
	
	void insert(int value) {
		root = insert(root, value);
	}
	
	private TreeNode insert(TreeNode node, int value) {
		if(node == null) {
			return new TreeNode(value);
		} else if (value < )
	}
	
	public TreeNode bstFromPreorder(int[] preorder) {
        
    }

	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}

}
