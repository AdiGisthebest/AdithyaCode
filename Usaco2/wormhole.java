import java.util.*;
import java.io.File;
import java.io.IOException;
import java.io.PrintStream;
import java.math.BigInteger;
/*
ID: incredi2
LANG: JAVA
TASK: wormhole
*/

class wormhole {
    ArrayList<ArrayList<int[]>> pairs = new ArrayList<>();
    HashMap<Integer,int[]> set = new HashMap<>();
    public void read() {
        File file = null;
        Scanner scan = null;
        try {
            file = new File("wormhole.in");
            scan = new Scanner(file);
        } catch (Exception e) {
            e.printStackTrace();
        }
        int length = Integer.parseInt(scan.nextLine());
        ArrayList<Integer> nums = new ArrayList<>();
        for(int i = 0; i < length; i++) {
            String[] arr =scan.nextLine().split(" ");
            int[] intArr = new int[2];
            intArr[0] = Integer.parseInt(arr[0]);
            intArr[1] = Integer.parseInt(arr[1]);
            set.put(i,intArr);
            nums.add(i);
        }
        this.recurse(new ArrayList<int[]>(),nums);
        this.check();
    }
    public void recurse(ArrayList<int[]> arr, ArrayList<Integer> nums) {
        if(nums.size() == 0) {
            pairs.add(arr);
            return;
        }
        for(int i = 0; i < nums.size(); i++) {
            for(int j = i+1; j < nums.size(); j++) {
                int[] pair = new int[2];
                pair[0] = nums.get(i);
                pair[1] = nums.get(j);ArrayList<int[]> arrClone = (ArrayList<int[]>)arr.clone();
                ArrayList<Integer> numClone = (ArrayList<Integer>)nums.clone();
                arrClone.add(pair);
                numClone.remove(i);
                numClone.remove(j-1);
                System.out.println(nums.size());
                this.recurse(arrClone,numClone);
            }
        }
    }
    public void check() {
        for(int i = 0; i < pairs.size(); i++) {
            for(int j = 0; j < pairs.get(i).size(); j++) {

            }
            System.out.println();
        }
    }
    public void valid(int[] pair, ArrayList<int[]> pairs) {
         int[] currentPos = pair;

    }
    public static void main(String[] args) {
        try {
            File file = new File("wormhole.out");
            PrintStream stream = new PrintStream(file);
            System.setOut(stream);
        } catch (Exception e) {
            e.printStackTrace();
        }
        wormhole worm = new wormhole();
        worm.read();
    }
}