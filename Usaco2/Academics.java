import java.util.*;
class Academics {
    public void read() {
        Scanner scanner = new Scanner(System.in);
        String [] strArr = scanner.nextLine().split(" ");
        int length = Integer.parseInt(strArr[0]);
        int citations = Integer.parseInt(strArr[1]);
        int count = 0;
        PriorityQueue<Integer> queue = new PriorityQueue<>(length, Collections.reverseOrder());
        String [] citationArr = scanner.nextLine().split(" ");
        for(int i = 0 ; i < length; i ++) {
            queue.add(Integer.parseInt(citationArr[i]));
        }
        for(int i = 0; i < length; i ++) {
            Integer num = queue.poll();
            if(num != null) {
                if(num < (i+1)) {
                    int citationNeeded = (i+1) - num;
                    if(citationNeeded > 1) {
                        System.out.println(count);
                        return;
                    } else if (citations == 0){
                        System.out.println(count);
                        return;
                    } else {
                        citations = citations - 1;
                    }
                }
                count++;
            }
        }
        System.out.println(count);
    }
    public static void main(String[] args) {
        Academics academic = new Academics();
        academic.read();
    }
}