package groundtrue.chapters4;

public class o27 {
    public boolean isPalindrome(ListNode head) {
        ListNode dumpy = new ListNode(0);
        dumpy.next = head;
        ListNode slow = dumpy, fast = dumpy;
        while(fast != null && fast.next != null){
            slow = slow.next;
            fast = fast.next.next;
        }
        ListNode tail = slow.next;
        slow.next = null;
        tail = reverse(tail);
        return check(dumpy.next,tail);
    }

    private ListNode reverse(ListNode head){
        ListNode dumpy = new ListNode(0);
        dumpy.next = head;
        ListNode prev = null;
        ListNode cur = head;
        while(cur != null){
            ListNode next = cur.next;
            cur.next = prev;
            prev = cur;
            cur = next;
        }
        return prev;
    }

    private boolean check(ListNode l1,ListNode l2){
        while(l1 != null && l2 != null){
            if(l1.val != l2.val)
                return false;
            l1 = l1.next;
            l2 = l2.next;
        }
        return true;
    }
}
