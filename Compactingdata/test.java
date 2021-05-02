class test {
  public static void main(String[] args) {
    Array2 test = new Array2();
    int [] comp = {1,2,3,4,5,6,7,7,7,7,8,8,0,0,0,0,0,0,0,0,0,9,9,0,0,0,0,0,0,0,0,0,0};
    test.compress(comp);
    int[] hi = test.decompress();
    for (int i = 0; i < hi.length; i++) {
      System.out.println(hi[i]);
    }
  }
}
