import java.util.*;
import java.io.File;
import java.io.IOException;
import java.io.PrintStream;
import java.math.BigInteger;
class tttt {
    public void read() {
        File file = null;
        Scanner scan = null;
        try {
            file = new File("tttt.in");
            scan = new Scanner(file);
        } catch (Exception e) {
            e.printStackTrace();
        }
        char[][] board = new char[3][3];
        int iter = 0;
        while(scan.hasNext()) {
            char[] strArr = scan.nextLine().toCharArray();
            board[iter] = strArr;
            iter++;
        }
        this.solve(board);
    }
    public void solve(char [][] board) {
        int count = 0;
        int cowcount = 0;
        for(int i = 0; i < board.length; i++){
            if(board[i][0] != board[i][1] && board[i][1] != board[i][2] && board[i][0] != board[i][2]) {
                count--;
            }
            if(board[i][0] == board[i][1] && board[i][1] == board[i][2] && board[i][0] == board[i][2]) {
                //System.out.println(board[i][0] +" "+ board[i][1] +" "+ board[i][2]);
                cowcount++;
                count--;
            }
            count++;
        }
        for(int i = 0; i < board.length; i++){
            if(board[0][i] != board[1][i] && board[1][i] != board[2][i] && board[0][i] != board[2][i]) {
                count--;
            }
            if(board[0][i] == board[1][i] && board[1][i] == board[2][i] && board[0][i] == board[2][i]) {
                //System.out.println(board[0][i] +" "+ board[1][i] +" "+ board[2][i]);
                cowcount++;
            }
            count++;
        }
        if(board[0][0] != board[1][1] && board[1][1] != board[2][2] && board[0][0] != board[2][2]) {
            count--;
        }
        if(board[0][0] == board[1][1] && board[1][1] == board[2][2] && board[0][0] == board[2][2]) {
            //System.out.println(board[0][0] +" "+ board[1][1] +" "+ board[2][2]);
            cowcount++;
            count--;
        }
        count++;
        if(board[0][2] != board[1][1] && board[1][1] != board[2][0] && board[0][2] != board[2][0]) {
            count--;
        }
        if(board[0][2] == board[1][1] && board[1][1] == board[2][0] && board[0][2] == board[2][0]) {
            //System.out.println(board[2][0] +" "+ board[1][1] +" "+ board[0][2]);
            cowcount++;
        }
        count++;
        System.out.println(cowcount);
        System.out.println(count);
    }
    public static void main(String[] args) {
        try {
            File file = new File("tttt.out");
            PrintStream stream = new PrintStream(file);
            System.setOut(stream);
        } catch (Exception e) {
            e.printStackTrace();
        }
        tttt t = new tttt();
        t.read();
    }
}