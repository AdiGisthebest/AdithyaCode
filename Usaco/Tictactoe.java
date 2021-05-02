import java.io.File;
import java.io.IOException;
import java.io.PrintStream;
import java.util.*;
class Tictactoe {
    public void read() {
        File file = null;
        Scanner scan = null;
        int oneCount = 0;
        int twoCount = 0;
        try {
            file = new File("tttt.in");
            scan = new Scanner(file);
        } catch(Exception e) {
            e.printStackTrace();
        }
        String [][] board = new String[3][3];
        int k = 0;
        while(scan.hasNext()) {
            String newline = scan.nextLine();
            String[] arr = newline.split("");
            for(int i = 0; i < 3; i ++) {
                board[k][i] = arr[i];
            }
            k++;
        }

        for(int i = 0; i < 3; i ++) {
            HashSet<String> set = new HashSet<>();
            int diffChar = 0;
            for(int j = 0; j < 3; j++) {
                if(!set.contains(board[i][j])) {
                    set.add(board[i][j]);
                   diffChar++;
                }
            }
            if(diffChar == 1) {
                oneCount++;
            } else if (diffChar == 2) {
                twoCount++;
            }
        }
        for(int i = 0; i < 3; i++) {
            HashSet<String> set = new HashSet<>();
            int diffChar = 0;
            for(int j = 0; j < 3; j++) {
                if(!set.contains(board[j][i])) {
                    set.add(board[j][i]);
                    diffChar++;

                }
            }
            if(diffChar == 1) {
                oneCount++;
            } else if (diffChar == 2) {
                twoCount++;
            }
        }
        HashSet<String> set = new HashSet<>();
        int diffChar = 0;
        for(int i = 0; i < 3; i ++) {
            if(!set.contains(board[i][i])) {
                set.add(board[i][i]);
                diffChar++;
            }
            if (i == 2) {
                if(diffChar == 1) {
                    oneCount++;
                } else if (diffChar == 2) {
                    twoCount++;
                }
            }
        }
        set = new HashSet<>();
        diffChar = 0;
        for(int i = 0; i < 3; i ++) {
            if(!set.contains(board[i][2-i])) {
                set.add(board[i][2-i]);
                diffChar++;
            }
            if (i == 2) {
                if(diffChar == 1) {
                    oneCount++;
                } else if (diffChar == 2) {
                    twoCount++;
                }
            }
        }
        System.out.println(oneCount);
        System.out.println(twoCount);
    }
    public static void main(String[] args) {
        try {
            File file = new File("tttt.out");
            PrintStream stream = new PrintStream(file);
            System.setOut(stream);
        } catch (Exception e) {
            e.printStackTrace();
        }
        Tictactoe tictactoe = new Tictactoe();
        tictactoe.read();
    }
}