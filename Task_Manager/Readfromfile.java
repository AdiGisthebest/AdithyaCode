import java.io.*;
import java.util.*;
import java.text.*;
import java.nio.file.Path;
import java.nio.file.Paths;
class Readfromfile {
  public LL read() {
    Manager master = new Manager();
    LL retval = new LL();
    SimpleDateFormat hi = new SimpleDateFormat("yyyy-MM-dd-hh-mm");
    Date duedate;
    try {
      String line;
      int preserve = 0;
      Path path = Paths.get("File1.txt");
      Scanner scan = new Scanner(path);
      while (scan.hasNextLine()) {
        Task addToList = new Task(null,null);
        line = scan.nextLine();
        String [] linearr = line.split("\t");
        master.add(linearr[1],linearr[0]);
        try {
          duedate = hi.parse(linearr[1].trim());
        } catch(ParseException e) {
          System.out.println("Enter date in yyyy-MM-dd-hh-mm format");
          System.exit(-1);
        }
      }
    } catch (IOException e) {
      System.out.println(e.getMessage());
    }
    retval = master.tasks;
    return retval;
  }
  public static void main(String[] args) {
    Readfromfile test = new Readfromfile();
    test.read();
  }
}
