class Solution {
    public boolean validWordAbbreviation(String word, String abbr) {
        int i=0;
        int j=0;

        while(i<word.length() && j<abbr.length()) {
            if(Character.isDigit(abbr.charAt(j))) {
                int s = j;
                while(j<abbr.length() && Character.isDigit(abbr.charAt(j))) {
                    j++;
                }
                String num = abbr.substring(s, j);

                if(num.startsWith("0")) {
                    return false;
                }
                int c = 0;
                int n = Integer.parseInt(num);
                while(i< word.length() && c <n) {
                    c++;
                    i++;
                }

                if(c < n) {
                    return false;
                }
            }

            if(i >= word.length()) {
                break;
            }

            if((word.charAt(i) != abbr.charAt(j))) {
                return false;
            }
            i++;
            j++;
        }

        if(i < word.length() || j < abbr.length()) {
            return false;
        }

        return true;
    }
}