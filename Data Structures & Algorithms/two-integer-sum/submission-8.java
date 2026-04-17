class Solution {

    public int[] twoSum(int[] nums, int target) {
        Map<Integer, Integer> freqMap = new HashMap<>();
        int[] pair = {-1, -1};

        for(int i=0; i<nums.length; i++) {
            int v = target-nums[i];
            if(freqMap.containsKey(v)) {
                pair[0] = freqMap.get(v);
                pair[1] = i;
                break;
            }
            freqMap.put(nums[i], i);
        }

        return pair;
    }
}
