class Solution {
    public List<List<Integer>> threeSum(int[] nums) {
        int N = nums.length;
        List<List<Integer>> output = new ArrayList<>();

        Arrays.sort(nums);

        for(int i=0; i<N; i++) {
            if(i>0 && nums[i] == nums[i-1]) continue;
            int k = -(nums[i]);
            
            // List<List<Integer>> list = new ArrayList<>();
            int s = i+1;
            int e = N-1;
            // System.out.println(s + " " + e + " " + k);
            while(s < e) {
                int sum = nums[s] + nums[e];
                if(sum < k) {
                    s++;
                } else if(sum > k) {
                    e--;
                } else {
                    List<Integer> pair = new ArrayList<>();
                    pair.add(nums[s]);
                    pair.add(nums[e]);
                    pair.add(nums[i]);
                    output.add(pair);
                    s++;
                    e--;
                    while(s<e && nums[s] == nums[s-1]) {
                        s++;
                    }
                }
            }
            
        }
        return output;

    }
}
