package groundtrue.chapters4;

public class o26 {
    public void reorderList(ListNode head) {
        ListNode dumpy = new ListNode(0);
        dumpy.next = head;
        ListNode slow = dumpy;
        ListNode fast = dumpy;
        while(slow != null  && fast.next != null){
            slow = slow.next;
            fast = fast.next;
            if(fast.next != null)
                fast = fast.next;
        }
        ListNode tmp = slow.next;
        slow.next = null;
        link(head,reverse(tmp),dumpy);

    }

    private ListNode reverse(ListNode head){
        ListNode dumpy = new ListNode(0);
        dumpy.next = head;
        ListNode cur = dumpy.next;
        ListNode prev = null;
        while(cur != null){
            ListNode next = cur.next;
            cur.next = prev;
            prev = cur;
            cur = next;
        }
        return prev;
    }
    private void link(ListNode node1,ListNode node2,ListNode head){
        ListNode prev = head;
        while(node1 != null && node2 != null){
            ListNode temp =  node1.next;
            prev.next =node1;
            node1.next = node2;
            prev = node2;
            node1 = temp;
            node2 = node2.next;
        }
        if(node1 != null)
            prev.next = node1;
    }
}
