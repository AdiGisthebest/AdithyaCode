import java.util.Scanner;
import java.io.File;
import java.io.FileWriter;
import java.util.LinkedList;
import java.util.ListIterator;
class guess {
    public void read(){
        try {

            this.fileWrite(this.Solution(order,getStr));
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
    public String Solution() {

    }
    public void fileWrite(String solution) {
        try {
            File file = new File("breedflip.out");
            System.out.println(solution);
            FileWriter writer = new FileWriter(file);
            writer.append(solution);
            writer.flush();
            writer.close();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public static void main(String[] args) {
        guess solution = new guess();
        solution.read();
    }
}