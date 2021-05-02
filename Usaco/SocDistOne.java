class SocDistOne {
    public void read() {
        File file = null;
        Scanner scan = null;
        try {
            file = new File("triangles.in");
            scan = new Scanner(file);
        } catch(Exception e) {
            e.printStackTrace();
        }
        int hole1 len = 0;
        int hole2 len = 0;
        int length = Integer.parseInt(scan.nextLine());
        int len0 = 0;
        int smallestD = Inetegr.MAX_VALUE;
        String[] arr = scan.nextLine().split("");
        for(int i = 0; i < length; i ++) {
            if(arr[i] == 0) {
                len0++;
            } else {
                if(len0 > hole1) {
                    hole1 = len0;
                    hole2 = hole1;
                } else if (len0 > hole2) {
                    hole2 = len0;
                }
            }
        }
        int d = 0;
        if(hole2%2 == 0) {
            d = (hole2/2) - 1;
        } else {
            d = hole2/2;
        }
        if(hole1 > ((hole2*2)-d)) {

        } else {

        }
    }
}