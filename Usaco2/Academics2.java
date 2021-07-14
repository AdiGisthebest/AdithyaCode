import java.util.*;
class Academics2 {
    //Map that stores each letter of the alphabet, and their positions, used for determining if two names are in alphabetical order or not
    HashMap<String,Integer> alphabetMap;
    public void read() {
        //This section takes, and parses input into the different names of each professor.
        Scanner scan = new Scanner(System.in);
        String [] arr = scan.nextLine().split(" ");
        int k = Integer.parseInt(arr[0]);
        int cows = Integer.parseInt(arr[1]);
        String[] names = scan.nextLine().toLowerCase().split(" ");
        alphabetMap = new HashMap<>();
        //This part puts each letter into the alphabet hashmap
        for(int i = 0; i < 26; i++) {
            alphabetMap.put(Character.toString((char) i + 97), i);
        }
        //This hashmap stores the nameof the professor, and the number value associated with it
        HashMap<String,Integer> map = new HashMap<>();
        for(int i = 0; i < names.length; i++) {
            map.put(names[i],0);
        }
        //This section checks if two words are in alphabetical order, and does the adding we described in our algorithm
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
        //This section checks the seniority and formats the output, then prints it.
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
    //Thsi function takes two names, and return true if they are in alphabetical order, and false if they are not.
    public boolean checkAlphabetical(String word1, String word2) {
        String[] word1arr = word1.split("");
        String[] word2arr = word2.split("");
        int length;
        if(word1arr.length-1 < word2arr.length-1) {
            length = word1arr.length-1;
        } else {
            length = word2arr.length-1;
        }
        for(int i = 0; i < length; i++) {
            if(alphabetMap.get(word1arr[i]) < alphabetMap.get(word2arr[i])) {
                return true;
            } else if(alphabetMap.get(word1arr[i]) > alphabetMap.get(word2arr[i])) {
                return false;
            }
        }
        return true;
    }

    public static void main(String[] args) {
        Academics2 academics2 = new Academics2();
        academics2.read();
    }
}
