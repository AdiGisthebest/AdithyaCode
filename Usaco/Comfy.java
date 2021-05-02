import java.util.*;
class Comfy {
    public void read () {
        Scanner scan = new Scanner(System.in);
        int num = Integer.parseInt(scan.nextLine());
        int [][][] coords = new int[num][4][2];
        int[] remaining = new int[num];
        for(int i = 0; i < num; i++) {
            String[] strArr = scan.nextLine().split(" ");
            int [] arr = new int[2];
            arr[0] = Integer.parseInt(strArr[0]);
            arr[1] = Integer.parseInt(strArr[1]);
            coords[i][0][0] = arr[0]-1;
            coords[i][0][1] = arr[1];
            coords[i][1][0] = arr[0] + 1;
            coords[i][1][1] = arr[1];
            coords[i][2][0] = arr[0];
            coords[i][2][1] = arr[1] + 1;
            coords[i][3][0] = arr[0];
            coords[i][3][1] = arr[1] - 1;
            for(int j = 0; j < i; j++) {
                for(int k = 0; k < 4; k++) {
                    if(Arrays.equals(coords[j][k], arr)) {
                        remaining[j]++;
                        remaining[i]++;
                    }
                }
            }
            int number = 0;
            for(int j = 0; j < num; j++) {
                if(remaining[j] == 3) {
                   number++;
                }
            }
            System.out.println(number);
        }
    }

    public static void main(String[] args) {
        Comfy comfy = new Comfy();
        comfy.read();
    }
}