import java.io.File;
import java.io.PrintStream;
import java.util.Arrays;
import java.util.Scanner;

public class BzGenomics {
    public void read() {
        try {
            Scanner scan = new Scanner(new File("cownomics.in"));
            String[] tempArr = scan.nextLine().split(" ");
            int numCows = Integer.parseInt(tempArr[0]);
            int length = Integer.parseInt(tempArr[1]);
            char[][] spotty = new char[length][numCows];
            char[][] normal = new char[length][numCows];
            char[] genes = {'A','C','G','T'};
            int ans = 0;
            for(int i = 0; i < numCows; i++) {
                char[] arr = scan.nextLine().toCharArray();
                for(int j = 0; j < length; j++) {
                    spotty[j][i] = arr[j];
                }
            }
            for(int i = 0; i < numCows; i++) {
                char[] arr = scan.nextLine().toCharArray();
                for(int j = 0; j < length; j++) {
                    normal[j][i] = arr[j];
                }
            }
            for(int i = 0; i < length; i++) {
                int count = 0;
                for(int k = 0; k < genes.length; k++) {
                    boolean found = false;
                    for(int j = 0; j < numCows; j++) {
                        if(spotty[i][j] == genes[k]) {
                            found = true;
                            break;
                        }
                    }
                    boolean alsoFound = false;
                    if(found) {
                        for(int j = 0; j < numCows; j++) {
                            if(normal[i][j] == genes[k]) {
                                alsoFound = true;
                                break;
                            }
                        }
                    }
                    //System.out.println(genes[k]+ " " + found + " " + alsoFound);
                    if(found) {
                        if(!alsoFound) {
                            count++;
                        } else {
                            break;
                        }
                    } else {
                        count ++;
                    }
                }
                if(count == 4) {
                    ans++;
                }
            }
            System.out.println(ans);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public static void main(String[] args) {
        try {
            File file = new File("cownomics.out");
            PrintStream stream = new PrintStream(file);
            System.setOut(stream);
        } catch (Exception e) {
            e.printStackTrace();
        }
        BzGenomics gene = new BzGenomics();
        gene.read();
    }
}
