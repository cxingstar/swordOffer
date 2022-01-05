package groundtrue.chapters4;

public class o22 {
    public ListNode detectCycle(ListNode head) {
        ListNode inLoop = getNodeInLoop(head);
        if(inLoop == null)
            return null;
        ListNode node = head;
        while(node != inLoop){
            node = node.next;
            inLoop = inLoop.next;
        }
        return node;

    }
    private ListNode getNodeInLoop(ListNode head){
        if(head == null || head.next == null)
            return null;
        ListNode slow = head.next;
        ListNode fast = slow.next;
        while(slow != null && fast != null){
            if(slow == fast)
                return slow;
            slow = slow.next;
            fast = fast.next;
            if(fast != null)
                fast = fast.next;
        }
        return null;
    }
}
