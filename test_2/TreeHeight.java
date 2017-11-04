package test_2;
/* 求树的高度，先求根节点左右子树的高度，左右子树高度的最大值加一
 * (树的高度等于树所有子树的高度的最大值--含有递归的意味)
 * 要求树的高度差，先求左右子树的高度，求左子树的高度，要先求左子树的左右子树的高度最大值...
 * 因此要用后序遍历来实现
 * */
public class TreeHeight {
	public static int treeHeight(TreeNode root){
		if(root == null)
			return 0;
		int leftHeight = treeHeight(root.left);
		int rightHeight = treeHeight(root.right);
		int height = leftHeight > rightHeight ? leftHeight : rightHeight;
		return height + 1;
	}
}
