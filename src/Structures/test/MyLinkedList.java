package Structures.test;

public class MyLinkedList<e> {
    Node head ;
    class Node {
        int val;
        Node next;
        Node(int val){
            this.val = val;
            next = null;
        }
    }
    public MyLinkedList(){
        head = null;
    }

    void addAtHead(int val){
        Node n = new Node(val);
        n.next=head;
        head = n;
    }
    void addAtTail(int val){
        Node n = new Node(val);
        if(head == null){
            head = n;
        }else{
            Node current = head;
            while(current.next !=null){
                current = current.next;
            }
            current.next = n;
        }
    }
    void delete(int val) {
        //1.链表为空2.是头节点3.是中间或者尾部节点4.没找到
        if(head == null){
            return;
        }
        if(head.val == val){
            head = head.next;
            return;
        }
        Node current =head;
        Node pre = null;
        while(current!=null && current.val != val){
            pre = current;
            current = current.next;
        }
        if(current!= null){
            pre.next = current.next;
        }else {
            System.out.println("未找到");
        }

    }
    boolean find(int val){
        if(head == null){
            return false;
        }
        Node current = head;
        while(current != null){
            if(current.val == val){
                return true;
            }
            current = current.next ;
        }
        return false;
    }
    int get(int index){
        if(index<0){
            return -1;
        }
        if(head == null){
            return -1;
        }
        Node current = head;
        for (int i = 0; i < index ; i++) {
            if(current.next == null){
                return -1;
            }
            current = current.next;
        }
        return current.val;
    }
    void reverse(){
        if(head == null ||head.next == null){
            return;
        }
        Node current = head;
        Node prev = null;
        Node next = null;
        while(current != null){
            next = current.next;
            current.next = prev;
            prev = current;
            current = next;
        }
        head = prev;

    }


}
