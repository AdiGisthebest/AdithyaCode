import java.util.*;
class Space {
    public void read() {
        int n = 0;
        int val1 = 0;
        int val2 = 0;
        Scanner scan = new Scanner(System.in);
        n = Integer.parseInt(scan.nextLine());
        int[][] matrix = new int [n][n];
        for(int i = 0; i < n; i++) {
            String [] str = scan.nextLine().split(" ");
            for(int j = 0; j < n; j++) {
                matrix[i][j] = Integer.parseInt(str[j]);
            }
        }
        for(int i = 0; i < n; i ++) {
            int minval1 = 0;
            int minval2 = 0;
            for(int j = 0; j < n; j++) {
                if(j%2 == 0) {
                    minval1 = minval1 + matrix[i][j];
                } else {
                    minval2 = minval2 + matrix[i][j];
                }
            }
            if(minval2 > minval1) {
                val1 = val1+minval2;
            } else {
                val1 = val1+minval1;
            }
        }
        for(int i = 0 ; i < n; i ++) {
            int minval1 = 0;
            int minval2 = 0;
            for(int j = 0; j < n; j++) {
                if((j%2 == 0)) {
                    minval1 = minval1 + matrix[j][i];
                } else {
                    minval2 = minval2 + matrix[j][i];
                }
            }
            if(minval2 > minval1) {
                val2 = val2+minval2;
            } else {
                val2 = val2+minval1;
            }
        }
        if(val1 > val2) {
            System.out.println(val1);
        } else {
            System.out.println(val2);
        }
    }
    public static void main(String[] args) {
        Space space = new Space();
        space.read();
    }
}