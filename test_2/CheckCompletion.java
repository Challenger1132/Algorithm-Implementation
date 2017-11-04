package test_2;

import java.util.LinkedList;
/* 
�ж�һ�����ǲ�����ȫ�����������ò�������ķ�ʽ�������Ϊ��ǰ�ڵ���Ҷ�ڵ���������ǰ�ڵ㲻��Ҷ�ڵ�����
	����Ҷ�ڵ���������ǰ�ڵ����ҽڵ㣬û����ڵ㣬ֱ�ӷ���false
	��ڵ㲻Ϊ�������ڵ㵽ջ���ҽڵ㲻Ϊ�գ�����ҽڵ㵽ջ������ҽڵ�Ϊ�գ���ôisLeafNode��Ϊtrue
	�˺�Ľڵ����ȫ����Ҷ�ڵ���ܱ�֤����������ȫ��
	��Ҷ�ڵ�����������ʱ����ڵ�����ڵ�������ҽڵ㣬�������������ڵ㶼�У�ֱ�ӷ���false
 * */
public class CheckCompletion {
    public boolean chk(TreeNode root) {
    	if(root == null)
    		return true; //����Ҳ����ȫ������
    	LinkedList<TreeNode> list = new LinkedList<>();  // ʵ�ֶ��У����ò��������ʽ
    	boolean isLeafNode = false;  //����������ֻ��һ���ڵ�����Ҳ��Ӧ
    	list.add(root);
    	TreeNode curr;
    	while(!list.isEmpty()){
    		curr = list.poll();
    		if(!isLeafNode){  //��Ҷ�ڵ�����
    			if(curr.left == null && curr.right != null)
    				return false;
    			if(curr.left != null)
    				list.add(curr.left);
    			if(curr.right != null)
    				list.add(curr.right);
    			else
    				isLeafNode = true; //����ҽڵ�Ϊ��
    		}
    		else{//Ҷ�ڵ�����������ʱ����ڵ�����ڵ�������ҽڵ㣬�������������ڵ㶼��(˵�������ҽڵ�)��ֱ�ӷ���false
    			if(curr.left != null || curr.right != null)
    				return false;
    		}
    	}
    	return true;
    }
}