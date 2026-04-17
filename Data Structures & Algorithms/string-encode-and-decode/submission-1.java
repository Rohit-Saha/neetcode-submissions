class Solution {

    public String encode(List<String> strs) {
        StringBuilder strBuilder = new StringBuilder();

        for(String str: strs) {
            strBuilder.append(str.length()).append(",");
        }
        strBuilder.append("#");

        for(String str: strs) {
            strBuilder.append(str);
        }

        return strBuilder.toString();
    }

    public List<String> decode(String str) {
        List<String> res = new ArrayList<>();
        List<Integer> sizes = new ArrayList<>();

        if(str.length() == 0) {
            return res;
        }
        int i=0;
        while(str.charAt(i) != '#') {
            StringBuilder cur = new StringBuilder();
            while(str.charAt(i) != ',') {
                cur.append(str.charAt(i));
                i++;
            }
            sizes.add(Integer.parseInt(cur.toString()));
            i++;
        }
        i++;

        for(int s: sizes) {
            res.add(str.substring(i, i+s));
            i+= s;
        }
        return res;
    }
}
