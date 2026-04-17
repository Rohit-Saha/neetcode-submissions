class Solution {
    public int[] productExceptSelf(int[] nums) {
        int[] prefix = new int[nums.length];
        int[] suffix = new int[nums.length];
        int[] output = new int[nums.length];

        prefix[0] = 1;
        suffix[0] = 1;

        for(int i=1; i<nums.length; i++) {
            prefix[i] = nums[i-1] * prefix[i-1];
        }

        for(int i=nums.length-2; i>=0; i--) {
            suffix[nums.length-1-i] = nums[i+1] * suffix[nums.length-2-i];
        }

        for(int i=0; i<nums.length; i++) {
            output[i] = prefix[i] * suffix[nums.length-1-i];
        }

        return output;

    }
}  
