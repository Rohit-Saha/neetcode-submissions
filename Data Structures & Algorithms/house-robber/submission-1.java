class Solution {
    public int rob(int[] nums) {
        int[] cache = new int[nums.length];
        return rob(nums, 0, cache);
    }

    private int rob(int[] nums, int i, int[] cache) {
        
        if(i >= nums.length) {
            return 0;
        }

        if(cache[i] > 0) {
            return cache[i];
        }

        cache[i] = Math.max(nums[i] + rob(nums, i+2, cache), rob(nums, i+1, cache));
        return cache[i];
    }
}
