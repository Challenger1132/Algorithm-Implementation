package test_2;

public class TreeToString {
	public String treeSerialize(TreeNode root) {
		if(root == null)
			return "#!";
		String str = root.val + "!";  //����  ��
		str += treeSerialize(root.left);  //��
		str += treeSerialize(root.right); //��
        return str;
    }
}
