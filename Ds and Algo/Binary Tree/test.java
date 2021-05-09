class test {
    public static void main(String[] args) {
        Binary Btree = new Binary();
        Btree.add(5);
        Btree.add(3);
        Btree.add(7);
        Btree.add(2);
        Btree.add(4);
        Btree.add(6);
        Btree.add(8);
        System.out.println(Btree.BinarySearchRecurs(8));
        System.out.println(Btree.BinarySearchRecurs(9));
    }
}