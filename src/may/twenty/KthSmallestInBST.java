package may.twenty;

import java.util.Stack;

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

public class KthSmallestInBST {
	
    public int kthSmallest(TreeNode root, int k) {
       Stack<TreeNode> stack = new Stack<>();
       
       TreeNode node = root;
       
       while(node != null || stack.size() > 0) {
    	   if(node != null) {
    		   stack.push(node);
    		   node = node.left;
    	   } else {
    		   TreeNode poped = stack.pop();
    		   k--;
    		   if(k == 0) {
    			   return poped.val;
    		   }
    		   node = poped.right;
    	   }
       }
       
       return 0;
    }
    
    public static void main(String[] args) {
		KthSmallestInBST k = new KthSmallestInBST();
		
		TreeNode root = new TreeNode(5);
		root.left = new TreeNode(3);
		root.right = new TreeNode(6);
		
		root.left.left = new TreeNode(2);
		root.left.right = new TreeNode(4);
		
		root.left.left.left = new TreeNode(1);
		
		System.out.println(k.kthSmallest(root, 1));
		System.out.println(k.kthSmallest(root, 2));
		System.out.println(k.kthSmallest(root, 3));
		System.out.println(k.kthSmallest(root, 4));
		System.out.println(k.kthSmallest(root, 5));
		System.out.println(k.kthSmallest(root, 5));
	}
}