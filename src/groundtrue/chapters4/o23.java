package groundtrue.chapters4;

public class o23 {
    public class Solution {
        public ListNode getIntersectionNode(ListNode headA, ListNode headB) {
            int lenA = getListNodeLength(headA);
            int lenB = getListNodeLength(headB);
            ListNode nodeA = headA;
            ListNode nodeB = headB;
            if(lenB > lenA){
                for(int i = 0; i < lenB - lenA; i++)
                    nodeB = nodeB.next;
            }else{
                for(int i = 0; i < lenA - lenB; i++)
                    nodeA = nodeA.next;
            }
            while(nodeA != null && nodeB != null){
                if(nodeA == nodeB)
                    return nodeA;
                else{
                    nodeA = nodeA.next;
                    nodeB = nodeB.next;
                }
            }
            return null;
        }
        private int getListNodeLength(ListNode head){
            int len = 0;
            ListNode node = head;
            while(node != null){
                node = node.next;
                len++;
            }
            return len;
        }
    }
}
