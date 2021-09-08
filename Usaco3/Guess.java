import java.io.File;
import java.io.PrintStream;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Scanner;

public class Guess {
    public void read() {
        try {
            //Get Data in wanted format
            int ans = 0;
            Scanner scan = new Scanner(new File("guess.in"));
            HashMap<String, ArrayList<String>> featureMap = new HashMap<>();
            int length = Integer.parseInt(scan.nextLine());
            ArrayList<String> animalArr = new ArrayList<>();
            int maxCount = 0;
            for(int i = 0; i < length; i++) {
                String[] arr = scan.nextLine().split(" ");
                String animal = arr[0];
                animalArr.add(animal);
                int featureLength = Integer.parseInt(arr[1]);
                ArrayList<String> featureList = new ArrayList<>();
                for(int k = 0; k < featureLength; k++) {
                    featureList.add(arr[2+k]);
                }
                featureMap.put(animal, featureList);
            }
            //Do Computation
            for(int i = 0; i < animalArr.size(); i++) {
                for(int j = i+1; j < animalArr.size(); j++) {
                    ArrayList<String> featureList1 = featureMap.get(animalArr.get(i));
                    ArrayList<String> featureList2 = featureMap.get(animalArr.get(j));
                    int count = 0;
                    for(int k = 0; k < featureList2.size(); k++) {
                        if(featureList1.contains(featureList2.get(k))) {
                            count++;
                        }
                    }
                    if(count > maxCount) {
                        maxCount = count;
                    }
                }
            }
            System.out.println(maxCount + 1);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public static void main(String[] args) {
        try {
            File file = new File("guess.out");
            PrintStream stream = new PrintStream(file);
            System.setOut(stream);
        } catch (Exception e) {
            e.printStackTrace();
        }
        Guess guess = new Guess();
        guess.read();
    }
}
