import java.util.*;
class Cow {
    int [][] graphmatrix;
    public void read() {
        Scanner scan = new Scanner(System.in);
        int length = Integer.parseInt(scan.nextLine());
        graphmatrix = new int[length][length];
        for(int i = 0; i < length; i++) {
            this.add(i);
        }
        for(int i = 0; i < length-1; i++) {
            String[] StrConn = scan.nextLine().split(" ");
            int num1 = Integer.parseInt(StrConn[0]);
            int num2 = Integer.parseInt(StrConn[1]);
            this.setConn(num1 - 1,num2 - 1);
        }
        for(int i = 0 ; i < length; i++) {
            for(int j = 0 ; j < length; j++) {
                System.out.print(graphmatrix[i][j] + " ,");
            }
            System.out.println();
        }
        System.out.println(this.solveRecurs(0,new boolean[length],0));
    }
    public void add(int num) {
        graphmatrix[num][num] = 1;
    }
    public void setConn(int num1, int num2) {
        graphmatrix[num1][num2] = 1;
        graphmatrix[num2][num1] = 1;
    }
    public int solveRecurs(Integer currNum, boolean[] added, int ans) {
        List<Integer> arrList = new ArrayList<Integer>();
        for(int i = 0; i < graphmatrix.length; i++) {
            if(graphmatrix[currNum][i] == 1 && !added[i]) {
                added[i] = true;
                arrList.add(i);
            }
        }
        System.out.println(arrList);
        if(arrList.size() == 0) {
            return 0;
        }
        ans = ans + (int)Math.ceil(Math.log(arrList.size())/Math.log(2)) + arrList.size();
        ListIterator arrIter = arrList.listIterator();
        while(arrIter.hasNext()) {
            ans = ans + this.solveRecurs((Integer)arrIter.next(),added,ans);
        }
        return ans;
    }

    public static void main(String[] args) {
        Cow cow = new Cow();
        cow.read();
    }
}