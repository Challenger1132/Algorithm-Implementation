package test;

import java.util.Stack;

public class GetMinStack {
	Stack<Integer> stackData = new Stack<>();
	Stack<Integer> stackMin = new Stack<>();
    public void push(int node) {
    	/* 判断stackMin是否为空，为空直接压入元素
    	 * 被压入元素和stackMin栈顶元素就进行比较，如果大于栈顶元素，压入栈顶元素，否则直接压入元素
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
    
    public int pop() {  //两个栈对应弹出元素
    	stackMin.pop();
        return stackData.pop();
        
    }
    
    public int top() {
        return stackData.peek();
    }
    
    public int min() {  //取出stackMin栈顶即可
        return stackMin.peek();
    }
}
