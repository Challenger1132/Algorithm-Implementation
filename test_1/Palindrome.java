package test_1;

import java.util.Stack;

public class Palindrome {
    public boolean isPalindrome(ListNode pHead) {
    	if(pHead == null)
    		return true;
        Stack<ListNode> stack = new Stack<>();
        ListNode curr = pHead;
        while(curr != null){  // ���������е�Ԫ��ѹ��ջ
        	stack.push(curr);
        	curr = curr.next;
        }
        curr = pHead;
        while(curr != null){ //������Ԫ�غ�ջ�е�Ԫ�����αȽ�
        	if(curr.val != stack.pop().val)  //ע�ⲻҪд�� tmp != stack.pop() �ȽϵĽڵ��ֵ
        		return false;
        	curr = curr.next;
        }
        return true;
    }
}