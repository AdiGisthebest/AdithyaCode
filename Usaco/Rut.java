import java.util.*;
class Rut {
    public void read() {
        Scanner scan = new Scanner(System.in);
        int length = Integer.parseInt(scan.nextLine());
        List<List<int[]>> compete = new ArrayList<>();
        int [] eastY = new int[length];
        int [] northX = new int[length];
        int eastpos = 0;
        int northpos = 0;
        HashMap<Integer, Integer> eastMap = new HashMap<>();
        HashMap<Integer, Integer> northMap = new HashMap<>();
        for(int i = 0; i < length; i++) {
            String[] str = scan.nextLine().split(" ");
            if (str[0].equals("N")) {
                int x = Integer.parseInt(str[1]);
                int y = Integer.parseInt(str[2]);
                northX[northpos] = x;
                northMap.put(x, y);
                northpos++;
            } else {
                int x = Integer.parseInt(str[1]);
                int y = Integer.parseInt(str[2]);
                eastMap.put(y, x);
                eastY[eastpos] = y;
                eastpos++;
            }
        }
        eastY = this.shrinkWrap(eastY,eastpos);
        northX = this.shrinkWrap(northX,northpos);
        Arrays.sort(northX);
        for(int i = 0; i < eastpos; i++) {
            List<int[]> addList = new ArrayList<>();
            for(int j = 0; j < northpos; j++) {
                if(eastMap.get(eastY[i]) < northX[j]) {
                    int[] addArr = new int[2];
                    if (northMap.get(northX[j]) < eastY[i]) {
                        addArr[0] = eastY[i] - northMap.get(northX[j]);
                        addArr[1] = northX[j] - eastMap.get(eastY[i]);
                        System.out.println((eastY[i] - northMap.get(northX[j])) + " " + (northX[j] - eastMap.get(eastY[i])) + " " + eastMap.get(eastY[i]) + " " + northX[j]);
                        addList.add(addArr);
                    }
                }
            }
            compete.add(addList);
        }
        System.out.println(compete);
        ListIterator iter = compete.listIterator();
        while(iter.hasNext) {
            List<int[]> list = iter.next();
            ListIterator smallIter =(List<int[]>) list.listIterator();
            while(smallIter.hasNext()) {
                int[] arr = (int[])smallIter.next();

            }
        }
    }
    public int[] shrinkWrap(int[] wrapper, int northPos) {
        int[] ansArr = new int[northPos];
        for(int i = 0; i < northPos; i++) {
            ansArr[i] = wrapper[i];
        }
        return ansArr;
    }
    public static void main(String[] args) {
        Rut rut = new Rut();
        rut.read();
    }
}