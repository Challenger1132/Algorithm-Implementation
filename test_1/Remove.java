package test_1;

public class Remove {
    public ListNode removeNode(ListNode pNode, int delVal) {
    	if(pNode == null)
    		return null;
    	ListNode node = pNode, pre = null; //pre�Ǳ�ɾ���ڵ��ǰһ���ڵ�
        while(node.val != delVal){
        	pre = node;
        	node = node.next;
        }
        if(pre == null)  //node��ͷ���
        	return node.next;
        if(node.next == null){ //node��β�ڵ�
        	pre.next = null;
        	return pNode;
        }
        pre.next = node.next;
//        ListNode nextNode = node.next;
//        node.val = nextNode.val;
//        node.next = nextNode.next;
        return pNode;
    }
}
