class Solution {
    public int[] twoSum(int[] nums, int target) {
        HashMap<Integer, Integer> map = new HashMap<>();
        int output[] = new int[2];

        for(int i=0; i<nums.length; i++) {
            int t = target - nums[i];

            if(map.containsKey(t)) {
                output[0] = map.get(t);
                output[1] = i;
                break;
            } else {
                map.put(nums[i], i);
            }
        }
        return output;
        
    }
}
