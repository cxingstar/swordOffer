package groundtrue.chapters4;

public class o25 {

    public ListNode addTwoNumbers(ListNode l1, ListNode l2) {
        ListNode nodeA = reverse(l1);
        ListNode nodeB = reverse(l2);
        int carry = 0;
        ListNode dumpy = new ListNode(0);
        ListNode head = dumpy;
        while(nodeA != null && nodeB != null){
            int sum = nodeA.val + nodeB.val + carry;
            int val = sum % 10;
            carry = sum / 10;
            ListNode tmp = new ListNode(val);
            head.next = tmp;
            head = tmp;
            nodeA = nodeA.next;
            nodeB = nodeB.next;
        }
        ListNode nodeC = nodeA != null ? nodeA : nodeB;
        while(nodeC != null){
            int sum = nodeC.val + carry;
            int val = sum % 10;
            carry = sum / 10;
            ListNode tmp = new ListNode(val);
            head.next = tmp;
            head = tmp;
            nodeC = nodeC.next;
        }
        if(carry > 0){
            ListNode tmp = new ListNode(carry);
            head.next = tmp;
            head = tmp;
        }
        dumpy = reverse(dumpy.next);
        return dumpy;
    }

    public ListNode reverse(ListNode head){
        ListNode prev = null,cur = head;
        while(cur != null){
            ListNode next = cur.next;
            cur.next = prev;
            prev = cur;
            cur = next;
        }
        return prev;
    }
}
