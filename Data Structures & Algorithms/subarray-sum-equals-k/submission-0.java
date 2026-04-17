class Solution {
    public int subarraySum(int[] nums, int k) {
        int[] pSum = new int[nums.length+1];

        for(int i=0; i<nums.length; i++) {
            pSum[i+1] = pSum[i] + nums[i];
        }
        
        int count = 0;
        for(int s=0; s<nums.length; s++) {
            for(int e=s; e<nums.length; e++) {
                if(pSum[e+1]-pSum[s] == k) {
                    count++;
                }
            }
        }
        return count;
    }
}