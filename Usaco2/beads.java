import java.util.*;
import java.io.File;
import java.io.IOException;
import java.io.PrintStream;
/*
ID: incredi2
LANG: JAVA
TASK: beads
*/

class beads {
    public void read() {
        File file = null;
        Scanner scan = null;
        try {
            file = new File("beads.in");
            scan = new Scanner(file);
        } catch (Exception e) {
            e.printStackTrace();
        }
        int beadNum = Integer.parseInt(scan.nextLine());
        String beadStr = scan.nextLine();
        this.solve(beadStr, beadNum);
    }

    public void solve(String beadStr, int beadNum) {
        char[] doubleArr = new char[beadNum * 2];
        for (int i = 0; i < beadNum; i++) {
            doubleArr[i] = beadStr.charAt(i);
        }
        for (int i = 0; i < beadNum; i++) {
            doubleArr[i + beadNum] = beadStr.charAt(i);
        }
        char currChar = doubleArr[0];
        int deviations = 0;
        int count = 0;
        int maxCount = 0;
        for(int i = 0; i < doubleArr.length; i++) {
            for(int j = i; j < doubleArr.length; j++) {
                switch(doubleArr[j]) {
                    case 'b' :
                       if (currChar == 'r') {
                           deviations++;
                           currChar = 'b';
                       } else if (currChar == 'w') {
                           currChar = 'b';
                       }
                    break;
                    case 'r' :
                        if (currChar == 'b') {
                            deviations++;
                            currChar = 'r';
                        } else if (currChar == 'w') {
                            currChar = 'r';
                        }
                    break;
                }
                if (deviations >= 2) {
                    break;
                }
                count++;
            }
            if(count > maxCount) {
                maxCount = count;
            }
            count = 0;
            deviations = 0;
            currChar = 'w';
        }
        if(maxCount >= doubleArr.length/2) {
            maxCount = doubleArr.length/2;
        }
        System.out.println(maxCount);
    }

    public static void main(String[] args) {
        try {
            File file = new File("beads.out");
            PrintStream stream = new PrintStream(file);
            System.setOut(stream);
        } catch (Exception e) {
            e.printStackTrace();
        }
        beads bead = new beads();
        bead.read();
    }
}
