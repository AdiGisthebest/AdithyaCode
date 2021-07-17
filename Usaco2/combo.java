import java.util.*;
import java.io.File;
import java.io.IOException;
import java.io.PrintStream;
/*
ID: incredi2
LANG: JAVA
TASK: combo
*/

class combo {
    public void read() {
        File file = null;
        Scanner scan = null;
        try {
            file = new File("combo.in");
            scan = new Scanner(file);
        } catch (Exception e) {
            e.printStackTrace();
        }
        int[] diffs = new int[3];
        scan.nextLine();
        String[] arr1 = scan.nextLine().split(" ");
        String[] arr2 = scan.nextLine().split(" ");
        for(int i = 0; i < arr1.length; i ++) {
            diffs[i] = Math.abs(Integer.parseInt(arr1[i]) - Integer.parseInt(arr2[i]));
            if(diffs[i] < 5) {
                diffs[i] = 5 - diffs[i];
            } else {
                diffs[i] = 0;
            }
        }
        int subtract = 1;
        for(int i = 0; i < diffs.length; i++) {
            subtract = subtract * diffs[i];
        }
        System.out.println(250-subtract);
    }

    public void solve() {

    }

    public static void main(String[] args) {
        try {
            File file = new File("combo.out");
            PrintStream stream = new PrintStream(file);
            System.setOut(stream);
        } catch (Exception e) {
            e.printStackTrace();
        }
        combo comb = new combo();
        comb.read();
    }
}
