package Usaco2;

import java.io.File;
import java.util.Scanner;

public class Hoofball {
    public void read() {
        File in = new File("hoofball.in");
        Scanner scanner = null;
        try {
            scanner = new Scanner(in);
        } catch(Exception e) {
            e.printStackTrace();
        }
        int length = Integer.parseInt(scanner.nextLine());
        String [] strArr = scanner.nextLine().split(" ");
        int[] arr = new int[length];
        for(int i = 0; i < length; i++) {
            arr[i] = Integer.parseInt(strArr[i]);
        }
        this.solve(arr);
    }
    public void solve(int[] arr) {
        int increase
        for(int i = 0; i < arr.length; i++) {

        }
    }
}
