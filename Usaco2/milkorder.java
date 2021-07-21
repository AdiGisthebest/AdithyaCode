import java.util.*;
import java.io.File;
import java.io.IOException;
import java.io.PrintStream;
import java.math.BigInteger;
class milkorder {
    public void read() {
        File file = null;
        Scanner scan = null;
        try {
            file = new File("milkorder.in");
            scan = new Scanner(file);
        } catch (Exception e) {
            e.printStackTrace();
        }
        String[] arr = scan.nextLine().split();
        int length = Integer.parseInt(arr[0]);
        int orderLength = Integer.parseInt(arr[1]);
        int posLength = Integer.parseInt(arr[2]);
        String[] order = scan.nextLine().split(" ");
        int[] intOrder = new int[gone.length];
        int[] taken = new int[posLength]
        LinkedList<Integer> list = new LinkedList<>();
        for(int i = 0; i < length; i++) {
            list.add(i);
        }
        for(int i = 0; i < posLength; i++){
            taken[i] = ;
            list.remove(intGone[i]);
        }

    }
    public void solve() {

    }
    public static void main(String[] args) {
        try {
            File file = new File("milkorder.out");
            PrintStream stream = new PrintStream(file);
            System.setOut(stream);
        } catch (Exception e) {
            e.printStackTrace();
        }
        milkorder milk = new milkorder();
        milk.read();
    }
}
