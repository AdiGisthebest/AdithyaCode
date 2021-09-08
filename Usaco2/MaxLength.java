import java.io.File;
import java.io.PrintStream;
import java.util.Scanner;

public class MaxLength {
    public void read() {
        Scanner scan = null;
        File file = new File("socdist1.in");
        try {
            scan = new Scanner(file);
        } catch (Exception e) {
            e.printStackTrace();
        }
        int length = Integer.parseInt(scan.nextLine());
        int[] arr = new int[length];
        String[] strArr = scan.nextLine().split("");
        for (int i = 0; i < length; i++) {
            arr[i] = Integer.parseInt(strArr[i]);
        }
        int maxLength = 0;
        int max2Length = 0;
        int firstPos = 0;
        int count = 0;
        int minDist = Integer.MAX_VALUE;
        for(int i = 0; i < length; i++) {
            if(arr[i] == 1) {
                i++;
                count = 0;
                while(i < length && arr[i] == 0) {
                    count++;
                    i++;
                }
                if(i >= length-1) {
                    break;
                }
                i--;
                //System.out.println(count);
            }
            if(count >= maxLength) {
                max2Length = maxLength;
                maxLength = count;
            } else if (count > max2Length){
                max2Length = count;
            } else if(count < minDist) {
                minDist = count;
            }
        }
        int num1 = (maxLength - 1)/2;
        int num2 = (max2Length-1)/2;
        if(num2 < minDist) {
            System.out.println(num2 + 1);
        } else {
            System.out.println(minDist + 1);
        }
    }
    public static void main(String[] args) {
        try {
            File file = new File("socdist1.out");
            PrintStream stream = new PrintStream(file);
            System.setOut(stream);
        } catch (Exception e) {
            e.printStackTrace();
        }
        MaxLength maxlength = new MaxLength();
        maxlength.read();
    }
}
