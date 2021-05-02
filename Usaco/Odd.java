import java.util.*;
class Odd {
    public void read() {
        Scanner scan = new Scanner(System.in);
        scan.nextLine();
        String[] arr = scan.nextLine().split(" ");
        int oddNum = 0;
        int evenNum = 0;
        int ans = 0;
        boolean doFive;
        for (int i = 0; i < arr.length; i++) {
            if(Integer.parseInt(arr[i])%2 == 0) {
               evenNum++;
            } else {
                oddNum++;
            }
        }
        if(oddNum - evenNum > 0) {
            if(oddNum-evenNum%2 == 0) {
                ans = evenNum * 2;
                oddNum = oddNum - evenNum;
            } else if ((oddNum - evenNum - 2)%3 == 0) {
                ans = evenNum * 2;
                oddNum = oddNum - evenNum;
            } else if (evenNum > 0){
                ans = evenNum *2 -2;
                oddNum = oddNum - (evenNum - 1);
            }
        } else {
            ans = oddNum * 2 + 1;
            System.out.println(ans);
            return;
        }
        if((oddNum -2)%3 == 0) {
            doFive = false;
        } else {
            doFive = true;
        }

        while (oddNum > 0) {
            if (doFive) {
                if (oddNum % 3 != 0 && oddNum >= 5) {
                    oddNum = oddNum - 5;
                    ans = ans + 2;
                } else if (oddNum < 5 && oddNum % 3 != 0) {
                    ans++;
                    oddNum = 0;
                } else {
                    ans = ans + (oddNum / 3 * 2);
                    oddNum = 0;
                    break;
                }
            } else {
                if (oddNum % 3 != 0 && oddNum >= 3) {
                    oddNum = oddNum - 3;
                    ans = ans + 2;
                } else if (oddNum < 3 && oddNum % 3 != 0) {
                    ans++;
                    oddNum = 0;
                }
            }
        }
        System.out.println(ans);
    }

    public static void main(String[] args) {
        Odd odd = new Odd();
        odd.read();
    }
}