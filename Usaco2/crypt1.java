import java.util.*;
import java.io.File;
import java.io.IOException;
import java.io.PrintStream;
import java.math.BigInteger;
/*
ID: incredi2
LANG: JAVA
TASK: crypt1
*/

class crypt1 {
    ArrayList<String> combinationsthree;
    ArrayList<String> combinationstwo;
    HashSet<String> numMap;
    public void read() {
        File file = null;
        Scanner scan = null;
        try {
            file = new File("crypt1.in");
            scan = new Scanner(file);
        } catch (Exception e) {
            e.printStackTrace();
        }
        int length = Integer.parseInt(scan.nextLine());
        String[] numSet = scan.nextLine().split(" ");
        numMap = new HashSet<>();
        for(int i = 0; i < numSet.length; i++) {
            numMap.add(numSet[i]);
        }
        combinationsthree = new ArrayList<>();
        combinationstwo  = new ArrayList<>();
        this.solve(numSet);
    }
    public void solve(String[] numSet) {
        int returnNum = 0;
        this.recurse("",numSet,3,combinationsthree);
        this.recurse("",numSet,2,combinationstwo);
        for(int i = 0; i < combinationstwo.size(); i++) {
            for(int j = 0; j < combinationsthree.size(); j++) {
                int product = Integer.parseInt(combinationsthree.get(j)) * Integer.parseInt(combinationstwo.get(i));
                if(this.works(String.valueOf(product),numMap)) {
                    String[] subproducts = combinationstwo.get(i).split("");
                    String product1 = String.valueOf(Integer.parseInt(subproducts[0]) * Integer.parseInt(combinationsthree.get(j)));
                    String product2 = String.valueOf(Integer.parseInt(subproducts[1]) * Integer.parseInt(combinationsthree.get(j)));
                    if(this.works(product1,numMap) && product1.length() <= 3) {
                        if(this.works(product2,numMap) && product2.length() <= 3) {
                            returnNum++;
                        }
                    }
                }
            }
        }
        System.out.println(returnNum);
    }
    public void recurse(String partString, String [] set, int length, ArrayList<String> addList) {
        if(length == 0) {
            addList.add(partString);
            return;
        }
        for(int i = 0; i < set.length; i++) {
            this.recurse(partString + set[i],set,length - 1,addList);
        }
    }
    public boolean works(String num, HashSet<String> numSet) {
        char[] numArr = num.toCharArray();
        for(int i = 0; i < numArr.length; i++) {
            if(!numSet.contains(Character.toString(numArr[i]))) {
                return false;
            }
        }
        return true;
    }
    public static void main(String[] args) {
        try {
            File file = new File("crypt1.out");
            PrintStream stream = new PrintStream(file);
            System.setOut(stream);
        } catch (Exception e) {
            e.printStackTrace();
        }
        crypt1 crypt = new crypt1();
        crypt.read();
    }
}