class Solution {
    public int maxSubArray(int[] nums) {

        int maxSum = Integer.MIN_VALUE;

        int sum = 0;
        int r=0;

        while(r < nums.length) {
            sum = Math.max(sum, 0);
            sum += nums[r];
            maxSum = Math.max(maxSum, sum);
            r++;
        }
        return maxSum;
        
    }
}
