import java.util.Scanner;
import java.io.File;
import java.io.FileWriter;
class swap {
    public void read() {
        try {
            System.out.println("hi");
            Scanner scan = new Scanner(new File("swap.in"));
            String[] arr = scan.nextLine().split(" ");
            this.fileWrite(this.solution(scan.nextLine().split(" "),scan.nextLine().split(" "),Integer.parseInt(arr[0]),Integer.parseInt(arr[1])));

        } catch (Exception e) {
            e.printStackTrace();
        }
    }
    public String solution(String[] first, String[] second, int cowNum, int times) {
        int[] arr1 = new int[2];
        arr1[0] = Integer.parseInt(first[0]);
        arr1[1] = Integer.parseInt(first[1]);
        int[] arr2 = new int[2];
        arr2[0] = Integer.parseInt(second[0]);
        arr2[1] = Integer.parseInt(second[1]);
        int[] ansArr = new int[cowNum];
        for(int i = 1; i <= cowNum; i++) {
            ansArr[i - 1] = i;
        }
        ansArr = this.revSub(ansArr,arr1[0] - 1,arr1[1] - 1);
        ansArr = this.revSub(ansArr,arr2[0] - 1,arr2[1] - 1);
        int[] copyArr = new int[ansArr.length];
        for(int i = 0; i < times; i++) {
            for (int j = 0; j < ansArr.length; j++) {
                copyArr[j] = ansArr[ansArr[j] - 1];
            }
        }
        ansArr = copyArr;
        StringBuilder build = new StringBuilder();
        for(int i = 0; i < ansArr.length; i++) {
            build.append(ansArr[i] + "\n");
        }
        return build.toString();
    }
    public int[] revSub(int [] arr, int pos1, int pos2) {
        for(int i = 0; i < ((pos2-pos1 + 1)/2); i++) {
            int temp = arr[pos1 + i];
            arr[pos1 + i] = arr[pos2 - i];
            arr[pos2 - i] = temp;
        }
        return arr;
    }
    public void fileWrite(String solution) {
        System.out.println("hi");
        File file = new File("swap.out");
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
        swap solution = new swap();
        solution.read();
    }
}