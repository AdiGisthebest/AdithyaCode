/*
ID: incredi2
LANG: JAVA
TASK: race
 */
import java.io.PrintWriter;
import java.io.File;
import java.io.FileWriter;
import java.util.Scanner;
import java.util.ListIterator;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Collections;
class race {
    int reps = 0;
    //Reads from file
    public void read() {
        try {
            File input = new File("race.in");
            Scanner scanner = new Scanner(input);
            String[] dist = scanner.nextLine().split(" ");
            int len = Integer.parseInt(dist[1]);
            int[] x = new int [len];
            for(int i = 0; i < len; i++) {
                x[i] = Integer.parseInt(scanner.nextLine());
                reps++;
            }
            this.fileWrite(this.solution(x,Integer.parseInt(dist[0])));
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
    //The method that contains my solution
    public String solution(int [] x, int dist) {
        int[] ansArr = new int[x.length];
        for(int i = 0; i < ansArr.length; i++) {
            int speed = 0;
            int distLeft = dist;
            int time = 0;
            while(distLeft > 0) {
                System.out.println(x[i] + " " + distLeft + " " + speed);
                if(speed < x[i]) {
                    speed++;
                } else {
                    boolean[] increase = new boolean[2];
                    increase = this.canIncrease(x[i],distLeft,speed+1);
                    if(increase[0]) {
                        speed++;
                    } else if (!increase[1]){
                        speed--;
                    }
                }
                distLeft = distLeft - speed;
                time++;
                reps++;
            }
            ansArr[i] = time;
            reps++;
        }
        StringBuilder build = new StringBuilder();
        for (int i = 0; i < ansArr.length; i++) {
            build.append(ansArr[i] + "\n");
            reps++;
        }
        System.out.println(reps);
        return build.toString();
    }
    public boolean[] canIncrease(int x, int distLeft, int increaseInt){
        int decrease = increaseInt - x;
        int distNeeded = 0;
        int changeIncreaseInt = increaseInt;
        boolean[] retarr = new boolean[2];
        for(int i = 0; i < decrease; i++) {
            distNeeded = changeIncreaseInt + distNeeded;
            changeIncreaseInt --;
            reps++;
        }
        int dist2 = distNeeded - increaseInt;
        if(distLeft <= distNeeded) {
            retarr[0] = false;
        } else {
            retarr[0] = true;
        }
        if(distLeft <= dist2) {
            retarr[1] = false;
        } else {
            retarr[1] = true;
        }
        return retarr;
    }
    //Writes to output file
    public void fileWrite(String writeString) {
        try {
            File output = new File("race.out");
            PrintWriter printWriter = new PrintWriter(output);
            printWriter.write("");
            printWriter.flush();
            printWriter.close();
            FileWriter write = new FileWriter(output,true);
            write.append(writeString);
            write.flush();
            write.close();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public static void main(String[] args) {
        race solution = new race();
        solution.read();
    }
}
