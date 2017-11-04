package test_1;

public class ClearValue_1 {
    public ListNode clear(ListNode head, int val) {
    	while(head != null && head.val == val)  //删除节点是头结点的情况
    		head = head.next;
    	
    	if(head == null)
    		return null;
    	
    	ListNode curr = head, pre = head;
    	while(curr.next != null){
    		curr = curr.next;
    		if(curr.val == val){
    			pre.next = curr.next;
    			curr = pre;
    		}
    		pre = curr;
    	}
    	return head;
    }
}
