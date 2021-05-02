import java.util.*;
class Acowdemics3 {
    HashMap<Character,Character> friends = new HashMap<>();
    public void read() {
        Scanner scan = new Scanner(System.in);
        String[] StrArr = scan.nextLine().split(" ");
        int n = Integer.parseInt(StrArr[0]);
        int m = Integer.parseInt(StrArr[1]);
        char[][] arr = new char[n][m];
        int count = 0;
        int cowId = 1;
        for(int i = 0; i < n; i++) {
            char[] strArr = scan.nextLine().toCharArray();
            for(int j = 0; j < strArr.length; j++) {
                if (strArr[j] != 'C') {
                    arr[i][j] = strArr[j];
                } else {
                    arr[i][j] = Integer.toString(cowId).charAt(0);
                    cowId++;
                }
            }
        }
        for(int i = 0; i < arr.length; i++) {
            for(int j = 0; j < arr[0].length; j++) {
                if(arr[i][j] == 'G') {
                    int cowCount = 0;
                    char[] cowIdArr = new char[4];
                    if(i > 0) {
                        if(arr[i-1][j] != 'G' && arr[i-1][j] != '.') {
                            cowCount++;
                            if(cowCount == 1) {
                                cowIdArr[0] = arr[i-1][j];
                            } else if (cowCount == 2) {
                                cowIdArr[1] = arr[i-1][j];
                            } else if(cowCount == 3) {
                                cowIdArr[2] = arr[i-1][j];
                            } else {
                                cowIdArr[3] = arr[i-1][j];
                            }
                        }
                    }
                    if(i < arr.length - 1) {
                        if(arr[i+1][j] != 'G' && arr[i+1][j] != '.') {
                            cowCount++;
                            if(cowCount == 1) {
                                cowIdArr[0] = arr[i+1][j];
                            } else if (cowCount == 2) {
                                cowIdArr[1] = arr[i+1][j];
                            }else if(cowCount == 3) {
                                cowIdArr[2] = arr[i+1][j];
                            } else {
                                cowIdArr[3] = arr[i+1][j];
                            }
                        }
                    }
                    if (j > 0) {
                        if(arr[i][j-1] != 'G' && arr[i][j-1] != '.') {
                            cowCount++;
                            if(cowCount == 1) {
                                cowIdArr[0] = arr[i][j-1];
                            } else if (cowCount == 2) {
                                cowIdArr[1] = arr[i][j-1];
                            }else if(cowCount == 3) {
                                cowIdArr[2] = arr[i][j-1];
                            } else {
                                cowIdArr[3] = arr[i][j-1];
                            }
                        }
                    }
                    if(j < arr[0].length - 1) {
                        if(arr[i][j+1] != 'G' && arr[i][j+1] != '.') {
                            cowCount++;
                            if(cowCount == 1) {
                                cowIdArr[0] = arr[i][j+1];
                            } else if (cowCount == 2) {
                                cowIdArr[1] = arr[i][j+1];
                            }else if(cowCount == 3) {
                                cowIdArr[2] = arr[i][j+1];
                            }  else {
                                cowIdArr[3] = arr[i][j+1];
                            }
                        }
                    }

                    if(cowCount == 2) {
                        if(this.validate(cowIdArr[0],cowIdArr[1])) {
                            friends.put(cowIdArr[1],cowIdArr[1]);
                            count++;
                            arr[i][j] = '.';
                        }
                    }
                }
            }
        }
        for(int i = 0; i < arr.length; i++) {
            for(int j = 0; j < arr[0].length; j++) {
                if(arr[i][j] == 'G') {
                    int cowCount = 0;
                    char[] cowIdArr = new char[4];
                    if(i > 0) {
                        if(arr[i-1][j] != 'G' && arr[i-1][j] != '.') {
                            cowCount++;
                            if(cowCount == 1) {
                                cowIdArr[0] = arr[i-1][j];
                            } else if (cowCount == 2) {
                                cowIdArr[1] = arr[i-1][j];
                            } else if(cowCount == 3) {
                                cowIdArr[2] = arr[i-1][j];
                            } else {
                                cowIdArr[3] = arr[i-1][j];
                            }
                        }
                    }
                    if(i < arr.length - 1) {
                        if(arr[i+1][j] != 'G' && arr[i+1][j] != '.') {
                            cowCount++;
                            if(cowCount == 1) {
                                cowIdArr[0] = arr[i+1][j];
                            } else if (cowCount == 2) {
                                cowIdArr[1] = arr[i+1][j];
                            }else if(cowCount == 3) {
                                cowIdArr[2] = arr[i+1][j];
                            } else {
                                cowIdArr[3] = arr[i+1][j];
                            }
                        }
                    }
                    if (j > 0) {
                        if(arr[i][j-1] != 'G' && arr[i][j-1] != '.') {
                            cowCount++;
                            if(cowCount == 1) {
                                cowIdArr[0] = arr[i][j-1];
                            } else if (cowCount == 2) {
                                cowIdArr[1] = arr[i][j-1];
                            }else if(cowCount == 3) {
                                cowIdArr[2] = arr[i][j-1];
                            } else {
                                cowIdArr[3] = arr[i][j-1];
                            }
                        }
                    }
                    if(j < arr[0].length - 1) {
                        if(arr[i][j+1] != 'G' && arr[i][j+1] != '.') {
                            cowCount++;
                            if(cowCount == 1) {
                                cowIdArr[0] = arr[i][j+1];
                            } else if (cowCount == 2) {
                                cowIdArr[1] = arr[i][j+1];
                            }else if(cowCount == 3) {
                                cowIdArr[2] = arr[i][j+1];
                            }  else {
                                cowIdArr[3] = arr[i][j+1];
                            }
                        }
                    }

                    if(cowCount >= 2) {
                        boolean breakbool = false;
                        for(int z = 0; z < cowCount; z ++) {
                            for(int x = z+1; x < cowCount; x++) {
                                if(cowIdArr[z] != '\u0000' && cowIdArr[x] != '\u0000') {
                                    if(this.validate(cowIdArr[z],cowIdArr[x])) {
                                        friends.put(cowIdArr[z],cowIdArr[x]);
                                        count++;
                                        breakbool = true;
                                        arr[i][j] = '.';
                                        break;
                                    }
                                }
                            }
                            if(breakbool) {
                                break;
                            }
                        }
                    }
                }
            }
        }
        System.out.println(count);
        return;
    }
    public boolean validate(char cowId1, char cowId2) {
        if(friends.containsKey(cowId1)) {
            if(friends.get(cowId1).equals(cowId2)) {
                return false;
            }
        } else if (friends.containsKey(cowId2)) {
            if(friends.get(cowId2).equals(cowId1)) {
                return false;
            }
        }
        return true;
    }

    public static void main(String[] args) {
        Acowdemics3 acowdemics = new Acowdemics3();
        acowdemics.read();
    }
}