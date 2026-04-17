class Solution {
    public boolean canJump(int[] nums) {
        int goal = nums.length-1;
        int i = nums.length-2;

        while(i>=0) {
            if(i+nums[i] >= goal) {
                goal = i;
            }
            i--;
        }

        return goal == 0;
    }
}
