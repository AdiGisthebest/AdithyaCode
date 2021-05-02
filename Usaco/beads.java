import java.util.*;
import java.io.*;
/*
ID: incredi2
LANG: JAVA
TASK: friday
*/
class beads {
    public void read() {
        try {
            Scanner scan = new Scanner(new File("friday.in"));
            scan.nextLine();
            String str = scan.nextLine();
            this.fileWrite(this.solve(str));

        } catch (Exception e) {
            e.printStackTrace();
        }
    }
    public String solve(String str) {
        int ticks = 0;
        char prev = str.charAt(0);
        for(int i = 0; i < str.length(); i++) {
            if(str.charAt(i) == prev || str.charAt(i) == 'w') {
                str = str + str.charAt(i);
            } else {
                if (prev != 'w' && str.charAt(i) != 'w') {
                    ticks++;
                }
                prev = str.charAt(i);
                str = str + str.charAt(i);
            }
            if (ticks >= 2) {
                break;
            }
        }
        prev = str.charAt(0);
        int count = 0;
        int maxCount = 0;
        for(int i = 0; i < str.length(); i++) {
            if(str.charAt(i) == prev || str.charAt(i) == 'w') {
                count++;
                System.out.print(str.charAt(i) + " ");
            } else {
                if (prev != 'w' && str.charAt(i) != 'w') {
                    ticks++;
                }
                prev = str.charAt(i);
            }
            if (ticks >= 2) {
                if(count > maxCount) {
                    maxCount = count;
                }
                count = 0;
                ticks = 0;
                System.out.println();
            }
        }
        System.out.println(maxCount);
        return str;
    }

    public void fileWrite(String solution) {
        File file = new File("friday.out");
        try {
            FileWriter writer = new FileWriter(file);
            writer.append(solution);
            writer.flush();
            writer.close();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
    public static void main(String[] args) {
        beads frid = new beads();
        frid.read();
    }
}