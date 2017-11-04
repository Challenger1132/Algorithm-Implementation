package test_2;

import java.util.ArrayList;
import java.util.Stack;
import test_2.TreeNode;
/* �������ķǵݹ�ʵ�ֱ���
 * */
public class TreeToSequence_1 {
	public void preOrderTraversal(TreeNode root, ArrayList<Integer> arr){
		/* �����ڵ�ѹ��ջ�����ջ��Ϊ�գ��͵���ջ��Ԫ�ؼ�Ϊcurr
		 * �Ҷ��Ӳ�Ϊ�գ����Ҷ���ѹ��ջ������Ӳ�Ϊ�գ��������ѹ��ջ
		 * */
		if(root == null)
			return;
		Stack<TreeNode> stack = new Stack<>();
		TreeNode curr = root;
		stack.push(curr);
		while(!stack.isEmpty()){  //ѭ��������ջ��Ϊ�գ� �ȷ��Ҷ��ӣ��ٷ������
			curr = stack.pop(); // ����
			arr.add(curr.val);
			if(curr.right != null)  //�Ҷ��Ӳ�Ϊ�գ���ѹ��ջ
				stack.push(curr.right);
			if(curr.left != null) 	//����Ӳ�Ϊ�գ�ѹ��ջ
				stack.push(curr.left);
		}
	}
	public void inOrderTraversal(TreeNode root, ArrayList<Integer> arr){
		if(root == null)
			return;
		Stack<TreeNode> stack = new Stack<>();
		TreeNode curr = root;
		//������currΪͷ���������������ν���������߽�ѹ��ջ�У���������curr = curr.left;
		while(!stack.isEmpty() || curr != null){
			if(curr != null){ //**  if(curr.left != null)
				stack.push(curr);
				curr = curr.left;
			}
			else{  //curr == null
				curr = stack.pop();
				arr.add(curr.val);
				curr = curr.right; //���ﲻ�ǽ�currѹ��ջ�����Ǽ����ظ�**����
				//ע������curr�п���Ϊnull����currΪnullʱ��ջ��Ϊ�գ�����ִ��whileѭ��
				//����ʱcurr.left�Ͳ���ִ�У���Ϊcurr��null���׳�NullPointerException
			}
		}
	}
	public void postOrderTraversal(TreeNode root, ArrayList<Integer> arr){
		/* �����ڵ�ѹ��ջs1�������ջ��Ϊ�գ���ջ�е���Ԫ�ؽ������s2
		 * ����ýڵ����Ҷ��Ӳ�Ϊ�գ����ν����Ҷ�����ջs1��ֱ��ջs1Ϊ��
		 * ���δ�s2�е���Ԫ�أ�����˳����Ǻ��������˳��
		 * */
		if(root == null)
			return;
		Stack<TreeNode> s1 = new Stack<>();
		Stack<TreeNode> s2 = new Stack<>();
		TreeNode curr = root;
		s1.push(root);
		while(!s1.isEmpty()){
			curr = s1.pop();
			s2.push(curr);  // �������Ľڵ�ѹ��ջs2
			if(curr.left != null)   //����Ӳ�Ϊ�գ���ѹ��ջ
				s1.push(curr.left);
			if(curr.right != null) //�Ҷ��Ӳ�Ϊ�գ�ѹ��ջ
				s1.push(curr.right);
		}
		while(!s2.isEmpty())  //���δ�
			arr.add(s2.pop().val);
	}
	
	public int[][] convert(TreeNode root) {
        ArrayList<Integer> pre = new ArrayList<>();
        ArrayList<Integer> in = new ArrayList<>();
        ArrayList<Integer> post = new ArrayList<>();
        
        preOrderTraversal(root, pre);
        inOrderTraversal(root, in);
        postOrderTraversal(root, post);
        int[][] result = new int[3][pre.size()];
        for (int i = 0; i < pre.size(); i++) {
        	result[0][i] = pre.get(i);
        	result[1][i] = in.get(i);
        	result[2][i] = post.get(i);
		}
        return result;
    }
}
