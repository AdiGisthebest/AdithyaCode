import java.io.File;
import java.io.PrintStream;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.Scanner;

public class Socdist2 {
    public void read() {
        File file = new File("socdist2.in");
        Scanner scan= null;
        try {
            scan = new Scanner(file);
        } catch(Exception e) {
            e.printStackTrace();
        }
        int length = Integer.parseInt(scan.nextLine());
        int[] cowPos = new int[length];
        HashMap<Integer,Integer> cowSick = new HashMap<>();
        for(int i = 0; i < length; i++) {
            String[] arr = scan.nextLine().split(" ");
            cowPos[i] = Integer.parseInt(arr[0]);
            cowSick.put(cowPos[i],Integer.parseInt(arr[1]));
        }
        Arrays.sort(cowPos);
        ArrayList<Integer> arrayList = new ArrayList<>();
        int minR = Integer.MAX_VALUE;
        int count = 0;
        for(int i = 0; i < length; i++) {
            if(cowSick.get(cowPos[i]) == 0) {
                if(i != length - 1) {
                    if(cowSick.get(cowPos[i+1]) == 1) {
                        int num = cowPos[i+1] - cowPos[i];
                        if(num < minR) {
                            minR = num;
                        }
                    }
                }
            } else {
                if(i != length - 1) {
                    if(cowSick.get(cowPos[i+1]) == 0) {
                        int num = cowPos[i+1] - cowPos[i];
                        if(num < minR) {
                            minR = num;
                        }
                    }
                }
            }
        }
        for(int i = 0; i < length; i ++) {
            if(cowSick.get(cowPos[i]) == 1) {
                arrayList.add(cowPos[i]);
                if(i == length-1 || cowSick.get(cowPos[i+1]) == 0) {
                    //System.out.println(arrayList);
                    //System.out.println(minR);
                    Integer[] arr = new Integer[arrayList.size()];
                    arrayList.toArray(arr);
                    count = count + this.getSubArrCnt(minR, arr);
                    arrayList = new ArrayList<>();
                }
            }
        }
        System.out.println(count);
    }
    public int getSubArrCnt(int maxNum, Integer[] subArr) {
        int count = 1;
        maxNum = maxNum - 1;
        for(int i = 0; i < subArr.length; i++) {
            if(i != 0) {
                if((subArr[i] - subArr[i-1]) > maxNum) {
                    //System.out.println("in");
                    count++;
                }
            }
        }
        return count;
    }

    public static void main(String[] args) {
        try {
            File file = new File("socdist2.out");
            PrintStream stream = new PrintStream(file);
            System.setOut(stream);
        } catch (Exception e) {
            e.printStackTrace();
        }
        Socdist2 socdist2 = new Socdist2();
        socdist2.read();
    }
}
