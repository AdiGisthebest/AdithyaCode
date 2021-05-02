import java.util.*;
import java.io.*;
/*
ID: incredi2
LANG: JAVA
TASK: friday
*/
class friday {
    public void read() {
        try {
            Scanner scan = new Scanner(new File("friday.in"));
            int num = Integer.parseInt(scan.nextLine());
            this.fileWrite(this.solve(num));

        } catch (Exception e) {
            e.printStackTrace();
        }
    }
    public String solve(int num) {
        int startDay = 1;
        int[] dayArr = new int [7];
        for(int i = 0; i < num; i++) {
            int yearNum = 1900 + i;
            for(int j = 0; j < 12; j++) {
                int monthNum = j;
                int days = this.monthDays(monthNum, yearNum);
                dayArr[(startDay + 13) % 7]++;
                startDay = (startDay + (days-28))%7;
            }
            System.out.println(startDay);
        }
        String ans = "";
        for(int i = 0; i < 6; i++) {
            ans = ans + dayArr[i] + " ";
        }
        ans = ans + dayArr[6] + "\n";
        return ans;
    }
    public int monthDays(int monthNum, int yearNum) {
        switch(monthNum) {
            case 8 : return 30;
            case 3 : return 30;
            case 5 : return 30;
            case 10 : return 30;
            case 1 : if(this.leapOrNot(yearNum)) {
                return 29;
            } else {
                return 28;
            }
            default: return 31;
        }
    }
    public boolean leapOrNot(int year) {
        boolean centBool = true;
        if(year%100 == 0) {
            centBool = false;
        }
        if(year%400 == 0) {
            centBool = true;
        }
        if(year%4 == 0 && centBool) {
            return true;
        } else {
            return false;
        }
    }
    public void fileWrite(String solution) {
        System.out.println("hi");
        File file = new File("friday.out");
        try {
            FileWriter writer = new FileWriter(file);
            writer.append(solution);
            writer.flush();
            writer.close();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
    public static void main(String[] args) {
        friday frid = new friday();
        frid.read();
    }
}