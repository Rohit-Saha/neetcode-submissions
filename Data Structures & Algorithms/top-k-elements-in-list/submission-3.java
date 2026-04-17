class Solution {
    public int[] topKFrequent(int[] nums, int k) {
        Map<Integer, Integer> map = new HashMap<>();
        int[] out = new int[k];

        for(int v: nums) {
            map.put(v, map.getOrDefault(v, 0)+1);
        }

        List<Integer>[] freq = new List[nums.length+1];

        for(int i=0; i<freq.length; i++) {
            freq[i] = new ArrayList<>();
        }

        for(Map.Entry<Integer, Integer> entry: map.entrySet()) {
            freq[entry.getValue()].add(entry.getKey());
        }

        int index = 0;
        for(int i=freq.length-1; i>0 && index<k; i--) {
            if(freq[i].size() > 0) {
                for(int v: freq[i]) {
                    out[index] = v;
                    index++;
                    if(index == k) {
                        return out;
                    }
                }
            }
        }
        return out;
    }
}
