package leetCode;
//递归解法
//太巧妙了
public class leetCode24ver2 {
    public static void main(String[] args) {

    }
    ListNode swapPairs(ListNode head) {
        if(head==null||head.next==null){
            return head;
        }
        ListNode fisrt = head;
        ListNode second = head.next;
        ListNode restOfListNode =swapPairs(second.next);

        second.next = fisrt;
        fisrt.next = restOfListNode;

        return second;
    }
}
