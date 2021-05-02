import java.io.PrintWriter;
import java.io.File;
import java.io.FileWriter;
import java.util.Scanner;
import java.util.ListIterator;
import java.util.LinkedList;
import java.util.Collections;
class Solution {
    //reads from file
    public void read() {
        try {
            File input = new File("Input.txt");
            Scanner scanner = new Scanner(input);
            boolean start = true;
            int caseNum = 1;
            scanner.nextLine();
            while (scanner.hasNextLine()) {
                int n = Integer.parseInt(scanner.nextLine());
                String in = scanner.nextLine();
                String out = scanner.nextLine();
                this.fileWrite(this.solution(n,in,out,caseNum), start, caseNum);
                caseNum++;
                start = false;
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
    //The method that contains my solution
    public String solution(int n, String in, String out,int caseNum) {
        String[][] ans = new String[n][n];
        for(int i = 0; i < n; i++) {
            for(int j = 0; j < n; j++) {
                if(i == j) {
                    ans[i][j] = "Y";
                } else {
                    ans[i][j] = this.yesOrNo(i,j,in,out,caseNum);
                }
            }
        }
        StringBuilder retString = new StringBuilder();
        for (int i = 0; i < n; i++) {
            for(int j = 0; j < n; j++) {
                retString.append(ans[i][j]);
            }
            retString.append("\n");
        }
        return retString.toString();
    }
    public String yesOrNo(int i, int j,String in,String out,int caseNum) {
        boolean forward = j > i;
        int increment = 0;
        if(forward) {
            increment = 1;
        } else {
            increment = -1;
        }
        if(out.charAt(i) == 'Y' && in.charAt(i+increment) == 'Y') {
            i+=increment;
        } else {
            return "N";
        }
        if(i == j) {
            return "Y";
        } else {
           return yesOrNo(i,j,in,out,caseNum);
        }
    }
    //writes to output file
    public void fileWrite(String writeString,boolean start,int caseNum) {
        try {
            File output = new File("Output.txt");
            if (start) {
                PrintWriter printWriter = new PrintWriter(output);
                printWriter.write("");
                printWriter.flush();
                printWriter.close();
            }
            FileWriter write = new FileWriter(output,true);
            write.append("Case #" + caseNum + ": \n"+writeString + "\n");
            write.flush();
            write.close();
        } catch (Exception e) {
           e.printStackTrace();
        }
    }

    public static void main(String[] args) {
        Solution solution = new Solution();
        solution.read();
    }
}
