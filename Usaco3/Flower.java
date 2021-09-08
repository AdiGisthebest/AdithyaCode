import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Scanner;

public class Flower {
    public void read() {
        Scanner scanner = new Scanner(System.in);
        int length = Integer.parseInt(scanner.nextLine());
        int[] flowers = new int[length];
        int ansNum = 0;
        ArrayList<Double> arrSet;
        for(int i = 0; i < length; i++) {
            flowers[i] = scanner.nextInt();
        }
        for(int i = 0; i < length; i++) {
            for(int j = i; j < length; j++) {
                arrSet = new ArrayList<>();
                int avg = 0;
                for(int k = i; k <= j; k++) {
                    arrSet.add((double)flowers[k]);
                    //System.out.print(flowers[k]);
                    avg = avg + flowers[k];
                }
                //System.out.println();
                if(arrSet.contains(((double)avg/((j-i)+1)))) {
                    //System.out.println(((double)avg/((j-i)+1)));
                    ansNum++;
                }
            }
        }
        System.out.println(ansNum);
    }
    public static void main(String[] args) {
        Flower flower = new Flower();
        flower.read();
    }
}
