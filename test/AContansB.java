package test;
/* 对于两棵彼此独立的二叉树A和B，请编写一个高效算法，检查A中是否存在一棵子树与B树的拓扑结构完全相同
给定两棵二叉树的头结点A和B，请返回一个bool值，代表A中是否存在一棵同构于B的子树
 * */
public class AContansB {
	public boolean chkIdentical(TreeNode stra, TreeNode strb){
		String s1 = serialBypreOrderTravversal(stra);
		String s2 = serialBypreOrderTravversal(strb);
		return s1.contains(s2);
	}
	/* 字符串序列化 -- 就是树的某种遍历方式的修改
	 * 注意要加结束标志!(特殊字符)
	 * */
	public static String serialBypreOrderTravversal(TreeNode t){
		if(t == null)
			return "#!";
		String s = t.val + "!";
		s += serialBypreOrderTravversal(t.left);
		s += serialBypreOrderTravversal(t.right);
		return s;
	}
}
class TreeNode{
	int val;
	TreeNode left;
	TreeNode right;
	public TreeNode(int val) {
		this.val = val;
	}
}
