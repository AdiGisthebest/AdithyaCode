import java.util.*;
class Daisy {
    public void read() {
        Scanner scan = new Scanner(System.in);
        int length = Integer.parseInt(scan.nextLine());
        int[] petals = new int[length];
        int ans = 0;
        String[] readArr = scan.nextLine().split(" ");
        HashSet<Double> set = new HashSet<>();
        for(int i = 0; i < length; i ++) {
            petals[i] = Integer.parseInt(readArr[i]);
        }
        for(int i = 0 ; i < length; i ++) {
            for(int j = i; j < length; j++){
                double avg = 0;
                int add = 0;
                for(int k = i; k <= j; k ++) {
                    add = add + petals[k];
                    set.add((double)petals[k]);
                }
                if(add != 0) {
                    avg = (double)add/(double)(j-i + 1);
                    System.out.println(avg + " " + add + " " + j + " " + i);
                }
                if(set.contains(avg)) {
                    System.out.println(avg + " " + add + " " + j + " " + i + " SUCCESS");
                    ans++;
                }
            }
        }
        System.out.println(ans);
    }

    public static void main(String[] args) {
        Daisy daisy = new Daisy();
        daisy.read();
    }
}