import java.util.HashMap;
import java.util.Date;
class CanBook {
  Readfromfile hi = new Readfromfile();
  HashMap <Date,Booking> data = hi.read();
  public boolean canBook(Booking toBook) {
    if (data == null) {
      return true;
    }
    Date add = new Date();
    long epochtime = toBook.enddate.getTime();
    long epochtime2 = toBook.strtdate.getTime();
    while (epochtime2 <= epochtime) {
      add.setTime(epochtime2);
      if (data.containsKey(add)) {
        System.out.println("This time slot has been booked");
        return false;
      }
      epochtime2 = epochtime2 + 1800000;
    }
    return true;
  }
}
