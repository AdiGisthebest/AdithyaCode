import java.util.Arrays;
import java.util.Collections;
import java.util.Scanner;

public class ABC {
    public void read() {
        Scanner scanner = new Scanner(System.in);
        Integer[] numbers = new Integer[7];
        for(int i = 0; i < 7; i++) {
            numbers[i] = scanner.nextInt();
        }
        Arrays.sort(numbers, Collections.reverseOrder());
        int abc = numbers[0];
        int a = abc - numbers[1];
        int b = abc - numbers[2];
        int c = abc - (a + b);
        System.out.println(a +" " +  b +" "+ c);
    }
    public static void main(String[] args) {
        ABC abc = new ABC();
        abc.read();
    }
}
