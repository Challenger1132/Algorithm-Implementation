package newcode;

/* 求二叉树节点的个数
 * */
public class TreeNodeNum {
	public static int treeNodeNum(TreeNode root){
		if(root == null)
			return 0;
		int leftDepth = leftTreeDepth(root);
		int rightDepth = rightTreeDepth(root);
		if(leftDepth == rightDepth)
			return (1 >> leftDepth)-1; // 2^k - 1
		return treeNodeNum(root.left) + treeNodeNum(root.right) + 1;
		
	}
	private static int leftTreeDepth(TreeNode root){
		int depth = 0;
		while(root != null){
			depth++;
			root = root.left;
		}
		return depth;
	}
	private static int rightTreeDepth(TreeNode root){
		int depth = 0;
		while(root != null){
			depth++;
			root = root.right;
		}
		return depth;
	}
}

class TreeNode{
	public int val;
	public TreeNode left;
	public TreeNode right;
	public TreeNode(int val){
		this.val = val;
	}
}
