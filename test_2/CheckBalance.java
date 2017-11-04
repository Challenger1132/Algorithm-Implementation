package test_2;

public class CheckBalance {
    public boolean isBalanceTree(TreeNode root) {
    	return treeHeight(root) >= 0;
    }
    /* �ж�һ�����Ƿ���ƽ�������
     * ƽ��������Ķ��壺��Ϊ�գ�����Ϊ�գ���ô����ڵ�����������ĸ߶Ȳ <= 1
     * һ�����������߶Ȳ����1���ͻ᷵��-1�����ε��ý�������ô֮�����еݹ�ķ��ض���-1��ֱ������������
     * ��Ϊ�м�һ������-1��ÿ�εĵݹ鶼��ִ��
     * 		if(leftHeight < 0 || rightHeight < 0) return -1;
     * Ҫ����ڵ����������ĸ߶Ȳ�������������ĸ߶ȣ����������ĸ߶ȣ�Ҫ���������������������ĸ߶����ֵ
     * ���Ҫ�ú��������ʵ��
     * */
    public static int treeHeight(TreeNode root){
    	if(root == null)
    		return 0;
    	int leftHeight = treeHeight(root.left);
    	int rightHeight = treeHeight(root.right);
    	if(leftHeight < 0 || rightHeight < 0)
    		return -1;
    	if(Math.abs(leftHeight - rightHeight) > 1) //���������߶Ȳ����1���ͻ᷵��-1�����ε��ý�������ô֮�����еݹ�ķ��ض���-1
    		return -1;
    	return leftHeight > rightHeight ? leftHeight+1 : rightHeight+1;	
    }
}