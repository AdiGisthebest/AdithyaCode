import java.util.Date;
import java.text.SimpleDateFormat;
class CanBook {
  public Booking canBook(Booking validOrNot, LinkedLists hall) {
    ListNode find = hall.head;
    int timesinlist = 0;
    if (hall.head == null) {
      return null;
    }
    while (validOrNot.strtdate.compareTo(find.val.strtdate) <= 0) {
      timesinlist++;
      if (timesinlist == hall.length - 1) {
        break;
      }
      find = find.next;
      //System.out.println(find + " f");
    }
    //System.out.println(timesinlist);
    boolean retval1 = find.val.enddate.compareTo(validOrNot.strtdate) <= 0;
    find = hall.head;
    while (validOrNot.enddate.compareTo(find.val.strtdate) <= 0) {
      timesinlist++;
      if (timesinlist == hall.length - 1) {
        break;
      }
      find = find.next;
      //System.out.println(find + " f");
    }
    boolean retval = find.val.enddate.compareTo(validOrNot.enddate) <= 0;
    retval = retval && retval1;
    if (retval == true) {
      return null;
    } else {
      return find.val;
    }
  }
  public int Hallsort (Booking toBook) {
    Readfromfile hi = new Readfromfile();
    LinkedLists [] toTry = hi.read();
    if (this.canBook(toBook,toTry[0]) == null) {
      return 1;
    } else if (this.canBook(toBook,toTry[1]) == null) {
      return 2;
    } else if (this.canBook(toBook,toTry[2]) == null) {
      return 3;
    } else {
      return 0;
    }
  }
}
