class LL {
  Node head;
  Node tail;
  int length;
  public void add(Task num){
    Node add = new Node(num);
    if (head == null) {
        head = add;
        tail = add;
        length++;
    } else {
      tail.next = add;
      tail = add;
      length++;
    }
  }
  public void add(Task num, int index) {
    Node find = head;
    Node add = new Node(num);
    length++;
    for (int i = 0; i < index; i++) {
      find = find.next;
    }
    add.next = find.next;
    find.next = add;
  }
  public void del(int index) {
    length--;
    Node find = head;
    if (index == length) {
      for (int  i = 0; i < index - 1; i++) {
        find = find.next;
      }
      find.next = null;
      tail = find;
    } else {
      for (int i = 0 ; i < index; i++) {
        find = find.next;
      }
      if (find == head) {
        head = find.next;
      } else {
        find.val = find.next.val;
        find.next = find.next.next;
      }
    }
  }
}
