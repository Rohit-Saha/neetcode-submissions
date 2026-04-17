class Solution {
    public int longestConsecutive(int[] nums) {
        Set<Integer> set = new HashSet<>();
        List<Integer> starts = new ArrayList<>();
        for(int n: nums) {
            set.add(n);
        }
        int max = 0;
        for(int i=0; i<nums.length; i++) {
            int n = nums[i];
            if(!set.contains(n-1)) {
                int count = 1;
                while(set.contains(n+count)) {
                    count++;
                }
                max = Math.max(max, count);
                count=0;
            }
        }

        return max;
    }

}
