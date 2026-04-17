class Solution {
    public int[] productExceptSelf(int[] nums) {
        int[] preProduct = new int[nums.length];
        int[] postProduct = new int[nums.length];
        int[] res = new int[nums.length];

        int p = 1;
        preProduct[0] = 1;
        postProduct[nums.length-1] = 1;
        for(int i=1; i<nums.length; i++) {
            preProduct[i] = preProduct[i-1] * nums[i-1];
            postProduct[nums.length-1-i] = postProduct[nums.length-i] * nums[nums.length-i];
        }

        for(int i=0; i<nums.length; i++) {
            res[i] = preProduct[i]*postProduct[i];
        }

        return res;
    }
}  
