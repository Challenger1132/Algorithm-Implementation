package test_2;

public class TreeToString {
	public String treeSerialize(TreeNode root) {
		if(root == null)
			return "#!";
		String str = root.val + "!";  //·ÃÎÊ  ¸ù
		str += treeSerialize(root.left);  //×ó
		str += treeSerialize(root.right); //ÓÒ
        return str;
    }
}
