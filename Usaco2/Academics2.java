import java.util.*;
class Academics2 {
    HashMap<String,Integer> alphabetMap;
    public void read() {
        Scanner scan = new Scanner(System.in);
        String [] arr = scan.nextLine().split(" ");
        int k = Integer.parseInt(arr[0]);
        int cows = Integer.parseInt(arr[1]);
        String[] names = scan.nextLine().toLowerCase().split(" ");
        alphabetMap = new HashMap<>();
        for(int i = 0; i < 26; i++) {
            alphabetMap.put(Character.toString((char) i + 97), i);
        }
        HashMap<String,Integer> map = new HashMap<>();
        for(int i = 0; i < names.length; i++) {
            map.put(names[i],0);
        }
        int addval = 0;
        for(int i = 0; i < k; i ++) {
           String[] paper = scan.nextLine().toLowerCase().split(" ");
           for(int j = 0; j < paper.length - 1; j++) {
               if(this.checkAlphabetical(paper[j],paper[j+1]) ) {
                   map.put(paper[j], (map.get(paper[j]) + addval));
               } else {
                   map.put(paper[j], (map.get(paper[j]) + addval));
                   addval++;
               }
           }
            map.put(paper[paper.length-1], (map.get(paper[paper.length-1]) + addval));
        }

        for(int i = 0; i < names.length; i ++) {
            for(int j = 0; j < names.length; j++) {
                if(i == j) {
                    System.out.print("B");
                } else {
                    if(map.get(names[i]) > map.get(names[j])) {
                        System.out.print(1);
                    } else if(map.get(names[i]) < map.get(names[j])) {
                        System.out.print(0);
                    } else {
                        System.out.print("?");
                    }
                }
            }
            System.out.println();
        }
    }
    public boolean checkAlphabetical(String word1, String word2) {
        String[] word1arr = word1.split("");
        String[] word2arr = word2.split("");
        for(int i = 0; i < 10; i++) {
            if(alphabetMap.get(word1arr[i]) < alphabetMap.get(word2arr[i])) {
                return true;
            } else if(alphabetMap.get(word1arr[i]) > alphabetMap.get(word2arr[i])) {
                return false;
            }
            if(i == word1.length() - 1 || i-1 == word2.length() - 1) {
                return true;
            }
        }
        return true;
    }

    public static void main(String[] args) {
        Academics2 academics2 = new Academics2();
        academics2.read();
    }
}