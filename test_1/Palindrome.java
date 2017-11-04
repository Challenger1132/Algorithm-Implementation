package test_1;

import java.util.Stack;

public class Palindrome {
    public boolean isPalindrome(ListNode pHead) {
    	if(pHead == null)
    		return true;
        Stack<ListNode> stack = new Stack<>();
        ListNode curr = pHead;
        while(curr != null){  // 将链表所有的元素压入栈
        	stack.push(curr);
        	curr = curr.next;
        }
        curr = pHead;
        while(curr != null){ //链表中元素和栈中的元素依次比较
        	if(curr.val != stack.pop().val)  //注意不要写成 tmp != stack.pop() 比较的节点的值
        		return false;
        	curr = curr.next;
        }
        return true;
    }
}