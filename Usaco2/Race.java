import java.util.*;
import java.io.File;
import java.io.IOException;
import java.io.PrintStream;
class Race  {
    public void read() {
        File file = null;
        Scanner scan = null;
        try {
            file = new File("race.in");
            scan = new Scanner(file);
        } catch (Exception e) {
            e.printStackTrace();
        }
        String [] arr = scan.nextLine().split(" ");
        int k = Integer.parseInt(arr[0]);
        while(scan.hasNext()) {
            this.solve(Integer.parseInt(scan.nextLine()),k);
        }
    }
    public int solve(int x, int k) {
        int speed = 0;
        int dist = 0;
        int seconds = 0;
        System.out.println(x);
        while(true) {
            System.out.println(dist + " " + speed + " " + seconds + " "+x);
            if(dist >= k) {
                return seconds;
            }
            if(speed > x) {
                dist = dist + (speed * 2);
                seconds += 2;
            } else {
                dist = dist + speed;
                seconds++;
            }
            speed++;
        }
    }
    public static void main(String[] args) {
        try {
            File file = new File("race.out");
            PrintStream stream = new PrintStream(file);
            System.setOut(stream);
        } catch (Exception e) {
            e.printStackTrace();
        }
        Race race = new Race();
        race.read();
    }
}