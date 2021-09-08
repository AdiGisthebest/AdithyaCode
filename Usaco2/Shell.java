
import java.io.File;
import java.io.PrintStream;
import java.util.Scanner;

public class Shell {
    public void read() {
        File file1 = new File("shell.in");
        Scanner scanner  = null;
        try {
            scanner = new Scanner(file1);
        } catch (Exception e) {
            e.printStackTrace();
        }
        int[][] swap = new int[Integer.parseInt(scanner.nextLine())][3];
        for(int i = 0; i < swap.length; i++) {
            String[] arr = scanner.nextLine().split(" ");
            int[] swapAdd = new int[3];
            for(int j = 0; j < arr.length; j++) {
                swapAdd[j] = Integer.parseInt(arr[j]);
            }
            swap[i] = swapAdd;
        }
        int maxValue = 0;
        for(int i = 1; i < 4; i++) {
            int num = this.swap(i, swap);
            //System.out.println(num);
            if(num > maxValue) {
                maxValue = num;
            }
        }
        System.out.println(maxValue);
    }
    public int swap(int position, int[][] swaps) {
        int count = 0;
        for(int i = 0; i < swaps.length; i++) {
            //System.out.println(position + " " + swaps[i][0] + " "+ swaps[i][1]);
            if(swaps[i][0] == position) {
                position = swaps[i][1];
            } else if (swaps[i][1] == position) {
                position = swaps[i][0];
            }
            //System.out.println(position + " " + swaps[i][2]);
            if(swaps[i][2] == position) {
                count++;
            }
        }
        return count;
    }

    public static void main(String[] args) {
        try {
            File file = new File("shell.out");
            PrintStream stream = new PrintStream(file);
            System.setOut(stream);
        } catch (Exception e) {
            e.printStackTrace();
        }
        Shell shell = new Shell();
        shell.read();
    }
}
