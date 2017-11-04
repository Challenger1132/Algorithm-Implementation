package test_1;

import java.util.Stack;

public class KInverse {
    public ListNode inverse(ListNode head, int k) {
    	if(head == null)
    		return null;
    	if(k < 2)
    		return head;
    	Stack<ListNode> stack = new Stack<>();
    	
    	ListNode node = head;
    	ListNode tempHead = null;
    	int cnt = 0;
    	while(node != null){
    		cnt++;
    		if(cnt <= k){
    			stack.push(node);
    		}
    		while(!stack.isEmpty()){
    			
    		}
    	}
    	
    	
        return null;
    }
}