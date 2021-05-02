import java.io.FileWriter;
import java.io.File;
import java.io.IOException;
class Array {
  LinkedList compact;
  int length;
  public Array () {
    compact = new LinkedList();
    length = 0;
  }
  public void compact(int[] startarr) {
    length = startarr.length;
    for (int i = 0; i < startarr.length; i++) {
      int num = startarr[i];
      int occ = 0;
      for (int j = i; j < startarr.length; j++) {
        if (j + 1 != startarr.length) {
          if (startarr[j + 1] == 0) {
            occ++;
          } else {
            break;
          }
        }
        i = j + 1;
      }
      System.out.println("hi" + " " + num + "#" + occ);
      compact.add(num + "#" + occ);
    }
  }
  public int[] decompress() {
    int [] decompress = new int[length];
    ListNode decom = compact.head;
    int num = 0;
    for (int i = 0; i < length; i++) {

      char [] letters = decom.val.toCharArray();
      String val = new String();
      for (int j = 0; j > -1; j++) {
        System.out.println("hi");
        if (letters[j] != '#') {
          val = val + letters[j];
        } else {
          num = j+1;
          break;
        }
      }
      int numb = Integer.valueOf(val);
      decompress[i] = numb;
      val = new String();
      for (int j = num; j < letters.length; j++) {
        val = val + letters[j];
      }
      numb = Integer.valueOf(val);
      i = i + numb;
      decom = decom.next;
    }
    return decompress;
  }
}
