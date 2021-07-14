import java.util.*;
import java.io.File;
import java.io.IOException;
import java.io.PrintStream;
/*
ID: incredi2
LANG: JAVA
TASK: transform
*/

class transform {
    public void read() {
        File file = null;
        Scanner scan = null;
        try {
            file = new File("transform.in");
            scan = new Scanner(file);
        } catch (Exception e) {
            e.printStackTrace();
        }
        int length = Integer.parseInt(scan.nextLine());
        int [][] arr = new int[length][length];
        int[][] transformArr = new int[length][length];;
        for(int j = 0; j < length; j++) {
            int[] addArr = new int[length];
            char[] addStr = scan.nextLine().toCharArray();
            for(int i = 0; i < addArr.length; i++) {
                switch(addStr[i]) {
                    case '@':
                        addArr[i] = 1;
                    break;
                    case '-':
                        addArr[i] = 0;
                    break;
                }
            }
            arr[j] = addArr;
        }
        for(int j = 0; j < length; j++) {
            int[] addArr = new int[length];
            char[] addStr = scan.nextLine().toCharArray();
            for(int i = 0; i < addArr.length; i++) {
                switch(addStr[i]) {
                    case '@':
                        addArr[i] = 1;
                        break;
                    case '-':
                        addArr[i] = 0;
                        break;
                }
            }
            transformArr[j] = addArr;
        }
        this.solve(arr,transformArr);
    }
    public void solve(int [][] arr, int [][] transform) {
        int lowestNumber = Integer.MAX_VALUE;
        int num = 0;
        arr = this.reflect(arr);
        if(this.check(arr,transform)) {
            num = 4;
            if(num < lowestNumber) {
                lowestNumber = num;
            }
        }
        arr = this.reflect(arr);
        for(int i = 0; i < 8; i ++) {
            if(i%2==0) {
                arr = this.rotate(arr);
                if(this.check(arr,transform)) {
                    num = i/2 + 1;
                    if(num < lowestNumber) {
                        lowestNumber = num;
                    }
                }
            } else {
                arr = this.reflect(arr);
                if(this.check(arr,transform)) {
                    num = 5;
                    if(num < lowestNumber) {
                        lowestNumber = num;
                    }
                }
                arr = this.reflect(arr);
            }
        }
        if(this.check(arr,transform)) {
            num = 6;
            if(num < lowestNumber) {
                lowestNumber = num;
            }
        } else {
            num = 7;
            if(num < lowestNumber) {
                lowestNumber = num;
            }
        }
        System.out.println(lowestNumber);
    }
    public int [][] rotate(int[][] arr) {
        int [][] ansArr = new int[arr.length][arr.length];
        for(int i = 0; i < arr.length; i++) {
            for(int j = 0; j < arr.length; j++) {
                ansArr[i][j] = arr[arr.length-1-j][i];
            }
        }
        return ansArr;
    }
    public boolean check(int [][] arr1, int [][] arr2) {
        for(int i = 0; i < arr1.length; i ++) {
            for(int j = 0; j < arr1[0].length; j++) {
                if(arr1[i][j] != arr2[i][j]) {
                    return false;
                }
            }
        }
        return true;
    }
    public int[][] reflect(int [][] arr) {
        int [][] ansArr = new int[arr.length][arr.length];
        for(int i = 0; i < arr.length; i++) {
            for(int j = 0; j < arr.length; j++) {
                ansArr[i][j] = arr[i][arr.length - 1 - j];
            }
        }
        return ansArr;
    }
    public static void main(String[] args) {
        try {
            File file = new File("transform.out");
            PrintStream stream = new PrintStream(file);
            System.setOut(stream);
        } catch (Exception e) {
            e.printStackTrace();
        }
        transform num = new transform();
        num.read();
    }
}


