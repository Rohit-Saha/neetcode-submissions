class Solution {
    public void sortColors(int[] nums) {
       int r = 0;
       int i=0;
       int b = nums.length-1;

       while(i<=b) {
        if(nums[i] == 0) {
            swap(nums, i, r);
            r++;
        } else if(nums[i] == 2) {
            swap(nums, i, b);
            b--;
            i--;
        }
        i++;
       }
    }

    private void swap(int[] nums, int l, int r) {
        int temp = nums[l];
        nums[l] = nums[r];
        nums[r] = temp;
    }
}