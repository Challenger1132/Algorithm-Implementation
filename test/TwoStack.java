package test;

import java.util.ArrayList;
import java.util.Stack;

/* 编写一个类,只能用两个栈结构实现队列,支持队列的基本操作(push，pop)
给定一个操作序列ope及它的长度n，其中元素为正数代表push操作，为0代表pop操作
保证操作序列合法且一定含pop操作，请返回pop的结果序列
 * */

public class TwoStack {
    public int[] twoStack(int[] ope, int n) {
    	Stack<Integer> stackpush = new Stack<>();
    	Stack<Integer> stackpop = new Stack<>();
    	ArrayList<Integer> arr = new ArrayList<>();
    	for(int i = 0;i < ope.length; i++){
    		int ele = ope[i];
    		if(ele > 0)
    			// 遇到 >0 的元素进行push操作，将其放到stackpush中
    			stackpush.push(ele);
    		else{
    			/* 遇到0进行pop操作，将stackpush元素全部放到stackpop中，此时stackpush为空
    			 * 在stackpop中弹出一个元素放到arr中，然后复位，将stackpop元素全部放到stackpush中，
    			 * 此时stackpop中元素为空
    			 * */
    			while(!stackpush.isEmpty())
    				stackpop.push(stackpush.pop());
    			int val = stackpop.pop();
    			arr.add(val);
    			while(!stackpop.isEmpty())
    				stackpush.push(stackpop.pop());
    		}
    	}
    	int[] a = new int[arr.size()];
    	for(int i = 0;i < arr.size(); i++)
    		a[i] = arr.get(i);
    	return a;
    }
}
