class PrefixTree {
    private Map<Character, PrefixTree> childrens;
    private boolean isWord;

    public PrefixTree() {
         this.childrens = new HashMap<>();
         this.isWord = false;
    }

    public void insert(String word) {
        PrefixTree curr = this;
        for(int i=0; i<word.length(); i++) {
            char ch = word.charAt(i);
            if(!curr.childrens.containsKey(ch)) {
                curr.childrens.put(ch, new PrefixTree());
            }
            curr = curr.childrens.get(ch);
        }
        curr.isWord = true;
    }

    public boolean search(String word) {
        PrefixTree curr = this;

        for(int i=0; i<word.length(); i++) {
            char ch = word.charAt(i);

            if(!curr.childrens.containsKey(ch)) {
                return false;
            }
            curr = curr.childrens.get(ch);
        }
        return curr.isWord;
    }

    public boolean startsWith(String prefix) {
        PrefixTree curr = this;

        for(int i=0; i<prefix.length(); i++) {
            char ch = prefix.charAt(i);

            if(!curr.childrens.containsKey(ch)) {
                return false;
            }
            curr = curr.childrens.get(ch);
        }
        return true;
    }
}
