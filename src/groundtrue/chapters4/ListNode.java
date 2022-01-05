package groundtrue.chapters4;

public class ListNode {
    public int val;
    public ListNode next;

    public ListNode(int val){
        this.val = val;
    }
    public ListNode append(ListNode head, int value){
        ListNode dumpy = new ListNode(0);
        dumpy.next = head;
        ListNode newNode = new ListNode(value);
        ListNode node = dumpy;
        while(node.next != null)
            node = node.next;
        node.next = newNode;
        return dumpy.next;
    }

    public ListNode delete(ListNode head, int value){
        ListNode dumpy = new ListNode(0);
        dumpy.next = head;
        ListNode node = dumpy;
        while(node.next != null){
            if (node.next.val == value){
                node.next = node.next.next;
                break;
            }
            node = node.next;
        }
        return dumpy.next;
    }
}
