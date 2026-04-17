class Solution {
    public int findMaxConsecutiveOnes(int[] nums) {
        int maxConsOnes = 0;

        int i=0;
        int j=0;

        while(j<nums.length) {
            if(nums[j] == 1) {
                maxConsOnes = Math.max(maxConsOnes, j-i+1);
                j++;
            } else {
                while(j<nums.length && nums[j] != 1) {
                    j++;
                }
                i=j;
            }
        }

        return maxConsOnes;
    }
}