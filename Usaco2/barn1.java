import java.util.*;
import java.io.File;
import java.io.IOException;
import java.io.PrintStream;
import java.math.BigInteger;
/*
ID: incredi2
LANG: JAVA
TASK: barn1
*/

class barn1 {
    public void read() {
        File file = null;
        Scanner scan = null;
        try {
            file = new File("barn1.in");
            scan = new Scanner(file);
        } catch (Exception e) {
            e.printStackTrace();
        }
        String[] arr = scan.nextLine().split(" ");
        int gapNum = Integer.parseInt(arr[0]);
        int total = Integer.parseInt(arr[1]);
        int length = Integer.parseInt(arr[2]);
        int [] gaps = new int[gapNum - 1];
        int lastNum = 0;
        int gapIter = 0;
        int prevNum = 0;
        int [] intArr = new int[length];
        for(int i = 0; i < intArr.length; i++) {
            intArr[i] = Integer.parseInt(scan.nextLine());
        }
        Arrays.sort(intArr);
        int firstNum = intArr[0];
        prevNum = firstNum;
        for(int i = 1; i < length; i++) {
            int num = intArr[i];
            int lowPos = 10000;
            int lowNum = 10000;
            if(i == (length - 1)) {
                lastNum = num;
            }
            for(int j = 0; j < gaps.length; j++) {
                if(gaps[j] < lowNum) {
                    lowNum = gaps[j];
                    lowPos = j;
                }
            }
            if((num - prevNum) > lowNum) {
                gaps[lowPos] = num-prevNum;
            }
            prevNum = num;
        }
        int gapAdd = 0;
        for(int i = 0; i < gaps.length; i ++) {
            if(gaps[i] != 0) {
                gapAdd = gapAdd + (gaps[i] - 1);
            }
        }
        int totalGap = (firstNum - 1) + (total - lastNum) + gapAdd;
        System.out.println(total-totalGap);
    }
    public static void main(String[] args) {
        try {
            File file = new File("barn1.out");
            PrintStream stream = new PrintStream(file);
            System.setOut(stream);
        } catch (Exception e) {
            e.printStackTrace();
        }
        barn1 barn = new barn1();
        barn.read();
    }
}
