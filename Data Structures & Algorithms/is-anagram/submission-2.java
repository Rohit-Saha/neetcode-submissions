class Solution {
    //Using HashTable
    public boolean isAnagramHash(String s, String t) {
        HashMap<Character, Integer> map = new HashMap<>();

        if(s.length() != t.length()) {
            return false;
        }

        for(int i=0; i<s.length(); i++) {
            map.put(s.charAt(i), map.getOrDefault(s.charAt(i), 0) + 1);
        }

        for(int i=0; i<t.length(); i++) {
            char ch = t.charAt(i);

            if(map.getOrDefault(ch, 0) == 0) {
                return false;
            }
            map.put(ch, map.get(ch) - 1);
        }

        return true;
    }

    public boolean isAnagram(String s, String t) {

        if(s.length() != t.length()) {
            return false;
        }

        int count[] = new int[26]; //constant space

        for(int i=0; i<s.length(); i++) {
            count[s.charAt(i) - 'a']++;
            count[t.charAt(i) - 'a']--;
        }

        for(int v:count) {
            if(v != 0) {
                return false;
            }
        }

        return true;
    }
    
}
