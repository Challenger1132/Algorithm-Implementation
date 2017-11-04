package test_1;
/* 指定一个节点，在链表中删除出现的所有的该节点，并返回删除之后的链表
 * 分两种情况，删除的是头结点的情况
 * 删除的是非头结点的情况
 * */
public class ClearValue {
    public ListNode clear(ListNode head, int val) {
    	if(head != null && head.val == val)  //被删除节点是头结点的情况
    		head = head.next;
    	if(head == null)
    		return null;
    	ListNode pre = head, curr = head;
    	while(curr.next != null){  //删除节点是非头结点的情况，如果头结点不为null，那么一定有head.val ！= val
    		curr = curr.next;
    		if(curr.val == val){
    			pre.next = curr.next;
    			curr = pre;
    		}
    		pre = curr;
    	}
    	return head;
    }
    public ListNode clear_1(ListNode head, int val) {
    	if(head != null && head.val == val)  //被删除节点是头结点的情况
    		head = head.next;
    	ListNode pre = head, curr = head;
    	while(curr != null){  //包含了头结点不为null的判定
    		if(curr.val == val){
    			pre.next = curr.next;
    		}else
    			pre = curr;
    		curr = curr.next;
    	}
    	return head;
    }
}
