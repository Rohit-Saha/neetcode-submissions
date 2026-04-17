class Solution {
    public int subarraySum(int[] nums, int k) {
        int count = 0;
        HashMap<Integer, Integer> pSumMap = new HashMap<>();
        pSumMap.put(0, 1);
        int currentSum = 0;
        for(int num: nums) {
            currentSum += num;
            int diff = currentSum - k;
            count += pSumMap.getOrDefault(diff, 0);
            pSumMap.put(currentSum, pSumMap.getOrDefault(currentSum, 0) + 1);
        }

        return count;
    }
}