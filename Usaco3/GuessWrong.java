import java.io.File;
import java.io.PrintStream;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Scanner;
//Wrong algorithm. Try to find mathematical properties before coming up with an algorithm.
public class GuessWrong {
    public void read() {
        try {
            //Get Data in wanted format
            int ans = 0;
            Scanner scan = new Scanner(new File("guess.in"));
            HashMap<String, ArrayList<String>> featureMap = new HashMap<>();
            int length = Integer.parseInt(scan.nextLine());
            ArrayList<String> animalArr = new ArrayList<>();
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

            //Do computation
            while(animalArr.size() > 1) {
                HashMap<String,Integer> currentFeatures = new HashMap<>();
                for(int i = 0; i < animalArr.size(); i++) {
                    ArrayList<String> features = featureMap.get(animalArr.get(i));
                    for(int j = 0; j < features.size(); j++) {
                        if(currentFeatures.containsKey(features.get(j))) {
                            int count = currentFeatures.get(features.get(j));
                            count++;
                            currentFeatures.put(features.get(j), count);
                        } else {
                            currentFeatures.put(features.get(j), 1);
                        }
                    }
                }
                String[] valueArr = currentFeatures.keySet().toArray(new String[0]);
                int maxVal = 0;
                String maxFeature = "";
                for(int i = 0; i < valueArr.length; i++) {
                    if(currentFeatures.get(valueArr[i]) > maxVal) {
                        maxVal = currentFeatures.get(valueArr[i]);
                        maxFeature = valueArr[i];
                    }
                }
                for(int i = 0; i < animalArr.size(); i++) {
                    //System.out.println(featureMap.get(animalArr.get(i)) + " " + animalArr.get(i));
                    if(!featureMap.get(animalArr.get(i)).contains(maxFeature)) {
                        animalArr.remove(i);
                        i--;
                    } else {
                        featureMap.get(animalArr.get(i)).remove(maxFeature);
                    }
                }
                ans++;
                //System.out.println(animalArr);
            }
            System.out.println(ans);
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
        GuessWrong guess = new GuessWrong();
        guess.read();
    }
}
