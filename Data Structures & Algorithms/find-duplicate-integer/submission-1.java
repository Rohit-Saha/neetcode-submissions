class Solution {
    public int findDuplicate(int[] nums) {
        int dup = -1;
        int i=0;
        int j=nums[i]-1;
        // System.out.println(nums[i] + ":" + nums[j]);
        while((nums[i] != nums[j]) || ((nums[i] == nums[j]) && i==j)) {
            // System.out.println(nums[i] + ":" + nums[j]);
            if(nums[i] != nums[j]) {
                int temp = nums[i];
                nums[i] = nums[j];
                nums[j] = temp;
            } else {
                i++;
            }
            j=nums[i]-1;
        }

        return nums[i];

    }
}
