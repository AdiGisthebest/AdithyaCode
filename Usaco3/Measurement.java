

import java.io.File;
import java.io.PrintStream;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.Scanner;

public class Measurement {
    int display;
    public void read() {
        try {
            File file = new File("measurement.in");
            Scanner scan = new Scanner(file);
            int length = scan.nextInt();
            int bessie = 7;
            int elsie = 7;
            int mildred = 7;
            int billboard = 0;
            int ans = 0;
            ArrayList<triple> arrayList = new ArrayList<>();
            for (int i = 0; i < length; i++) {
                int day = scan.nextInt();
                String cow = scan.next();
                String[] number = scan.nextLine().split("");
                int multNum = 0;
                if(number[1].charAt(0) == '+') {
                    multNum = 1;
                } else {
                    multNum = -1;
                }
                int num = Integer.parseInt(number[2]) * multNum;
                switch (cow) {
                    case "Bessie":
                        arrayList.add(new triple(day, 1, num));
                        break;
                    case "Elsie":
                        arrayList.add(new triple(day, 2, num));
                        break;
                    case "Mildred":
                        arrayList.add(new triple(day, 3, num));
                        break;
                }
            }
            triple[] cowArr = new triple[arrayList.size()];
            arrayList.toArray(cowArr);
            Arrays.sort(cowArr);
            for(int i = 0; i < cowArr.length; i++) {
                //System.out.println(cowArr[i]);
                switch(cowArr[i].cow) {
                    case 1:
                        bessie = bessie + cowArr[i].num;
                    break;
                    case 2:
                        elsie = elsie + cowArr[i].num;
                    break;
                    case 3:
                        mildred = mildred + cowArr[i].num;
                }
                //System.out.println(bessie + " " + elsie + " " + mildred);
                if(this.findGreatest(bessie, elsie, mildred)) {
                    ans++;
                }
            }
            System.out.println(ans);
        } catch(Exception e){
            e.printStackTrace();
        }
    }
    public boolean findGreatest(int bessie, int elsie, int mildred) {
        int origDisplay = display;
        int newDisp = 0;
        if(bessie >= elsie && bessie >= mildred) {
            newDisp = newDisp + 1;
        }
        if(elsie >= bessie && elsie >= mildred) {
            newDisp = newDisp + 20;
        }
        if(mildred >= bessie && mildred >= elsie) {
            newDisp = newDisp + 300;
        }
        if(newDisp != origDisplay) {
            display = newDisp;
            return true;
        } else {
            display = newDisp;
            return false;
        }
    }
    public static void main(String[] args) {
        try {
            File file = new File("measurement.out");
            PrintStream stream = new PrintStream(file);
            System.setOut(stream);
        } catch (Exception e) {
            e.printStackTrace();
        }
        Measurement measurement = new Measurement();
        measurement.read();
    }
}
class triple implements Comparable {
    int day;
    int cow;
    int num;
    public triple(int inputDay, int inputCow, int inputNum) {
        day = inputDay;
        cow = inputCow;
        num = inputNum;
    }

    @Override
    public int compareTo(Object o) {
        triple objectTriple = (triple)o;
        if(objectTriple.day <= day) {
            return 1;
        } else {
            return -1;
        }
    }

    @Override
    public String toString() {
        return day + " " + cow + " " + num + " || ";
    }
}
