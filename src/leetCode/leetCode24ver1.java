package leetCode;
//遍历解法
public class leetCode24ver1 {
    public static void main(String[] args) {
        swapPairs(new ListNode(-1));
    }
    static ListNode swapPairs(ListNode head) {
        if(head==null||head.next==null){
            return head;
        }
        ListNode dummy = new ListNode(-1,head);

        ListNode prev = dummy;
        ListNode cur = head;
        ListNode next ;
        ListNode tmp;

        while(cur!=null&&cur.next!=null){
            next = cur.next;
            tmp = cur.next.next;

            prev.next = next;
            next.next = cur;
            cur.next  = tmp;

            prev = cur;
            cur = cur.next;
        }
        return dummy.next;
    }
}
