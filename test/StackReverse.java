package test;

import java.util.Stack;

/* ʵ��һ��ջ�����򣬵���ֻ���õݹ麯�������ջ�����pop������ʵ�֣��������Լ�������������ݽṹ
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
		stackReverse(stack);  //����ɾ����ջ��Ԫ�ص�ջ
		stack.push(bottomStackEle);
	}
	
	/* ʵ��ɾ��ջ��Ԫ�ز���ջ��Ԫ�ط���
	 * */
	public static int getStackBottom(Stack<Integer> stack){
		int result = stack.pop();
		if(stack.isEmpty())
			return result;
		else{
			int last = getStackBottom(stack);//���ջ��Ϊ�գ��ͼ�������Ԫ��
			//����ջ���´���(���ݵ���pop֮����µ�ջ)������Ԫ���ɵ���ջά��
			stack.push(result); //ѹ����һ�ε���������������һ�ε��������η���
			return last;
		}
	}
}
