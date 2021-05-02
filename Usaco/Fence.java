import java.util.*;
class Fence {
    public void read() {
        Scanner scan = new Scanner(System.in);
        int run = Integer.parseInt(scan.nextLine());
        String [] ansStore = new String[run];
        for(int i = 0; i < run; i++) {
            ansStore[i] = this.solve(scan.nextLine());
        }
        for(int i = 0; i < run; i++) {
          System.out.println(ansStore[i]);
        }
    }
    public String solve(String direction) {
        int eastmost = 0;
        int southmost = 0;
        int westmost = 0;
        int northmost = 0;
        int east = 0;
        int south = 0;
        int west = 0;
        int north = 0;
        int northpos = 0;
        int southpos = 0;
        int eastpos = 0;
        int westpos = 0;
        for(int i = 0; i < direction.length(); i++) {
            switch(direction.charAt(i))  {
                case 'N' : north ++;
                south--;
                break;
                case 'S': south++;
                north--;
                case 'E': east++;
                west--;
                case 'W': west++;
                east--;
            }
            if(north > northmost) {
                northmost = north;
                northpos = i;
            }
            if(south > southmost) {
                southmost = south;
                southpos = i;
            }
            if(east > eastmost) {
                eastmost = east;
                eastpos = i;
            }
            if(west > westmost) {
                westmost = west;
                westpos = i;
            }
        }
        if(northmost == 0) {
            northpos = 0;
        }
        if(southmost == 0) {
            southpos = 0;
        }
        if(eastmost == 0) {
            eastpos = 0;
        }
        if(westmost == 0) {
            westpos = 0;
        }
        System.out.println(northpos + "  " + westpos);
        if(northpos < southpos) {
            if(westpos < eastpos) {
              if (northpos < westpos) {
                  return "CW";
              } else if (northpos == westpos) {
                  if(eastpos < southpos) {
                      return "CW";
                  } else {
                      return "CCW";
                  }
              } else {
                  return "CCW";
              }
            } else {
                if (northpos < eastpos) {
                    return "CW";
                } else if (northpos == eastpos) {
                    if(westpos < southpos) {
                        return "CCW";
                    } else {
                        return "CW";
                    }
                } else {
                    return "CCW";
                }
            }
        } else {
            if(westpos < eastpos) {
                if (southpos < westpos) {
                    return "CCW";
                } else if (northpos == westpos) {
                    if(eastpos < northpos) {
                        return "CCW";
                    } else {
                        return "CW";
                    }
                } else {
                    return "CW";
                }
            } else {
                if (southpos < eastpos) {
                    return "CW";
                } else if (southpos == eastpos) {
                    if(westpos < southpos) {
                        return "CW";
                    } else {
                        return "CCW";
                    }
                } else {
                    return "CCW";
                }
            }
        }
    }

    public static void main(String[] args) {
        Fence fence = new Fence();
        fence.read();
    }
}