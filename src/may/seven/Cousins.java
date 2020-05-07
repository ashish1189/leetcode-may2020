package may.seven;

/**
 * Definition for a binary tree node.
 */
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

public class Cousins {
	int getParent(TreeNode node, int val, int parent) {
		if (node == null)
			return 0;

		if (node.val == val)
			return parent;

		int p = getParent(node.left, val, node.val);
		if (p != 0)
			return p;

		return getParent(node.right, val, node.val);
	}

	int getLevel(TreeNode node, int val, int level) {
		if (node == null)
			return 0;

		if (node.val == val)
			return level;

		int left = getLevel(node.left, val, level + 1);
		if (left != 0)
			return left;

		return getLevel(node.right, val, level + 1);
	}

	public boolean isCousins(TreeNode root, int x, int y) {
		if ((getLevel(root, x, 1) == getLevel(root, y, 1)) && (getParent(root, x, -1) != getParent(root, y, -1)))
			return true;
		else
			return false;
	}
}