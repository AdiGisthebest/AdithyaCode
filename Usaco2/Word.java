import java.util.*;
import java.io.File;
import java.io.IOException;
import java.io.PrintStream;
class Word {
    public void read () {
        File file = null;
        Scanner scan = null;
        try {
            file = new File("word.in");
            scan = new Scanner(file);
        } catch(Exception e) {
           e.printStackTrace();
        }
        String[] arr = scan.nextLine().split(" ");
        int length = Integer.parseInt(arr[0]);
        int WPL = Integer.parseInt(arr[1]);
        String[] essay = scan.nextLine().split(" ");
        int lineLen = 0;
        StringBuilder build = new StringBuilder();
        for(int i = 0; i < length; i++) {
            if(essay[i].length() + lineLen > WPL) {
                lineLen = 0;
                build.deleteCharAt(build.length() - 1);
                build.append("\n");
                build.append(essay[i] + " ");
                lineLen = lineLen + essay[i].length();
            } else {
                build.append(essay[i] + " ");
                lineLen = lineLen + essay[i].length();
            }
        }
        build.deleteCharAt(build.length() - 1);
        System.out.println(build.toString());
    }

    public static void main(String[] args) {
        try {
            File file = new File("word.out");
            PrintStream stream = new PrintStream(file);
            System.setOut(stream);
        } catch (Exception e) {
            e.printStackTrace();
        }
        Word word = new Word();
        word.read();
    }
}