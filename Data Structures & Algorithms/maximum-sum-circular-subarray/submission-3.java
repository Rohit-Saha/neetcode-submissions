class Solution {
    public int maxSubarraySumCircular(int[] nums) {
        int currMax = 0;
        int currMin = 0;
        int globalMax = nums[0];
        int globalMin = nums[0];
        int total = 0;

        for(int n: nums) {
            currMax = Math.max(currMax + n, n);
            currMin = Math.min(currMin+n, n);

            total += n;

            globalMax = Math.max(globalMax, currMax);
            globalMin = Math.min(globalMin, currMin);
        }

        return globalMax > 0 ? Math.max(globalMax, total-globalMin) : globalMax;
    }
}