class Solution {
    public int search(int[] nums, int target) {
        
        int l=0;
        int r=nums.length-1;

        while(l<r) {
            int m = l+ (r-l)/2;

            if(nums[m] < nums[r]) {
                r = m;
            } else {
                l = m+1;
            }
        }

        if(target > nums[nums.length-1]) {
            return binarySearch(nums, target, 0, l-1);
        } else {
            return binarySearch(nums, target, l, nums.length-1);
        }
    }

    private int binarySearch(int[] nums, int target, int start, int end) {

        while(start <= end) {
            int mid = start + (end-start)/2;

            if(nums[mid] == target) {
                return mid;
            } else if(target < nums[mid]) {
                end = mid-1;
            } else {
                start = mid + 1;
            }
        }

        return -1;
    }
}
