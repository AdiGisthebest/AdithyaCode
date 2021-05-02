import java.utils.HashMap;
class BeauArr {
    public void Solution(int[] nums) {
        HashMap<Integer,Integer> frequency = new HashMap<>();
        for(int i = 0; i < nums.length; i++) {
            if(frequency.containsKey(nums[i])) {
                frequency.put(nums[i],(frequency.get(nums[i]) + 1));
            } else {
                frequency.put(nums[i],1);
            }
        }
        int[] retArr = new int[((frequency.keySet().size() * (frequency.keySet().size() + 1))/2) - nums.length];
        
    }
}