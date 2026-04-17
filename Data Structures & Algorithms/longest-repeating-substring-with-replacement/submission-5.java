class Solution {
    public int characterReplacement(String s, int k) {
        Map<Character, Integer> map = new HashMap<>();

        int l=0;
        int r=0;
        int max = 0;

        int res = 0;

        while(r<s.length()) {
            char ch = s.charAt(r);
            map.put(ch, map.getOrDefault(ch, 0)+1);

            int maxFreq = 0;

            for(int c: map.values()) {
                maxFreq = Math.max(maxFreq, c);
            }

            while(r-l+1-maxFreq > k) {
                map.put(s.charAt(l), map.get(s.charAt(l))-1);
                l++;
                for(int c: map.values()) {
                    maxFreq = Math.max(maxFreq, c);
                }
            }

            res = Math.max(res, r-l+1);
            r++;
        }
        return res;
    }
}
