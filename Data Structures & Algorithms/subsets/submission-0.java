class Solution {
    public List<List<Integer>> subsets(int[] nums) {
        List<List<Integer>> subsetsList = new ArrayList<>();
        subsets(nums, new ArrayList<>(), 0, subsetsList);
        return subsetsList;
    }

    private void subsets(int[] nums, List<Integer> temp, int i, List<List<Integer>> subsetsList) {
        if(i == nums.length) {
            subsetsList.add(temp);
            return;
        }

        int v = nums[i];
        subsets(nums, temp, i+1, subsetsList);
        temp = new ArrayList<>(temp);
        temp.add(v);
        subsets(nums, temp, i+1, subsetsList);
    }
}
