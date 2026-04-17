class Solution {
    public int[] topKFrequent(int[] nums, int k) {
       int[] kFreqElements = new int[k];

       Map<Integer, Integer> map = new HashMap<>();

       for(int n: nums) {
        map.put(n, map.getOrDefault(n, 0)+1);
       } 

        List<int[]> arr = new ArrayList<>();

        for(Map.Entry<Integer, Integer> entry: map.entrySet()) {
            arr.add(new int[] {entry.getValue(), entry.getKey()});
        }

        arr.sort((a, b) -> a[0]-b[0]);

        for(int i=0; i<k; i++) {
            kFreqElements[i] = arr.get(arr.size()-i-1)[1];
        }

        return kFreqElements;

    }
}
