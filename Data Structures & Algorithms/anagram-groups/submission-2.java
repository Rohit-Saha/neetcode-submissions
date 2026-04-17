class Solution {
    // public List<List<String>> groupAnagrams(String[] strs) {
    //     Map<String, List<String>> map = new HashMap<>(); 

    //     for(String str: strs) {
    //         char[] charArr = str.toCharArray();

    //         Arrays.sort(charArr);
    //         String key = Arrays.toString(charArr);
    //         map.putIfAbsent(key, new ArrayList<>());

    //         map.get(key).add(str);

    //     }

    //     return new ArrayList<>(map.values());
    // }

    public List<List<String>> groupAnagrams(String[] strs) {
        Map<String, List<String>> map = new HashMap<>(); 

        for(String str: strs) {
            int[] freq = new int[26];

            for(int i=0; i<str.length(); i++) {
                char ch = str.charAt(i);
                freq[ch-'a']++;
            }

            String key = Arrays.toString(freq);
            map.putIfAbsent(key, new ArrayList<>());
            map.get(key).add(str);

        }

        return new ArrayList<>(map.values());
    }
}
