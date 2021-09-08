import java.io.File;
import java.io.PrintStream;
import java.util.Scanner;

public class Lifeguards {
    public void read() {
        try {
            Scanner scan = new Scanner(new File("lifeguards.in"));
            int length = Integer.parseInt(scan.nextLine());
            int[] time = new int[1000];
            int[][] lifeguards = new int[length][2];
            int maxCount = 0;
            for(int i = 0; i < length; i++) {
                String[] arr = scan.nextLine().split(" ");
                int start = Integer.parseInt(arr[0]);
                int end = Integer.parseInt(arr[1]);
                lifeguards[i][0] = start;
                lifeguards[i][1] = end;
            }
            for(int i = 0; i < length; i++) {
                int count = 0;
                for(int j = 0; j < length; j++) {
                    if(j != i) {
                        int start = lifeguards[j][0];
                        int end = lifeguards[j][1];
                        for(int k = start; k < end; k++) {
                            time[k] = 1;
                        }
                    }
                }
                for(int j = 0; j < 1000; j++) {
                    //System.out.print(time[j]);
                    if(time[j] == 1) {
                        count++;
                    }
                }
                //System.out.println();
                if(count > maxCount) {
                    maxCount = count;
                }
                time = new int[1000];
            }
            System.out.println(maxCount);
        } catch(Exception e) {
            e.printStackTrace();
        }
    }

    public static void main(String[] args) {
        try {
            File file = new File("lifeguards.out");
            PrintStream stream = new PrintStream(file);
            System.setOut(stream);
        } catch (Exception e) {
            e.printStackTrace();
        }
        Lifeguards lifeguard = new Lifeguards();
        lifeguard.read();
    }
}
