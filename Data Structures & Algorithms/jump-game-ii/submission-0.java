class Solution {
    public int jump(int[] nums) {
        int l = 0;
        int r=0;
        int minJumps = 0;
        while(r<nums.length-1) {
            int farthestIndex = l+nums[l];
            while(l<=r) {
                farthestIndex = Math.max(l+nums[l], farthestIndex);
                l++;
            }
            l = r+1;
            r = farthestIndex;
            minJumps++;
        }
        return minJumps;
    }
}
