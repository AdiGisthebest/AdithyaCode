import java.io.File;
import java.io.PrintStream;
import java.security.KeyPair;
import java.sql.SQLIntegrityConstraintViolationException;
import java.util.HashSet;
import java.util.Objects;
import java.util.Scanner;

public class Gymnastics {
    public void read() {
        try {
            Scanner scan = new Scanner(new File("gymnastics.in"));
            String[] tempArr = scan.nextLine().split(" ");
            int length = Integer.parseInt(tempArr[0]);
            int arrLength = Integer.parseInt(tempArr[1]);
            HashSet<pair> set = new HashSet<>();
            HashSet<pair> containsSet = new HashSet<>();
            for(int i = 0; i < length; i++) {
                tempArr = scan.nextLine().split(" ");
                for(int k = 0; k < arrLength; k++) {
                    for(int j = k+1; j < arrLength; j++) {
                        if(i == 0) {
                            pair pair = new pair();
                            pair.first = Integer.parseInt(tempArr[k]);
                            pair.last = Integer.parseInt(tempArr[j]);
                            set.add(pair);
                            //System.out.println(pair);
                        } else {
                            pair pair = new pair();
                            pair.first = Integer.parseInt(tempArr[k]);
                            pair.last = Integer.parseInt(tempArr[j]);
                            //System.out.println(pair + " from else");
                            if(containsSet.contains(pair)) {
                                //System.out.println("in");
                                set.add(pair);
                            }
                        }
                    }
                }
                containsSet = set;
                set = new HashSet<>();
            }
            System.out.println(containsSet.size());
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public static void main(String[] args) {
        try {
            File file = new File("gymnastics.out");
            PrintStream stream = new PrintStream(file);
            System.setOut(stream);
        } catch (Exception e) {
            e.printStackTrace();
        }
        Gymnastics gym = new Gymnastics();
        gym.read();
    }
}
class pair {
    int first;
    int last;

    @Override
    public String toString() {
        return "pair{" +
                "first=" + first +
                ", last=" + last +
                '}';
    }

    //@Override
    /*public boolean equals(Object o) {
        pair pair2 = (pair) o;
        System.out.println("called");
        if(this.first == pair2.first && this.last == pair2.last) {
            return true;
        } else if (this.last == pair2.first && this.first == pair2.last) {
            return true;
        }
        return false;
    }*/

    @Override
    public boolean equals(Object o) {
        pair pair = (pair) o;
        return first == pair.first && last == pair.last;
    }

    @Override
    public int hashCode() {
        return Objects.hash(first, last);
    }
}
