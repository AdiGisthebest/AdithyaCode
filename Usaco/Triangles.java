import java.io.File;
import java.io.IOException;
import java.io.PrintStream;
import java.util.*;
class Triangles {
    public void read() {
        File file = null;
        Scanner scan = null;
        try {
            file = new File("triangles.in");
            scan = new Scanner(file);
        } catch(Exception e) {
            e.printStackTrace();
        }
        int len = Integer.parseInt(scan.nextLine());
        int [][] coords = new int [len][2];
        HashSet<String> map = new HashSet<>();
        int maxArea = 0;
        int k = 0;
        while(scan.hasNext()) {
            String nextStr = scan.nextLine();
            map.add(nextStr);
            String [] next = nextStr.split(" ");
            coords[k][0] = Integer.parseInt(next[0]);
            coords[k][1] = Integer.parseInt(next[1]);
            k++;
        }
        for(int i = 0; i < len; i++) {
            for(int j = 0; j < len; j ++) {
                String check = coords[i][0] + " " + coords[j][1];
                if(map.contains(check)) {
                    int xLen = Math.abs(coords[i][0] - coords[j][0]);
                    int yLen = Math.abs(coords[i][1] - coords[j][1]);
                    int tempMax = xLen * yLen;
                    if(maxArea < tempMax) {
                        maxArea = tempMax;
                    }
                    tempMax = 0;
                }
            }
        }
        System.out.println(maxArea);
    }
    public static void main(String[] args) {
        try {
            File file = new File("triangles.out");
            PrintStream stream = new PrintStream(file);
            System.setOut(stream);
        } catch (Exception e) {
            e.printStackTrace();
        }
        Triangles triangle = new Triangles();
        triangle.read();
    }
}