package test_2;
/* �����ĸ߶ȣ�������ڵ����������ĸ߶ȣ����������߶ȵ����ֵ��һ
 * (���ĸ߶ȵ��������������ĸ߶ȵ����ֵ--���еݹ����ζ)
 * Ҫ�����ĸ߶Ȳ�������������ĸ߶ȣ����������ĸ߶ȣ�Ҫ���������������������ĸ߶����ֵ...
 * ���Ҫ�ú��������ʵ��
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
