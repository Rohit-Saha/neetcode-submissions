class Solution {
    public int pivotIndex(int[] nums) {
        // int[] pSum = new int[nums.length];
        int pivot = -1;
        // pSum[0] = nums[0];
        int sum = 0;
        for(int i=0; i<nums.length; i++) {
            // pSum[i] = pSum[i-1] + nums[i];
            sum += nums[i];
        }
        int leftSum = 0;
        for(int i=0; i< nums.length; i++) {
            
            int rightSum = sum - (leftSum+nums[i]) ;

            // if(i > 0) {
            //     leftSum = pSum[i-1];
            // } 

            // if(i < nums.length-1) {
            //     rightSum = pSum[nums.length-1] - pSum[i];
            // }

            if(leftSum == rightSum) {
                pivot = i;
                break;
            }
            leftSum += nums[i];
        }
        return pivot;

    }
}