import java.util.Scanner;
import java.io.File;
import java.io.FileWriter;
import java.util.LinkedList;
import java.util.ListIterator;
class ABC {
    public void read(){
        try {
            Scanner scan = new Scanner(System.in);
            String numbers = scan.nextLine();
            this.Solution(numbers);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
    public String Solution(String numbers) {
       String[] numsString = numbers.split(" ");
       int [] nums = new int[7];
       for(int i = 0 ; i < 7; i ++) {
           nums[i] = Integer.parseInt(numsString[i]);
       }
       Arrays.sort(nums);
       int ABC = nums[nums.length - 1];
       int num1 = nums[nums.length - 2] + nums[nums.length - 3] - ABC;
       if(nums[nums.length - 4] == num1) {
           num2 = nums[nums.length - 5] + nums[nums.length - 2] - ABC;
           num3 = nums[nums.length - 5] + nums[nums.length - 3] - ABC;
       } else {
           num2 = nums[nums.length - 4] + nums[nums.length - 2] - ABC;
           num3 = nums[nums.length - 4] + nums[nums.length - 3] - ABC;
       }
       System.out.println(num1 + " " + num2 + " " + num3);
    }
    public static void main(String[] args) {
        ABC solution = new ABC();
        solution.read();
    }
}