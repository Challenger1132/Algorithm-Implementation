package test;

import java.util.Stack;

/* 实现一个栈的逆序，但是只能用递归函数和这个栈本身的pop操作来实现，而不能自己申请另外的数据结构
 * */
public class StackReverse {
	public int[] reverseStack(int[] arr, int n) {
        if(n == 0)
        	return arr;
        int ele = getLastArrayEle(arr, n);
        n--;
        reverseStack(arr, n);
        arr[n] = ele;
        return arr;
    }
	
	public static int getLastArrayEle(int[] arr, int n){
		int result = arr[n-1];
		n--;
		if(n == 0)
			return result;
		else{
			int last = getLastArrayEle(arr, n);
			arr[n-1] = result;
			return last;
		}
	}
	public static void stackReverse(Stack<Integer> stack){
		if(stack.isEmpty())
			return;
		int bottomStackEle = getStackBottom(stack);
		stackReverse(stack);  //传入删除了栈底元素的栈
		stack.push(bottomStackEle);
	}
	
	/* 实现删除栈底元素并将栈底元素返回
	 * */
	public static int getStackBottom(Stack<Integer> stack){
		int result = stack.pop();
		if(stack.isEmpty())
			return result;
		else{
			int last = getStackBottom(stack);//如果栈不为空，就继续弹出元素
			//并将栈向下传递(传递的是pop之后的新的栈)，弹出元素由调用栈维护
			stack.push(result); //压入上一次弹出结果，并将最后一次弹出结果逐次返回
			return last;
		}
	}
}
