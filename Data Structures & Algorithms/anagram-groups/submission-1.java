class Solution {
    public List<List<String>> groupAnagrams(String[] strs) {
        List<List<String>> output = new ArrayList<>();
        Map<String, List<String>> map = new HashMap<>(); 

        for(String str: strs) {
            char[] charArr = str.toCharArray();

            Arrays.sort(charArr);
            String key = Arrays.toString(charArr);
            map.putIfAbsent(key, new ArrayList<>());

            map.get(key).add(str);

        }

        return new ArrayList<>(map.values());
    }
}
