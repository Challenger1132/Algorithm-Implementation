package test;

import java.util.ArrayList;
import java.util.Stack;

/* ��дһ����,ֻ��������ջ�ṹʵ�ֶ���,֧�ֶ��еĻ�������(push��pop)
����һ����������ope�����ĳ���n������Ԫ��Ϊ��������push������Ϊ0����pop����
��֤�������кϷ���һ����pop�������뷵��pop�Ľ������
 * */

public class TwoStack {
    public int[] twoStack(int[] ope, int n) {
    	Stack<Integer> stackpush = new Stack<>();
    	Stack<Integer> stackpop = new Stack<>();
    	ArrayList<Integer> arr = new ArrayList<>();
    	for(int i = 0;i < ope.length; i++){
    		int ele = ope[i];
    		if(ele > 0)
    			// ���� >0 ��Ԫ�ؽ���push����������ŵ�stackpush��
    			stackpush.push(ele);
    		else{
    			/* ����0����pop��������stackpushԪ��ȫ���ŵ�stackpop�У���ʱstackpushΪ��
    			 * ��stackpop�е���һ��Ԫ�طŵ�arr�У�Ȼ��λ����stackpopԪ��ȫ���ŵ�stackpush�У�
    			 * ��ʱstackpop��Ԫ��Ϊ��
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
