package test_1;
/* ָ��һ���ڵ㣬��������ɾ�����ֵ����еĸýڵ㣬������ɾ��֮�������
 * �����������ɾ������ͷ�������
 * ɾ�����Ƿ�ͷ�������
 * */
public class ClearValue {
    public ListNode clear(ListNode head, int val) {
    	if(head != null && head.val == val)  //��ɾ���ڵ���ͷ�������
    		head = head.next;
    	if(head == null)
    		return null;
    	ListNode pre = head, curr = head;
    	while(curr.next != null){  //ɾ���ڵ��Ƿ�ͷ������������ͷ��㲻Ϊnull����ôһ����head.val ��= val
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
    	if(head != null && head.val == val)  //��ɾ���ڵ���ͷ�������
    		head = head.next;
    	ListNode pre = head, curr = head;
    	while(curr != null){  //������ͷ��㲻Ϊnull���ж�
    		if(curr.val == val){
    			pre.next = curr.next;
    		}else
    			pre = curr;
    		curr = curr.next;
    	}
    	return head;
    }
}
