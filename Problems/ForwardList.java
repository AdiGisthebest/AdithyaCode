public class ForwardList {
    ListNode head;
    ListNode tail;
    int length;
    public void add(int num) {
        ListNode addNode = new ListNode(num);
        if(head == null) {
            head = addNode;
            tail = addNode;
            length++;
        } else {
            tail.next = addNode;
            tail = addNode;
            length++;
        }
    }
    public boolean search(int num) {
        ListNode findNode = head;
        if(findNode.val == num) {
            return true;
        }
        for(int i = 0; i < length-1; i++) {
            if(findNode.next.val == num) {
                ListNode tempNode = findNode.next;
                findNode.next = findNode.next.next;
                tempNode.next = head;
                head = tempNode;
                return true;
            } else {
                findNode = findNode.next;
            }
        }
        return false;
    }
    public void printlist() {
        ListNode findNode = head;
        for(int i = 0; i < length; i++) {
            System.out.print(findNode.val+" ");
            findNode = findNode.next;
        }
        System.out.println();
    }

    public static void main(String[] args) {
        ForwardList forward = new ForwardList();
        forward.add(5);
        forward.add(7);
        forward.add(8);
        forward.add(2);
        forward.add(11);
        forward.search(7);
        forward.printlist();
        forward.search(11);
        forward.printlist();
    }
}
class ListNode {
    int val;
    ListNode next;
    public ListNode(int num) {
        val = num;
        next = null;
    }
}
