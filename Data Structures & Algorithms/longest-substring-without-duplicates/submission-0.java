class Solution {
    public int lengthOfLongestSubstring(String s) {
        int maxLength = 0;
        int l=0;
        int r=0;
        HashSet<Character> hash = new HashSet<>();

        while(r< s.length()) {
            char c = s.charAt(r);
            
            if(hash.contains(c)) {
                hash.remove(s.charAt(l));
                l++;
            } else {
                maxLength = Math.max(maxLength, r-l+1);
                // System.out.println(maxLength);
                hash.add(c);
                r++;
            }
            
        }
        return maxLength;
    }
}
