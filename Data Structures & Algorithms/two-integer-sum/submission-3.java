class Solution {
    public int[] twoSum(int[] nums, int target) {
        HashMap<Integer, Integer> indices = new HashMap<>();
        HashMap<Integer, Integer> freq = new HashMap<>();
        int output[] = new int[2];

        for(int i=0; i<nums.length; i++) {
            indices.put(nums[i], i);
            freq.put(nums[i], freq.getOrDefault(nums[i], 0)+1);
        }

        for(int i=0; i<nums.length; i++) {
            int t = target-nums[i];

            if(t == nums[i] && freq.getOrDefault(t, 0) > 1) {
                output[0] = i;
                output[1] = indices.get(t);
                break;
            } else if(t != nums[i] && freq.containsKey(t)) {
                output[0] = i;
                output[1] = indices.get(t);
                break;
            }
        }
        return output;
        
    }
}
