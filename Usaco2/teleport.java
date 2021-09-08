package Usaco2;

import java.io.File;
import java.io.PrintStream;
import java.util.Scanner;

public class teleport {
    public void read() {
        File file = new File("teleport.in");
        Scanner scanner = null;
        try{
            scanner = new Scanner(file);
        } catch (Exception e) {
            e.printStackTrace();
        }
        String[] nums = scanner.nextLine().split(" ");
        int manureStart = Integer.parseInt(nums[0]);
        int manureEnd = Integer.parseInt(nums[1]);
        if(manureStart > manureEnd) {
            int temp = manureStart;
            manureStart = manureEnd;
            manureEnd = temp;
        }
        int teleportStart = Integer.parseInt(nums[2]);
        int teleportEnd = Integer.parseInt(nums[3]);
        if(teleportStart > teleportEnd) {
            int temp = teleportStart;
            teleportStart = teleportEnd;
            teleportEnd = temp;
        }
        System.out.println(this.findTypeAndSolve(manureStart, manureEnd, teleportStart, teleportEnd));
    }
    public int findTypeAndSolve(int mStart, int mEnd, int tStart, int tEnd) {
        int totalDist = mEnd - mStart;
        if (mStart <= tStart) {
            //All inside
            if(mEnd >= tEnd) {
                int distSaved = tEnd - tStart;
                return totalDist - distSaved;
            } else {
                int distSaved = (mEnd - tStart) - (tEnd - mEnd);
                if(distSaved <= 0) {
                    return totalDist;
                } else {
                    return totalDist - distSaved;
                }
            }
        } else {
            if(tEnd > mEnd) {
                int distSaved = totalDist - ((mStart - tStart) + (tEnd - mEnd));
                if(distSaved <= 0) {
                    return totalDist;
                } else {
                    return totalDist - distSaved;
                }
            } else {
                int distSaved = (tEnd - mStart) - (mStart - tStart);
                if(distSaved <= 0) {
                    return totalDist;
                } else {
                    return totalDist - distSaved;
                }
            }
        }
    }
    public static void main(String[] args) {
        try {
            File file = new File("teleport.out");
            PrintStream stream = new PrintStream(file);
            System.setOut(stream);
        } catch (Exception e) {
            e.printStackTrace();
        }
        teleport port = new teleport();
        port.read();
    }
}
