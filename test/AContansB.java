package test;
/* �������ñ˴˶����Ķ�����A��B�����дһ����Ч�㷨�����A���Ƿ����һ��������B�������˽ṹ��ȫ��ͬ
�������ö�������ͷ���A��B���뷵��һ��boolֵ������A���Ƿ����һ��ͬ����B������
 * */
public class AContansB {
	public boolean chkIdentical(TreeNode stra, TreeNode strb){
		String s1 = serialBypreOrderTravversal(stra);
		String s2 = serialBypreOrderTravversal(strb);
		return s1.contains(s2);
	}
	/* �ַ������л� -- ��������ĳ�ֱ�����ʽ���޸�
	 * ע��Ҫ�ӽ�����־!(�����ַ�)
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
