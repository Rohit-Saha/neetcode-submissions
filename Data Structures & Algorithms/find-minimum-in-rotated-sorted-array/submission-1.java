class Solution {
    public int findMin(int[] nums) {
        int l=0;
        int r = nums.length-1;
        int min = nums[0];
        while(l<=r) {
            int mid = (l+r)/2;

            if(nums[mid] < nums[r]) {
                r = mid-1;
            } else {
                l = mid+1;
            }

            if(min > nums[mid]) {
                min = nums[mid];
            }



        }

        return min;
    }
}
