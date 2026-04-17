class Solution {
    public int findMaxConsecutiveOnes(int[] nums) {
        int maxConsOnes = 0;
        
        int count = 0;
        for(int i=0; i<nums.length; i++) {
            if(nums[i] == 1) {
                count++;
            } else {
                maxConsOnes = Math.max(count, maxConsOnes);
                count = 0;
            }
        }
        maxConsOnes = Math.max(count, maxConsOnes);
        return maxConsOnes;
    }
}