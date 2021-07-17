import java.util.*;
import java.io.File;
import java.io.IOException;
import java.io.PrintStream;
import java.math.BigInteger;
/*
ID: incredi2
LANG: JAVA
TASK: milk
*/

class milk {
    PriorityQueue<int[]> queue;
    public void read() {
        File file = null;
        Scanner scan = null;
        try {
            file = new File("milk.in");
            scan = new Scanner(file);
        } catch (Exception e) {
            e.printStackTrace();
        }
        String[] arr = scan.nextLine().split(" ");
        int total = Integer.parseInt(arr[0]);
        int length = Integer.parseInt(arr[1]);
        if (length == 0) {
            System.out.println(0);
            return;
        }
        queue = new PriorityQueue<>(length,new compare());
        for(int i = 0; i < length; i++) {
            String[] splitArr = scan.nextLine().split(" ");
            int[] intArr = new int[2];
            intArr[0] = Integer.parseInt(splitArr[0]);
            intArr[1] = Integer.parseInt(splitArr[1]);
            queue.add(intArr);
        }
        this.solve(total);
    }
    public void solve(int total) {
        int boughtMilk = 0;
        int cost = 0;
        while(boughtMilk < total) {
            int[] arr = queue.poll();
            if((arr[1] + boughtMilk) < total) {
                cost = cost + (arr[0] * arr[1]);
                boughtMilk = boughtMilk + arr[1];
            } else {
                int buyNeed = (total - boughtMilk);
                cost = cost + (arr[0] * buyNeed);
                boughtMilk = boughtMilk + buyNeed;
                break;
            }
        }
        System.out.println(cost);
    }
    public static void main(String[] args) {
        try {
            File file = new File("milk.out");
            PrintStream stream = new PrintStream(file);
            System.setOut(stream);
        } catch (Exception e) {
            e.printStackTrace();
        }
        milk farmMilk = new milk();
        farmMilk.read();
    }
}
class compare implements Comparator<int[]> {
    public int compare(int[] a, int[] b)
    {
        if(a[0] > b[0]) {
            return 1;
        } else {
            return -1;
        }
    }
}

