import java.util.*;
import java.io.File;
import java.io.IOException;
import java.io.PrintStream;
/*
ID: incredi2
LANG: JAVA
TASK: namenum
*/

class namenum {
    ArrayList<String> combinations;
    HashMap<Integer,String[]> strMap;
    HashMap<Character,Integer> intMap;
    ArrayList<String> names = new ArrayList<>();
    public void read() {
        File file = null;
        Scanner scan = null;
        try {
            file = new File("namenum.in");
            scan = new Scanner(file);
        } catch (Exception e) {
            e.printStackTrace();
        }
        String cowNum = scan.nextLine();
        File file2 = null;
        Scanner scan2 = null;
        try {
            file2 = new File("dict.txt");
            scan2 = new Scanner(file2);
        } catch (Exception e) {
            e.printStackTrace();
        }
        while(scan2.hasNext()) {
            names.add(scan2.nextLine());
        }
        this.solve(cowNum);
    }

    public void solve(String cowNum) {
        combinations = new ArrayList<>();
        strMap = new HashMap<>();
        strMap.put(new Integer(2), new String[] {"A","B","C"});
        strMap.put(new Integer(3), new String[] {"D","E","F"});
        strMap.put(new Integer(4), new String[] {"G","H","I"});
        strMap.put(new Integer(5), new String[] {"J","K","L"});
        strMap.put(new Integer(6), new String[] {"M","N","O"});
        strMap.put(new Integer(7), new String[] {"P","R","S"});
        strMap.put(new Integer(8), new String[] {"T","U","V"});
        strMap.put(new Integer(9), new String[] {"W","X","Y"});
        intMap = new HashMap<>();
        intMap.put('A', new Integer(2));
        intMap.put('B', new Integer(2));
        intMap.put('C', new Integer(2));
        intMap.put('D', new Integer(3));
        intMap.put('E', new Integer(3));
        intMap.put('F', new Integer(3));
        intMap.put('G', new Integer(4));
        intMap.put('H', new Integer(4));
        intMap.put('I', new Integer(4));
        intMap.put('J', new Integer(5));
        intMap.put('K', new Integer(5));
        intMap.put('L', new Integer(5));
        intMap.put('M', new Integer(6));
        intMap.put('N', new Integer(6));
        intMap.put('O', new Integer(6));
        intMap.put('P', new Integer(7));
        intMap.put('R', new Integer(7));
        intMap.put('S', new Integer(7));
        intMap.put('T', new Integer(8));
        intMap.put('U', new Integer(8));
        intMap.put('V', new Integer(8));
        intMap.put('W', new Integer(9));
        intMap.put('X', new Integer(9));
        intMap.put('Y', new Integer(9));


        ArrayList<String> subName = new ArrayList<>();
        for(int i = 0; i < names.size(); i++) {
            if(names.get(i).charAt(0) >= strMap.get(Integer.parseInt(String.valueOf(cowNum.charAt(0))))[0].charAt(0) && names.get(i).charAt(0) <= strMap.get(Integer.parseInt(String.valueOf(cowNum.charAt(0))))[2].charAt(0)) {
                if(names.get(i).length() == cowNum.length()) {
                    subName.add(names.get(i));
                }
            }
        }
        boolean inside = false;
        for(int i = 0; i < subName.size(); i++) {
            if(this.intify(subName.get(i)).equals(cowNum)) {
                System.out.println(subName.get(i));
                inside = true;
            }
        }
        if(!inside) {
            System.out.println("NONE");
        }

    }
    public String intify(String nameStr) {
        StringBuilder builder = new StringBuilder();
        for(int i = 0; i < nameStr.length(); i ++) {
            builder.append(intMap.get(nameStr.charAt(i)));
        }
        return builder.toString();
    }
    public static void main(String[] args) {
        try {
            File file = new File("namenum.out");
            PrintStream stream = new PrintStream(file);
            System.setOut(stream);
        } catch (Exception e) {
            e.printStackTrace();
        }
        namenum num = new namenum();
        num.read();
    }
}
