class WordDictionary {

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
                curr.childrens.putIfAbsent(ch, new PrefixTree());
                curr = curr.childrens.get(ch);
            }
            curr.isWord = true;
        }
        

        private boolean search(String word, int j, PrefixTree node) {
            PrefixTree curr = node;

            for(int i=j; i<word.length(); i++) {
                char ch = word.charAt(i);
                if(ch == '.') {
                    for(PrefixTree c: curr.childrens.values()) {
                        if(c != null && search(word, i+1, c)) {
                            return true;
                        }
                    }
                    return false;
                } else {
                    if(!curr.childrens.containsKey(ch)) {
                        return false;
                    }
                    curr = curr.childrens.get(ch);
                }
                
            }
            return curr.isWord;
        }

        public boolean search(String word) {
            return search(word, 0, this);
        }
    }

    private PrefixTree prefixTree;

    public WordDictionary() {
        this.prefixTree = new PrefixTree();
    }

    public void addWord(String word) {
        this.prefixTree.insert(word);
    }

    public boolean search(String word) {
        return this.prefixTree.search(word);
    }
}
