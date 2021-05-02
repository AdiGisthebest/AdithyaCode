class Array2 {
  Arrayindicator [] compressed;
  int length;
  int count;
  int arraylength;
  public Array2 () {
    arraylength = 0;
    length = 100;
    count = 0;
    compressed = new Arrayindicator[length];
  }
  public void compress(int [] compressing) {
    arraylength = compressing.length;
    for (int i = 0; i < compressing.length; i++) {
      if (i == length) {
        length = length * 10;
        Arrayindicator[] copy = new Arrayindicator[length];
        for (int j = 0; j < length; j++) {
          copy[j] = compressed[j];
        }
        compressed = copy;
      }
      if (compressing[i] != 0) {
        compressed [count] = new Arrayindicator();
        compressed[count].value = compressing[i];
        compressed[count].position = i;
        count++;
      }
    }
  }
  public int [] decompress () {
    int[] decompressed = new int[arraylength];
    for (int i = 0; i < compressed.length; i++) {
      if (compressed[i] != null) {
        decompressed[compressed[i].position] = compressed[i].value;
      }
    }
    return decompressed;
  }
}
