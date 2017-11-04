package newcode;

import java.util.Stack;

/* 给定入栈顺序，判断某个出栈顺序是否合法
 * 栈不为空，判断栈顶元素和出栈序列第一个元素是否相等，如果相等，将栈顶元素出栈，出栈序列index向后移动，
 * 最后判断栈是否为空或者index是否为序列大小，是返回true，否则返回false
 * b的长度可以小于a的长度？
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
