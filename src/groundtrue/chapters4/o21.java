package groundtrue.chapters4;

public class o21 {
    public ListNode removeNthFromEnd(ListNode head, int n) {
        ListNode dumpy = new ListNode(0);
        dumpy.next = head;
        ListNode front = head;
        ListNode back = dumpy;
        for( int i = 0; i < n; i++)
            front = front.next;
        while(front != null){
            front = front.next;
            back = back.next;
        }
        back.next = back.next.next;
        return dumpy.next;
    }
}
