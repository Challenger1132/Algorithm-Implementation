package test_1;

public class Remove {
    public ListNode removeNode(ListNode pNode, int delVal) {
    	if(pNode == null)
    		return null;
    	ListNode node = pNode, pre = null; //pre是被删除节点的前一个节点
        while(node.val != delVal){
        	pre = node;
        	node = node.next;
        }
        if(pre == null)  //node是头结点
        	return node.next;
        if(node.next == null){ //node是尾节点
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
