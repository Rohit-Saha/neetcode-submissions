class Solution {
    public int characterReplacement(String s, int k) {
        int res = 0;
        int l=0;
        HashMap<Character, Integer> map = new HashMap<>();
        for(int r=0; r<s.length(); r++) {
            char ch = s.charAt(r);
            if(map.containsKey(ch)) {
                map.put(ch, map.get(ch)+1);
            } else {
                map.put(ch, 1);
            }

            char maxFreqChar = getMaxFreq(map);

            if((r-l+1) - map.get(maxFreqChar) <= k) {   
                res = Math.max(res, r-l+1);
            }

            while((r-l+1) - map.get(maxFreqChar) > k) {
                char removeChar = s.charAt(l);
                map.put(removeChar, map.get(removeChar)-1);
                maxFreqChar = getMaxFreq(map);
                l++;
            }


        }
        return res;
    }

    private char getMaxFreq(HashMap<Character, Integer> map) {
        int maxFreq = Integer.MIN_VALUE;
        char maxFreqChar = ' ';
        for(Map.Entry<Character, Integer> entry: map.entrySet()) {
            if(entry.getValue() > maxFreq) {
                maxFreq = entry.getValue();
                maxFreqChar = entry.getKey();
            }
        }
        return maxFreqChar;
    }
}
