import java.io.File;
import java.io.PrintStream;
import java.lang.management.PlatformLoggingMXBean;
import java.util.Scanner;

public class Balance {
    public void read() {
       try {
           Scanner scanner = new Scanner(new File("balancing.in"));
           String[] strArr = scanner.nextLine().split(" ");
           int length = Integer.parseInt(strArr[0]);
           int dimen = Integer.parseInt(strArr[1]);
           int[][] grid = new int[dimen+1][dimen+1];
           int[] xAdd = new int[dimen + 1];
           int[] yAdd = new int[dimen + 1];
           int xAvg = 0;
           int yAvg = 0;
           double xHalf = 0;
           double yHalf = 0;
           for(int i = 0; i < length; i++) {
               String[] arr = scanner.nextLine().split(" ");
               int xCoord = Integer.parseInt(arr[0]);
               int yCoord = Integer.parseInt(arr[1]);
               grid[yCoord][xCoord] = 1;
           }
           for(int i = 1; i < dimen; i+=2) {
               int xNum = 0;
               int yNum = 0;
               for(int j = 1; j < dimen; j+=2) {
                   if(grid[i][j] == 1) {
                       xNum++;
                   }
                   if(grid[j][i] == 1)  {
                       yNum++;
                   }
               }
               xAvg = xAvg+xNum;
               yAvg = yAvg+yNum;
               xAdd[i] = xNum;
               yAdd[i] = yNum;
           }
           xHalf = xAvg/2.0;
           yHalf = yAvg/2.0;
           int sum = 0;
           int diff = 0;
           int xNum = 0;
           int yNum = 0;
           int xWallCord = 0;
           int yWallCord = 0;
           for(int i = 1; i < xAdd.length; i+=2) {
               if(sum + xAdd[i] > xHalf) {
                   if((xHalf - sum) > ((sum + xAdd[i]) - xHalf)) {
                        sum = sum + xAdd[i];
                        xWallCord = i+1;
                        xNum = sum;
                        for(int j = 0; j < dimen + 1; j++) {
                            grid[i+1][j] = 2;
                        }
                        break;
                   }
                   xNum = sum;
                   xWallCord = i-1;
                   for(int j = 0; j < dimen + 1; j++) {
                       grid[i-1][j] = 2;
                   }

                    break;
               } else {
                   sum = sum + xAdd[i];
               }
           }
           sum = 0;
           for(int i = 1; i < yAdd.length; i+=2) {
               if(sum + yAdd[i] > yHalf) {
                   if((yHalf - sum) > ((sum + yAdd[i]) - yHalf)) {
                       sum = sum + yAdd[i];
                       yWallCord = i+1;
                       yNum = sum;
                       //System.out.println(sum + " ySum");
                       for(int j = 0; j < dimen + 1; j++) {
                           grid[j][i+1] = 2;
                       }
                       break;
                   }
                   yNum = sum;
                   yWallCord = i-1;
                   for(int j = 0; j < dimen + 1; j++) {
                       grid[j][i-1] = 2;
                   }
                   break;
               } else {
                   sum = sum + yAdd[i];
               }
           }
           //System.out.println(xWallCord + " " + yWallCord);
           /*for(int i = 0; i < grid.length; i++) {
               for(int j = 0; j < grid.length; j++) {
                   System.out.print(grid[i][j] + " ");
               }
               System.out.println();
           }*/
           int count = 0;
           boolean breakBool = false;
           for(int i = 0; i < grid.length; i++) {
                for(int j = 0; j < grid.length; j++) {
                    if(j >= yWallCord) {
                        //System.out.println("Wall");
                        break;
                    } else if(i >= xWallCord) {
                        breakBool = true;
                    }
                    if(grid[i][j] == 1) {
                        count ++;
                    }
                    //System.out.println("No wall");
                }
                if(breakBool) {
                    break;
                }
           }
           int count2 = xNum - count;
           int count3 = (length - yNum) - count2;
           int count4 = yNum-count;
           if(count >= count2 && count>=count3 && count>=count4) {
               System.out.println(count);
           } else if (count2 >= count && count2>=count3 && count2>=count4) {
               System.out.println(count2);
           } else if (count3 >= count2 && count3>=count && count3>=count4) {
               System.out.println(count3);
           } else {
               System.out.println(count4);
           }

       } catch(Exception e) {
          e.printStackTrace();
       }
    }

    public static void main(String[] args) {
        try {
            File file = new File("balancing.out");
            PrintStream stream = new PrintStream(file);
            System.setOut(stream);
        } catch (Exception e) {
            e.printStackTrace();
        }
        Balance balance = new Balance();
        balance.read();
    }
}
