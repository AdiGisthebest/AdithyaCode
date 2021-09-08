


import java.io.File;
import java.io.PrintStream;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.Scanner;

public class paint {
    public int read() {
        Scanner scanner = null;
        File file = new File("paint.in");
        try {
            scanner = new Scanner(file);
            String[] arr = scanner.nextLine().split(" ");
            String[] arr2 = scanner.nextLine().split(" ");
            int fjStart = Integer.parseInt(arr[0]);
            int fjEnd = Integer.parseInt(arr[1]);
            int bStart = Integer.parseInt(arr2[0]);
            int bEnd = Integer.parseInt(arr2[1]);
            if(bStart > fjStart) {
                if(fjEnd > bStart) {
                    if(fjEnd < bEnd) {
                        return bEnd-fjStart;
                    } else {
                        return fjEnd - fjStart;
                    }
                } else {
                    return (bEnd-bStart) + (fjEnd-fjStart);
                }
            } else {
                if(bEnd > fjStart) {
                    if(bEnd < fjEnd) {
                        return fjEnd-bStart;
                    } else {
                        return bEnd - bStart;
                    }
                } else {
                    return (bEnd-bStart) + (fjEnd-fjStart);
                }
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return -1;
    }


    public static void main(String[] args) {
        try {
            File file = new File("paint.out");
            PrintStream stream = new PrintStream(file);
            System.setOut(stream);
        } catch (Exception e) {
            e.printStackTrace();
        }
        paint cow = new paint();
        System.out.println(cow.read());
    }
}
