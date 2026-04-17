class Solution {
    public int maxSubArray(int[] nums) {

        int maxSum = Integer.MIN_VALUE;

        int sum = 0;

        int l=0;
        int r=0;

        while(r < nums.length) {
            sum += nums[r];
            maxSum = Math.max(maxSum, sum);

            if(sum < 0) {
                sum=0;
                l = r+1;
            }
            r++;
        }
        return maxSum;
        
    }
}
