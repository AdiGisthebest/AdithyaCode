//Binary Tree using Node
class Binary {
    Node root;
    public void add(int val) {
        Node addNode = new Node(val);
        if(root == null) {
            root = addNode;
        } else {
            Node currNode = root;
            while(true) {
                if(addNode.value > currNode.value) {
                    if(currNode.right == null) {
                        currNode.right = addNode;
                        break;
                    } else {
                        currNode = currNode.right;
                    }
                } else {
                    if(currNode.left == null) {
                        currNode.left = addNode;
                        break;
                    } else {
                        currNode = currNode.left;
                    }
                }
            }
        }
    }
    public boolean BinarySearchRecurs(int val) {
        return BinarySearchRecurs(val,root);
    }
    public boolean BinarySearchRecurs(int num, Node currNode) {
        if(num == currNode.value) {
            return true;
        }
        if(num > currNode.value) {
            if(currNode.right == null) {
                return false;
            } else {
                return this.BinarySearchRecurs(num,currNode.right);
            }
        } else {
            if(currNode.left == null) {
                return false;
            } else {
                return this.BinarySearchRecurs(num,currNode.left);
            }
        }
    }
}