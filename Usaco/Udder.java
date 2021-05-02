import java.util.*;
class Udder {
    static void read () {
        Scanner scan = new Scanner(System.in);
        Udder.solve(scan.nextLine(),scan.nextLine());
    }
    static void solve(String cowphabet, String letters) {
        HashMap<String, Integer> letterMap = new HashMap<>();
        Integer[] letterArr = new Integer[letters.length()];
        int currNum = -2;
        int ans = 1;
        for(int i = 0; i < cowphabet.length(); i++) {
            letterMap.put(String.valueOf(cowphabet.charAt(i)),i);
        }
        for(int i = 0; i < letters.length(); i++) {
            letterArr[i] = letterMap.get(String.valueOf(letters.charAt(i)));
        }
        for(int i = 0; i < letters.length(); i++) {
            if(letterArr[i] > currNum) {
                currNum = letterArr[i];
            } else {
                ans++;
                currNum = letterArr[i];
            }
        }
        System.out.println(ans);
    }

    public static void main(String[] args) {
        Udder.read();
    }
}