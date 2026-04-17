class Solution {
    public List<List<Integer>> threeSum(int[] nums) {
        //Sort the array

        Arrays.sort(nums);

        List<List<Integer>> result = new ArrayList<>();

        // HashSet<Integer> set = new HashSet<>();

        for(int i=0; i<nums.length-2; i++) {
            if(nums[i] > 0) break;
            if(i > 0 && nums[i] == nums[i-1]) {
                continue;
            }
            int target = 0-nums[i];

            int s = i+1;
            int e = nums.length-1;

            while(s<e) {
                if(nums[s] + nums[e] == target) {
                    result.add(Arrays.asList(nums[i], nums[s], nums[e]));
                    s++;
                    e--;
                    while(s<e && nums[s] == nums[s-1]) {
                        s++;
                    }
                } else if(nums[s] + nums[e] < target) {
                    s++;
                } else {
                    e--;
                }

                
            }
        }

        return result;

    }
}
