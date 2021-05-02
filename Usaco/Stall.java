import java.util.*;
class Stall {
    public void read() {
        Scanner scan = new Scanner(System.in);
        int swaps = 0;
        scan.nextLine();
        String [] cowArrStr = scan.nextLine().split(" ");
        String [] barnArrStr = scan.nextLine().split(" ");
        int[] cowArr = new int[cowArrStr.length];
        int[] barnArr = new int[barnArrStr.length];
        int [] barnArrCopy = new int[barnArrStr.length];
        int[] workArr = new int[barnArrStr.length];
        int [] cowArrCopy = new int[cowArrStr.length];
        for(int i = 0; i < barnArr.length; i++) {
            cowArr[i] = Integer.parseInt(cowArrStr[i]);
            cowArrCopy[i] = Integer.parseInt(cowArrStr[i]);
            barnArr[i] = Integer.parseInt(barnArrStr[i]);
            barnArrCopy[i] = Integer.parseInt(cowArrStr[i]);
        }
        int cowSmallest = Integer.MAX_VALUE;
        int cowSmallestPos = 0;
        int barnSmallestPos = 0;
        int barnSmallest = Integer.MAX_VALUE;
        for(int i = 0; i < cowArr.length; i++) {
            for(int j = 0; j < cowArr.length; j++) {
                if(cowArr[j] < cowSmallest) {
                    cowSmallest = cowArr[j];
                    cowSmallestPos = j;
                }
                if(barnArr[j] < barnSmallest) {
                    barnSmallest = barnArr[j];
                    barnSmallestPos = j;
                }
            }
            workArr[barnSmallestPos] = cowSmallest;
            barnArr[barnSmallestPos] = Integer.MAX_VALUE;
            cowArr[cowSmallestPos] = Integer.MAX_VALUE;
            cowSmallestPos = 0;
            barnSmallestPos = 0;
            barnSmallest = Integer.MAX_VALUE;
            cowSmallest = Integer.MAX_VALUE;
        }
        for(int i = 0; i < cowArr.length; i++) {
            if(workArr[i] > barnArr[i]) {
                System.out.println(0);
                return;
            }
        }
        int power = 0;
        for(int i = 0; i < cowArr.length; i++) {
            for(int j = 0; j < cowArr.length; j++) {
                System.out.println(i + " " + j);
                if(barnArrCopy[j] <= workArr[i] && barnArrCopy[i] <= workArr[j] && i != j) {
                    power++;
                    System.out.println(barnArrCopy[j] +" "+ workArr[i] +" "+ barnArrCopy[i] +" "+ workArr[j]);
                }
            }
        }
        System.out.println(power);
        long ans = (long)Math.pow(2,power + 1);
        System.out.println(ans);
    }

    public static void main(String[] args) {
        Stall stall = new Stall();
        stall.read();
    }
}