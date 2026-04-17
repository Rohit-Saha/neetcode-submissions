class Solution {
    public String minWindow(String s, String t) {
        if(s.length() == 0 || t.length() == 0) {
            return "";
        }
        Map<Character, Integer> countT = new HashMap<>();
        Map<Character, Integer> window = new HashMap<>();
        for(char c: t.toCharArray()) {
            countT.put(c, countT.getOrDefault(c, 0)+1);
        }
        int have = 0;
        int need = countT.size();
        int[] res = {-1, -1};
        int minWindowSize = Integer.MAX_VALUE;

        int l=0;
        for(int r=0; r<s.length(); r++) {
            char ch = s.charAt(r);
            if(countT.containsKey(ch)) {
                window.put(ch, window.getOrDefault(ch, 0)+1);

                if(window.get(ch).equals(countT.get(ch))) {
                    have++;
                }
            }

            while(have == need) {
                if(r-l+1 < minWindowSize) {
                    res[0] = l;
                    res[1] = r;
                    minWindowSize = r-l+1;
                }

                if(window.getOrDefault(s.charAt(l), 0) > 0) {
                    window.put(s.charAt(l), window.get(s.charAt(l))-1);
                }

                if(countT.containsKey(s.charAt(l)) && window.getOrDefault(s.charAt(l), 0) < countT.getOrDefault(s.charAt(l), 0)) {
                    have--;
                }
                l++;
            }
        }

        if(res[0] == -1 || res[1] == -1) {
            return "";
        }

        return s.substring(res[0], res[1]+1);
    }
}
