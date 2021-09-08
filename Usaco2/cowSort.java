import java.io.File;
import java.io.PrintStream;
import java.util.Scanner;

public class cowSort {
    public void read() {
        File file = new File("sleepy.in");
        Scanner scanner = null;
        try {
            scanner = new Scanner(file);
        } catch(Exception e) {
            e.printStackTrace();
        }
        int length = Integer.parseInt(scanner.nextLine());
        String[] arr = scanner.nextLine().split(" ");
        int[] cows = new int[length];
        for(int i = 0; i <length; i ++) {
            cows[i] = Integer.parseInt(arr[i]);
        }
        int sortNum = 1;
        for(int i = 1; i < length; i++) {
            if(cows[i] > cows[i-1]) {
                sortNum++;
            } else {
                sortNum = 1;
            }
        }
        System.out.println(length - sortNum);
    }

    public static void main(String[] args) {
        try {
            File file = new File("sleepy.out");
            PrintStream stream = new PrintStream(file);
            System.setOut(stream);
        } catch (Exception e) {
            e.printStackTrace();
        }
        cowSort cow = new cowSort();
        cow.read();
    }
}
