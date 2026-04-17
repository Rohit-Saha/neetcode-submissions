class Solution {
    public List<List<Integer>> threeSum(int[] nums) {
        List<List<Integer>> res = new ArrayList<>();

        Arrays.sort(nums);

        for(int i=0; i<nums.length; i++) {
            if(nums[i] > 0) break;
            if(i > 0 && nums[i] == nums[i-1]) {
                continue;
            }

            int s = i+1;
            int e = nums.length-1;
            while(s<e) {
                int sum = nums[i] + nums[s] + nums[e];
                if(sum == 0) {
                    res.add(Arrays.asList(nums[i], nums[s], nums[e]));
                    s++;
                    e--;
                    while(s<e && nums[s] == nums[s-1]) {
                        s++;
                    }
                } else if(sum < 0) {
                    s++;
                } else {
                    e--;
                }

                
            }
        }

        return res;
    }
}
