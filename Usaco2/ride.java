import java.util.*;
import java.io.File;
import java.io.IOException;
import java.io.PrintStream;
/*
ID: incredi2
LANG: JAVA
TASK: ride
*/
class ride {
    public void read() {
        File file = null;
        Scanner scan = null;
        try {
            file = new File("ride.in");
            scan = new Scanner(file);
        } catch (Exception e) {
            e.printStackTrace();
        }
        String comet = scan.nextLine();
        String group = scan.nextLine();
        this.solve(comet,group);
    }
    public void solve(String comet, String group) {
        int cometNum = 1;
        int groupNum = 1;
        for (int i = 0; i < comet.length(); i ++) {
            cometNum = cometNum * (((int)comet.charAt(i)) - 64);
        }
        for (int i = 0; i < group.length(); i ++) {
            groupNum = groupNum * (((int)group.charAt(i)) - 64);
        }
        if(cometNum%47 == groupNum%47) {
            System.out.println("GO");
        } else {
            System.out.println("STAY");
        }
    }
    public static void main(String[] args) {
        try {
            File file = new File("ride.out");
            PrintStream stream = new PrintStream(file);
            System.setOut(stream);
        } catch (Exception e) {
            e.printStackTrace();
        }
        ride rides = new ride();
        rides.read();
    }
}