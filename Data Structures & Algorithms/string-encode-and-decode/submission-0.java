class Solution {

    public String encode(List<String> strs) {
        StringBuilder strBuilder = new StringBuilder();

        for(String s: strs) {
            strBuilder.append(s.length()+"#"+s);
        }

        return strBuilder.toString();
    }

    public List<String> decode(String str) {
        List<String> output = new ArrayList<>();
        int i=0;

        while(i<str.length()) {
            String lenStr = "";
            while(str.charAt(i) != '#') {
                lenStr += str.charAt(i);
                i++;
            }
            int len = Integer.parseInt(lenStr);
            i++;

            String s = str.substring(i, i+len);
            output.add(s);
            i = i+len;
        }
        return output;
    }
}
