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
        int length = Integer.parseInt(scan.nextLine());
        int limit = length;
        if(length >= 5) {
            length = 5;
        }
        String[] arr1 = scan.nextLine().split(" ");
        String[] arr2 = scan.nextLine().split(" ");
        for(int i = 0; i < arr1.length; i ++) {
            int a = Integer.parseInt(arr1[i]);
            int b = Integer.parseInt(arr2[i]);
            int subtract = 0;
            if(a > b) {
                if((a-b) > ((limit-a) + b)) {
                    subtract = (limit-a) + b;
                } else {
                    subtract = a-b;
                }
            } else {
                if ((b - a) > ((limit - b) + a)) {
                    subtract = (limit - b) + a;
                } else {
                    subtract = b-a;
                }
            }
            diffs[i] = subtract;
            if(diffs[i] < 5) {
                diffs[i] = 5 - diffs[i];
                if(diffs[i] > length) {
                    diffs[i] = length;
                }
            } else {
                diffs[i] = 0;
            }
        }
        int subtract = 1;
        int cube = 2 * (length * length * length);
        for(int i = 0; i < diffs.length; i++) {
            //System.out.print(diffs[i]);
            subtract = subtract * diffs[i];
        }
        //System.out.println();
        System.out.println(cube-subtract);
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
