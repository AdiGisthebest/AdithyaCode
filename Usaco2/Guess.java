import java.io.File;
import java.io.PrintStream;
import java.util.*;

public class Guess {
    HashMap<String, HashSet<Integer>> map;
    HashMap<String, Integer> attributes;
    HashSet<Integer> attrNum;
    public void read() {
        File file1 = new File("guess.in");
        Scanner scanner = null;
        try {
            scanner = new Scanner(file1);
        } catch (Exception e) {
            e.printStackTrace();
        }
        map = new HashMap<>();
        attributes = new HashMap<>();
        attrNum = new HashSet<>();
        int count = 0;
        int length = Integer.parseInt(scanner.nextLine());
        for(int i = 0; i < length; i++) {
            String[] arr = scanner.nextLine().split(" ");
            String animal = arr[0];
            int attrLength = Integer.parseInt(arr[1]);
            HashSet<Integer> animalAttr = new HashSet<>();
            for(int j = 0; j < attrLength; j++) {
                if(attributes.containsKey(arr[j+2])) {
                    animalAttr.add(attributes.get(arr[j+2]));
                } else {
                    attrNum.add(count);
                    attributes.put(arr[j+2],count);
                    animalAttr.add(count);
                    count++;
                }
            }
            map.put(animal,animalAttr);
        }
        System.out.println(this.recurse(0, new HashSet<String>(map.keySet()),new HashSet<Integer>()));
    }
    public int recurse(int level,HashSet<String> animals,HashSet<Integer> prevAttr){
        if(animals.size() == 1) {
            return level;
        } else {
            HashSet<Integer> attrSet = new HashSet<>();
            Iterator<String> iterator = animals.iterator();
            for(int i = 0; i < animals.size(); i++) {
                String animal = iterator.next();
                Iterator<Integer> attrIter = map.get(animal).iterator();
                for(int j = 0; j < map.get(animal).size(); j++) {
                    int attr = attrIter.next();
                    if(!attrSet.contains(attr) && !prevAttr.contains(attr)) {
                        attrSet.add(attr);
                    }
                }
            }
            Iterator<Integer> attrIter = attrSet.iterator();
            int maxNum = 0;
            while(attrIter.hasNext()) {
                int num = attrIter.next();
                HashSet<Integer> addPrevAttr = (HashSet<Integer>) prevAttr.clone();
                addPrevAttr.add(num);
                int ans = this.recurse(level+1,this.getAnimalsWithAttr(num, animals),addPrevAttr);
                if(ans > maxNum) {
                    maxNum = ans;
                }
            }
            return maxNum;
        }
    }
    public HashSet<String> getAnimalsWithAttr(int attr,HashSet<String> animals) {
        HashSet<String> set = new HashSet<>();
        Iterator<String> iter = animals.iterator();
        while(iter.hasNext()) {
            String animalName = iter.next();
            if(map.get(animalName).contains(attr)) {
                set.add(animalName);
            }
        }
        return set;
    }

    public static void main(String[] args) {
        try {
            File file = new File("guess.out");
            PrintStream stream = new PrintStream(file);
            System.setOut(stream);
        } catch (Exception e) {
            e.printStackTrace();
        }
        GuessWrong guess = new GuessWrong();
        guess.read();
    }
}
