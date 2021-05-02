import java.io.File;
import java.io.FileWriter;
import  java.io.IOException;
import java.util.Scanner;
import java.util.Date;
import java.text.SimpleDateFormat;
import java.text.ParseException;
class Datatofile {
  public void fileWrite(String Task ,String duedate) {
    try {
      File file;
      FileWriter fw;
      file = new File("File1.txt");
      fw = new FileWriter(file,true);
      fw.append(Task + "\t" + duedate + "\n");
      fw.flush();
      fw.close();
    } catch (IOException e) {
      System.out.println(e.getMessage());
    }
  }
  public static void main(String[] args) {
    Datatofile test = new Datatofile();
  }
}
