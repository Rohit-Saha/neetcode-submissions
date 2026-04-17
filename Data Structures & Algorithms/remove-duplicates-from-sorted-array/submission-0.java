class Solution {
    public int removeDuplicates(int[] nums) {
        int N = nums.length;
        int l=0;
        int r=0;

        while(r<N) {
            nums[l] = nums[r];
            while(r<N && nums[r] == nums[l]) {
                r++;
            }
            l++;
        }
        return l;
    }
}