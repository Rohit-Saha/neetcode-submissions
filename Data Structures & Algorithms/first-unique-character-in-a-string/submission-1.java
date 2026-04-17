class Solution {
    // public int firstUniqChar(String s) {
    //     Map<Character, Integer> count = new HashMap<>();

    //     for(int i=0; i<s.length(); i++) {
    //         char ch = s.charAt(i);
    //         count.put(ch, count.getOrDefault(ch, 0) + 1);
    //     }

    //     for(int i=0; i<s.length(); i++) {
    //         if(count.get(s.charAt(i)) == 1) {
    //             return i;
    //         }
    //     }

    //     return -1;
    // }

    public int firstUniqChar(String s) {
        Map<Character, Integer> count = new HashMap<>();
        int n = s.length();
        for(int i=0; i<n; i++) {
            char ch = s.charAt(i);
            if(!count.containsKey(ch)) {
                count.put(ch, i);
            } else {
                count.put(ch, n);
            }
        }

        int res = n;

        for(int i: count.values()) {
            res = Math.min(res, i);
        }

        return res == n ? -1 : res;
    }
}