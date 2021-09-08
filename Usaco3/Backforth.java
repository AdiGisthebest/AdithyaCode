

import javax.print.DocFlavor;
import java.io.File;
import java.util.*;

public class Backforth {
    HashSet<Integer> ansSet = new HashSet<>();
    public void read() {
        Scanner scanner = null;
        File file = new File("backforth.in");
        try {
            scanner = new Scanner(file);
            String[] strBuckets1 = scanner.nextLine().split(" ");
            String[] strBuckets2 = scanner.nextLine().split(" ");
            ArrayList<Integer> set = new ArrayList<>();
            ArrayList<Integer> set2 = new ArrayList<>();
            for(int i = 0; i < 10; i++) {
                set.add(Integer.parseInt(strBuckets1[i]));
                set2.add(Integer.parseInt(strBuckets2[i]));
            }
            this.recurse(set,set2,0,1000,1000);
            System.out.println(ansSet.size());
        } catch(Exception e){
           e.printStackTrace();
        }
    }
    public void recurse(ArrayList<Integer> list1, ArrayList<Integer> list2, int length, int milk1, int milk2) {
        if(length >= 3) {
            ansSet.add(milk1);
            return;
        } else {
            if(length%2 == 0) {
                ListIterator<Integer> iterator = list1.listIterator();
                while(iterator.hasNext()) {
                    int bucket = iterator.next();
                    ArrayList<Integer> list1clone  = (ArrayList<Integer>) list1.clone();
                    ArrayList<Integer> list2clone = (ArrayList<Integer>) list2.clone();
                    list1clone.remove(Integer.valueOf(bucket));
                    list2clone.add(bucket);
                    this.recurse(list1clone,list2clone,length+1,milk1-bucket, milk2+bucket);
                }
            } else {
                ListIterator<Integer> iterator = list2.listIterator();
                while(iterator.hasNext()) {
                    int bucket = iterator.next();
                    ArrayList<Integer> list1clone  = (ArrayList<Integer>) list1.clone();
                    ArrayList<Integer> list2clone = (ArrayList<Integer>) list2.clone();
                    list1clone.remove(Integer.valueOf(bucket));
                    list2clone.add(bucket);
                    this.recurse(list1clone,list2clone,length+1,milk1+bucket, milk2-bucket);
                }
            }
        }
    }

    public static void main(String[] args) {
      Backforth backforth = new Backforth();
      backforth.read();
    }
}
