class Exec {
  public String[] calc(String street) {
    String[] hi = new String[25];
    int pos = 0;
    Getdata data1 = new Getdata();
    Zillowdata data2 = new Zillowdata();
    String [][] housedata = data2.zillowPrices(data1.zillowCall(street));
    for ( int i = 0; i < housedata.length; i++) {
      System.out.println("---------------------------------");
      for (int j = 0; j < housedata[i].length; j++) {
        System.out.println(housedata[i][j]);
      }
    }
    for (int i = 0; i < housedata.length; i++) {
      if (!housedata[i][3].equals("") && !housedata[i][1].equals("")){
        if (Integer.parseInt(housedata[i][1]) * 75/10000 <= Integer.parseInt(housedata[i][3])) {
          if (data2.forSale(housedata[i][2])) {
            hi[pos] = housedata[i][0];
            pos++;
          }
        }
      }
    }
    return hi;
  }
  public static void main(String[] args) {
    Exec hi = new Exec();
    for (int i = 0; i < 100; i++) {
      String hi3 = Integer.toString(i);
      String [] hi2 = hi.calc(hi3);
      for (int j = 0;  j < 25; j++) {
        System.out.println(hi2[j]);
      }
    }
  }
}
