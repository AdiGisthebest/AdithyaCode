import java.io.File;
import java.io.PrintStream;
import java.util.HashSet;
import java.util.Scanner;

public class Cowcross {
    public void read() {
        try {
            Scanner scan = new Scanner(new File("circlecross.in"));
            String cross = scan.nextLine();
            char[] arr = cross.toCharArray();
            char[] alphabet = {'A','B','C','D','E','F','G','H','I','J','K','L','M','N','O','P','Q','R','S','T','U','V','W','X','Y','Z'};
            int count = 0;
            int[] middle = new int[26];
            for(int i = 0; i < alphabet.length; i++) {
                for(int j = 0; j < arr.length; j++) {
                    if(arr[j] == alphabet[i]) {
                        //cycle through arr
                        for(int k = j + 1; k < arr.length; k++) {
                            if(arr[k] == arr[j]) {
                                break;
                            }
                            for(int x = 0; x < alphabet.length; x++) {
                                if(arr[k] == alphabet[x]) {
                                    middle[x]++;
                                }
                            }
                        }
                        //Check middle
                        for(int k = 0; k < middle.length; k++) {
                            //System.out.print(middle[k]);
                            if(middle[k] == 1) {
                                count++;
                            }
                        }
                        //System.out.println();
                        middle = new int[26];
                        break;
                    }
                }
            }
            System.out.println(count/2);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public static void main(String[] args) {
        try {
            File file = new File("circlecross.out");
            PrintStream stream = new PrintStream(file);
            System.setOut(stream);
        } catch (Exception e) {
            e.printStackTrace();
        }
        Cowcross cowcross = new Cowcross();
        cowcross.read();
    }
}
