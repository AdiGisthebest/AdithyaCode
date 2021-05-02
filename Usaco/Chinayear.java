import java.util.*;
class Chinayear {
    public void read() {
        Scanner scan = new Scanner(System.in);
        int runNum = Integer.parseInt(scan.nextLine());
        String[][] order = new String [runNum][4];
        for (int i = 0; i < runNum; i++) {
            String [] orderNums = scan.nextLine().split(" ");
            order[i][0] = orderNums[0];
            order[i][1] = orderNums[3];
            order[i][2] = orderNums[4];
            order[i][3] = orderNums[7];
        }
        this.solve(order,runNum);
    }
    public void solve(String [][] order, int runNum) {
        String[] animals = {"Ox","Tiger","Rabbit","Dragon","Snake","Horse","Goat","Monkey","Rooster","Dog","Pig","Rat"};
        HashMap<String,Integer[]> cowMap = new HashMap<>();
        int j = 0;
        int num = 0;
        Integer[] add = new Integer[2];
        add[0] = new Integer(0);
        add[1] = new Integer(0);
        cowMap.put("Bessie",add);
        int iters = 0;
        for(int i = 0; i < runNum; i++) {
            Integer [] arr = cowMap.get(order[i][3]);
            num = (int)arr[1];
            j = (int)arr[0];
            if(order[i][2].equals(animals[j])) {

            }
            while(iters == 0 || !order[i][2].equals(animals[j])) {
                iters++;
                if(order[i][1].equals("next")) {
                    num++;
                    if(j+1 >= 12) {
                        j = 0;
                    } else {
                       j++;
                    }
                } else {
                    num--;
                    if(j-1 < 0) {
                        j = 11;
                    } else {
                        j--;
                    }
                }
            }
            if(order[i][0].equals("Elsie")) {
                System.out.println(Math.abs(num));
            }
            iters = 0;
            Integer [] addArr = new Integer[2];
            addArr[0] = j;
            addArr[1] = num;
            cowMap.put(order[i][0],addArr);
        }
    }
    public static void main(String[] args) {
        Chinayear chinayear = new Chinayear();
        chinayear.read();
    }
}