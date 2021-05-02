import java.util.*;
import java.io.File;
import java.io.IOException;
import java.io.PrintStream;
class Photo {
    public void read() {
        File file = null;
        Scanner scan = null;
        try {
            file = new File("photo.in");
            scan = new Scanner(file);
        } catch(Exception e) {
            e.printStackTrace();
        }
        int length = Integer.parseInt(scan.nextLine());
        HashMap<Integer,Integer> map = new HashMap<>();
        String[] strArr = scan.nextLine().split(" ");
        int[] arr = new int[length - 1];
        for(int i = 0; i < length-1; i ++) {
            map.put(i+1,0);
            arr[i] = Integer.parseInt(strArr[i]);
        }
        map.put(length,0);
        int [] ansArr = new int[length];
        for(int i = 1; i < arr[0]; i++) {
            int num = i;
            boolean completeBool = true;
           for(int j = 0; j < length ; j++) {
               if(map.containsKey(num)) {
                   if(map.get(num) == i) {
                       completeBool = false;
                       ansArr = new int[length];
                       break;
                   } else {
                       map.put(num,i);
                       ansArr[j] = num;
                   }
               }
               if(j <= length -2) {
                   num = arr[j] - num;
               }
           }
           if(completeBool) {
               for(int j = 0; j < length - 1; j ++) {
                   System.out.print(ansArr[j] + " ");
               }
               System.out.print(ansArr[length-1]);
               return;
           }
        }
    }
    public static void main(String[] args) {
        try {
            File file = new File("photo.out");
            PrintStream stream = new PrintStream(file);
            System.setOut(stream);
        } catch (Exception e) {
            e.printStackTrace();
        }
        Photo photo = new Photo();
        photo.read();
    }
}