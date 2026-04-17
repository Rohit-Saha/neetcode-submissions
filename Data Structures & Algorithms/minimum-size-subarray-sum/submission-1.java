class Solution {
    public int minSubArrayLen(int target, int[] nums) {
        int minLen = 0;
        int sum = 0;

        int l=0;

        for(int r=0; r<nums.length; r++) {
            sum += nums[r];

            while(sum >= target) {
                minLen = minLen == 0 ? r-l+1 : Math.min(minLen, r-l+1);
                sum -= nums[l];
                l++;
            }
        }
        
        return minLen;
    }
}