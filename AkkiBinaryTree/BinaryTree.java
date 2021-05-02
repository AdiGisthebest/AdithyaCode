class BinaryTree {
  Node head = null;
  public void add(num) {
    Node find = head;
    if(head == null){
      head.value = num;

    } else {
      while (find.right == null || find.left == null){
        if (num > find.val){
          find = find.right;
        } else {
          find = find.left;
        }
      }
    }

  }
}
