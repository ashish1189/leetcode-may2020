package may.twentyfour;

import java.util.Stack;

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

	public TreeNode bstFromPreorder(int[] preorder) {
		TreeNode root = new TreeNode(preorder[0]);
		
		Stack<TreeNode> s = new Stack<TreeNode>();
		
		s.push(root);
		
		for (int i = 1; i < preorder.length; ++i) {
			TreeNode temp = null;
			
			while(!s.isEmpty() && preorder[i] > s.peek().val) {
				temp = s.pop();
			}
			
			if(temp != null) {
				temp.right = new TreeNode(preorder[i]);
				s.push(temp.right);
			} else {
				temp = s.peek();
				temp.left = new TreeNode(preorder[i]);
				s.push(temp.left);
			}
		}
		return root;
    }

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		BinaryTree bt = new BinaryTree();
		
		int[] A = {8,5,1,7,10,12};
		TreeNode rooot = bt.bstFromPreorder(A);
		
		System.out.println(rooot.val);
		System.out.println(rooot.left.val+"\t"+rooot.right.val);
		System.out.println(rooot.left.left.val+"\t"+rooot.left.right.val
				+"\t"+rooot.right.left+"\t"+rooot.right.right.val);
	}

}
