import java.io.*;
import java.util.HashMap;
import java.util.Scanner;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.Date;
import java.text.SimpleDateFormat;
import java.text.ParseException;
class Readfromfile {
  public HashMap<Date,Booking> read() {
    HashMap <Date, Booking> retval = new HashMap<Date, Booking>();
    try {
      String line;
      int preserve = 0;
      Path path = Paths.get("File1.txt");
      Scanner scan = new Scanner(path);
      while (scan.hasNextLine()) {
        Booking addToList = new Booking();
        line = scan.nextLine();
        String [] linearr = line.split("\t");
        addToList = this.strToBook(linearr[1],linearr[2],linearr[0]);
        retval = this.add(retval, addToList.strtdate, addToList.enddate, addToList);
      }
    } catch (IOException e) {
      System.out.println(e.getMessage());
    }
    return retval;
  }
  public HashMap<Date,Booking> add(HashMap<Date,Booking> toAdd, Date strt, Date end, Booking added) {
    long epochtime = end.getTime();
    long epochtime2 = strt.getTime();
    Date add = new Date();
    while (epochtime2 <= epochtime) {
      add.setTime(epochtime2);
      toAdd.put(add,added);
      epochtime2 = epochtime2 + 1800000;
    }
    return toAdd;
  }
  public Booking strToBook(String strtdate, String enddate, String name) {
    SimpleDateFormat date = new SimpleDateFormat("yyyy-MM-dd-hh-mm");
    Booking retval = new Booking();
    retval.name = name;
    try {
      retval.strtdate = date.parse(strtdate.trim());
    } catch (ParseException e) {
      System.out.println(e.getMessage());
    }
    try {
      retval.enddate = date.parse(enddate.trim());
    } catch (Exception e) {
      System.out.println(e.getMessage());
    }
    return retval;
  }
  public static void main(String[] args) {
    Readfromfile test = new Readfromfile();
    test.read();
  }
}
