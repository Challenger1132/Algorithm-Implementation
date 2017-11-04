package test;

import java.util.Stack;

public class GetMinStack {
	Stack<Integer> stackData = new Stack<>();
	Stack<Integer> stackMin = new Stack<>();
    public void push(int node) {
    	/* �ж�stackMin�Ƿ�Ϊ�գ�Ϊ��ֱ��ѹ��Ԫ��
    	 * ��ѹ��Ԫ�غ�stackMinջ��Ԫ�ؾͽ��бȽϣ��������ջ��Ԫ�أ�ѹ��ջ��Ԫ�أ�����ֱ��ѹ��Ԫ��
    	 * */
    	stackData.push(node);
    	if(stackMin.isEmpty())
    		stackMin.push(node);
    	else{
    		int peek = stackMin.peek();
    		if(node > peek)
    			stackMin.push(peek);
    		else
    			stackMin.push(node);
    	}
    }
    
    public int pop() {  //����ջ��Ӧ����Ԫ��
    	stackMin.pop();
        return stackData.pop();
        
    }
    
    public int top() {
        return stackData.peek();
    }
    
    public int min() {  //ȡ��stackMinջ������
        return stackMin.peek();
    }
}
