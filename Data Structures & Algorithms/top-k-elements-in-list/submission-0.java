class Solution {
    public int[] topKFrequent(int[] nums, int k) {
        int[] output = new int[k];
        Map<Integer, Integer> frequencyMap = new HashMap<>();

        for(int num: nums) {
            // if(frequencyMap.contains(num)) {
            //     frequencyMap.put(num, 1);
            // } else {
            //     frequencyMap.put(num, frequencyMap.get(num)+1);
            // }
            frequencyMap.put(num, frequencyMap.getOrDefault(num, 0)+1);
        }

        for(int i=0; i<k; i++) {
            int maxFreq = 0;
            int maxFreqElement = -1;

            for(Map.Entry<Integer, Integer> entry: frequencyMap.entrySet()) {
                if(entry.getValue() > maxFreq) {
                    maxFreq = entry.getValue();
                    maxFreqElement = entry.getKey();
                }
            } 
            output[i] = maxFreqElement;
            frequencyMap.remove(maxFreqElement);
        }

        return output;
    }
}
