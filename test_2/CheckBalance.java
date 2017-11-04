package test_2;

public class CheckBalance {
    public boolean isBalanceTree(TreeNode root) {
    	return treeHeight(root) >= 0;
    }
    /* 判断一棵树是否是平衡二叉树
     * 平衡二叉树的定义：树为空，若不为空，那么任意节点的左右子树的高度差都 <= 1
     * 一旦左右子树高度差大于1，就会返回-1，本次调用结束，那么之后所有递归的返回都是-1，直到函数最后结束
     * 因为中间一旦返回-1，每次的递归都会执行
     * 		if(leftHeight < 0 || rightHeight < 0) return -1;
     * 要求根节点左右子树的高度差，先求左右子树的高度，求左子树的高度，要先求左子树的最右子树的高度最大值
     * 因此要用后序遍历来实现
     * */
    public static int treeHeight(TreeNode root){
    	if(root == null)
    		return 0;
    	int leftHeight = treeHeight(root.left);
    	int rightHeight = treeHeight(root.right);
    	if(leftHeight < 0 || rightHeight < 0)
    		return -1;
    	if(Math.abs(leftHeight - rightHeight) > 1) //左右子树高度差大于1，就会返回-1，本次调用结束，那么之后所有递归的返回都是-1
    		return -1;
    	return leftHeight > rightHeight ? leftHeight+1 : rightHeight+1;	
    }
}