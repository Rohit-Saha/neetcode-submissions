class Solution {
    public boolean containsNearbyDuplicate(int[] nums, int k) {
        HashSet<Integer> window = new HashSet<>();

        int l=0;
        int r=0;

        while(r < nums.length) {
            if(r-l > k) {
                window.remove(nums[l]);
                l++;
            }

            if(window.contains(nums[r])) {
                return true;
            }

            window.add(nums[r]);
            r++;

        }

        return false;
    }
}