class Solution {
    public boolean isPalindrome(String s) {
        String trimmedString = s.replaceAll("[^a-zA-Z0-9]", "");
        // System.out.println(trimmedString);
        for(int i=0; i<trimmedString.length()-1; i++) {
            if(Character.toLowerCase(trimmedString.charAt(i)) != Character.toLowerCase(trimmedString.charAt(trimmedString.length()-1-i))) {
                // System.out.println(Character.toLowerCase(trimmedString.charAt(i)));
                // System.out.println(Character.toLowerCase(trimmedString.charAt(trimmedString.length()-1-i)));
                return false;
            }
        }

        return true;
    }
}
