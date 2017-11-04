package newcode;

import java.util.Stack;

/* ������ջ˳���ж�ĳ����ջ˳���Ƿ�Ϸ�
 * ջ��Ϊ�գ��ж�ջ��Ԫ�غͳ�ջ���е�һ��Ԫ���Ƿ���ȣ������ȣ���ջ��Ԫ�س�ջ����ջ����index����ƶ���
 * ����ж�ջ�Ƿ�Ϊ�ջ���index�Ƿ�Ϊ���д�С���Ƿ���true�����򷵻�false
 * b�ĳ��ȿ���С��a�ĳ��ȣ�
 * */
public class IsStackOutOrder {
	public static boolean isStackOutOrderModified(int[] a, int[] b){
		if(a.length < b.length)
			return false;
		Stack<Integer> stack = new Stack<>();
		int index = 0;
		for (int i = 0; i < a.length; i++) {
			stack.push(a[i]);
			while(!stack.isEmpty() && index < b.length && stack.peek() == b[index]){
				stack.pop();
				index++;
			}
		}
		return index == b.length;
	}
	public static boolean isStackOutOrder(int[] a, int[] b){
		if(a.length < b.length)
			return false;
		Stack<Integer> stack = new Stack<>();
		int index = 0;
		for (int i = 0; i < a.length; i++) {
			stack.push(a[i]);
			while(!stack.isEmpty() && stack.peek() == b[index]){
				stack.pop();
				index++;
			}
		}
		return index == b.length;
	}
}
