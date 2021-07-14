class HashMap {
    int [] hashArr;
    public HashMap() {
        hashArr = new int[50];
    }
    //I don't have to worry about chaining because I am hashing using the value of the integers, so the numbers are guaranteed to be different.
    public int add(int key, int value) {
        if (key >= hashArr.length) {
            increaseArrCapacity(key * 2);
        }
        hashArr[key] = value;
    }
    public increaseArrCapacity(int num) {
        int[] newArr = new int[num];
        for(int i = 0; i < hashArr.length; i ++) {
            newArr[i] = hashArr[i];
        }
        hashArr = newArr;
    }
    public int get(int key) {
        return hashArr[value];
    }
    //This approach works for all digits other than 0
    public int search(int key) {
        if(hashArr[key] != 0) {
            return true;
        } else {
            return false;
        }
    }
}