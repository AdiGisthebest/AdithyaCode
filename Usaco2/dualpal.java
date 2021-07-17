import java.util.*;
import java.io.File;
import java.io.IOException;
import java.io.PrintStream;
import java.math.BigInteger;
/*
ID: incredi2
LANG: JAVA
TASK: dualpal
*/

class dualpal {
    public void read() {
        File file = null;
        Scanner scan = null;
        try {
            file = new File("dualpal.in");
            scan = new Scanner(file);
        } catch (Exception e) {
            e.printStackTrace();
        }
        String[] arr = scan.nextLine().split(" ");
        int after = Integer.parseInt(arr[0]);
        String num = arr[1];
        this.solve(after,num);
    }
    public void solve(int after, String num) {
        BigInteger bigInt = new BigInteger(num);
        int hits = 0;
        int checkHits = 0;
        while(hits < after) {
            bigInt = bigInt.add(BigInteger.ONE);
            for (int i = 2; i < 11; i++) {
                if (this.check(bigInt.toString(i))) {
                    checkHits++;
                }
                if (checkHits >= 2) {
                    hits++;
                    System.out.println(bigInt.toString(10));
                    break;
                }
            }
            checkHits = 0;
        }
    }
    public boolean check(String num) {
        for(int i = 0 ; i < num.length()/2; i++) {
            if(num.charAt(i) != num.charAt(num.length() - 1 - i)) {
                return false;
            }
        }
        return true;
    }
    public static void main(String[] args) {
        try {
            File file = new File("dualpal.out");
            PrintStream stream = new PrintStream(file);
            System.setOut(stream);
        } catch (Exception e) {
            e.printStackTrace();
        }
        dualpal pal = new dualpal();
        pal.read();
    }
}


