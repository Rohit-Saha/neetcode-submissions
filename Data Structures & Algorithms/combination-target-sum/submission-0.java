class Solution {
    public List<List<Integer>> combinationSum(int[] nums, int target) {
        List<List<Integer>> res = new ArrayList<>();
        dfs(0, nums, new ArrayList<>(), 0, target, res);
        return res;
    }

    private void dfs(int i, int[] nums, List<Integer> curr, int total, int target, List<List<Integer>> res) {
        if(total == target) {
            res.add(new ArrayList(curr));
            return;
        } else if(i >= nums.length || total > target) {
            return;
        }

        curr.add(nums[i]);
        dfs(i, nums, curr, total+nums[i], target, res);
        curr.remove(curr.size()-1);
        dfs(i+1, nums, curr, total, target, res);
    }
}
