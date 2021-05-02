import java.io.File;
import java.io.IOException;
import java.io.PrintStream;
import java.util.*;
class Bucket {
    public void read() {
        File file = null;
        Scanner scan = null;
        try {
            file = new File("buckets.in");
            scan = new Scanner(file);
        } catch(Exception e) {
            e.printStackTrace();
        }
        int k = 0;
        int [] barnpos = null;
        int [] lakepos = null;
        int [] rockpos = null;
        while(scan.hasNext()) {
            String line = scan.nextLine();
            char [] arr = line.toCharArray();
            for(int i = 0; i < 10; i++) {
                switch(arr[i]) {
                    case 'L': lakepos = new int[2];
                    lakepos[0] = i;
                    lakepos[1] = 10-k;
                    break;
                    case 'B': barnpos = new int[2];
                    barnpos[0] = i;
                    barnpos[1] = 10-k;
                    break;
                    case 'R': rockpos = new int[2];
                    rockpos[0] = i;
                    rockpos[1] = 10-k;
                }
                if(lakepos != null && barnpos != null && rockpos != null) {
                    break;
                }
            }
            if(lakepos != null && barnpos != null && rockpos != null) {
                break;
            }
            k++;
        }
        int addTwo = 0;
        if(lakepos[0] == rockpos[0] && rockpos[0] == barnpos[0] && ) {
            addTwo = 2;
        } else if (lakepos[1] == rockpos[1] && rockpos[1] == barnpos[1]) {
            addTwo = 2;
        }
        if(barnpos[0] - 1  == rockpos) {

        }
        int xDiff = Math.abs(lakepos[0] - barnpos[0]) - 1;
        int yDiff = Math.abs(lakepos[1] - barnpos[1]) - 1;
        int ans = xDiff + yDiff + 1 + addTwo;
        System.out.println(ans);
    }
    public static void main(String[] args) {
        try {
            File file = new File("buckets.out");
            PrintStream stream = new PrintStream(file);
            System.setOut(stream);
        } catch (Exception e) {
            e.printStackTrace();
        }
        Bucket bucket = new Bucket();
        bucket.read();
    }
}