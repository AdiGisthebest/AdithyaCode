import java.util.*;
import java.io.File;
import java.io.IOException;
import java.io.PrintStream;
import java.math.BigInteger;
/*
ID: incredi2
LANG: JAVA
TASK: skidesign
*/

class skidesign {
    ArrayList<String> combinationsthree;
    ArrayList<String> combinationstwo;
    HashSet<String> numMap;
    public void read() {
        File file = null;
        Scanner scan = null;
        try {
            file = new File("skidesign.in");
            scan = new Scanner(file);
        } catch (Exception e) {
            e.printStackTrace();
        }
        int length = Integer.parseInt(scan.nextLine());
        int[] arr = new int[length];
        for(int i = 0; i < arr.length; i++) {
            arr[i] = Integer.parseInt(scan.nextLine());
        }
        Arrays.sort(arr);
        int[] diffsSort = new int[length/2];
        int min = arr[0];
        int propMin = 0;
        int count = 0;
        for(int i = 0; i < arr.length-1; i++) {
            if(propMin < arr[i]) {
                min = propMin;
            } else {
                min = arr[i];
            }
            diffsSort[i] = arr[length - 1 - i] - min;
            if(diffsSort[i] <= 17) {
                break;
            } else {
                int diff = diffsSort[i] - 17;
                if(diff%2 == 0) {
                    propMin = min + (int)Math.pow(((int)diff/2),2);
                    count = count + 2 * (int)Math.pow(((int)diff/2),2);
                } else {
                    propMin = min + (int)Math.pow(((int)diff/2),2);
                    count = count + (int)Math.pow(((int)diff/2 + 1),2) + (int)Math.pow(((int)diff/2),2);
                }
            }
        }
        System.out.println(count);
    }
    public void solve(String[] numSet) {

    }
    public static void main(String[] args) {
        try {
            File file = new File("skidesign.out");
            PrintStream stream = new PrintStream(file);
            System.setOut(stream);
        } catch (Exception e) {
            e.printStackTrace();
        }
        skidesign ski = new skidesign();
        ski.read();
    }
}