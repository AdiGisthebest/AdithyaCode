import java.util.*;
import java.io.File;
import java.io.IOException;
import java.io.PrintStream;
/*
ID: incredi2
LANG: JAVA
TASK: milk2
*/

class milk2 {
    int[][] arr;
    int[][] sortArr;
    public void read() {
        File file = null;
        Scanner scan = null;
        try {
            file = new File("milk2.in");
            scan = new Scanner(file);
        } catch (Exception e) {
            e.printStackTrace();
        }
        int length = Integer.parseInt(scan.nextLine());
        arr = new int[length][3];
        sortArr = new int[length][2];
        for(int i = 0; i < length; i ++) {
            int[] addArr = new int[3];
            String[] strArr = scan.nextLine().split(" ");
            addArr[0] = Integer.parseInt(strArr[0]);
            addArr[1] = Integer.parseInt(strArr[1]);
            sortArr[i] = addArr;
        }
        Arrays.sort(sortArr, new Comparator<int[]>() {
            @Override
            public int compare(int[] first, int[] second) {
                if(first[0] > second[0]){
                    return 1;
                } else {
                    return -1;
                }
            }
        });
        /*for(int i = 0; i < length; i ++) {
            System.out.println(sortArr[i][0] + " " + sortArr[i][1] + " " + sortArr[i][2] + "   ");
        }*/
        int start = 0;
        int end = 0;
        int milk = 0;
        int gap = 0;
        int maxMilk = 0;
        int maxGap = 0;
        for(int i = 0; i < length; i ++) {
            int tempStart = sortArr[i][0];
            int tempEnd = sortArr[i][1];
            if(tempStart <= end) {
                if(tempEnd > end) {
                    end = tempEnd;
                }
                milk = end - start;
                if(milk >= maxMilk) {
                    maxMilk = milk;
                }
            } else if (start != 0) {
                gap = sortArr[i][0] - end;
                if(gap >= maxGap) {
                    maxGap = gap;
                }
                start = sortArr[i][0];
                end = sortArr[i][1];
            } else {
                start = sortArr[i][0];
                end = sortArr[i][1];
                maxMilk = end-start;
            }
        }
        System.out.println(maxMilk + " " +maxGap);
        /*for(int i = 0; i < arr.length; i++) {
            if(arr[i][2] == 0) {
                break;
            }
            milk = arr[i][1] - arr[i][0];
            if(milk > maxMilk) {
                maxMilk = milk;
            }
            if(i > 0) {
                gap = arr[i][0] - arr[i-1][1];
                if(gap > maxGap) {
                    maxGap = gap;
                }
            }
        }*/
        //System.out.println(maxMilk + " " + maxGap);
    }


    public void solve(String cowNum) {

    }
    public static void main(String[] args) {
        try {
            File file = new File("milk2.out");
            PrintStream stream = new PrintStream(file);
            System.setOut(stream);
        } catch (Exception e) {
            e.printStackTrace();
        }
        milk2 num = new milk2();
        num.read();
    }
}


