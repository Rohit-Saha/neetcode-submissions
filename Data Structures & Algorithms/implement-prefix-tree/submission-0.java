class PrefixTree {

    class TreeNode {
        Map<Character, TreeNode> childrens;
        boolean word;

        public TreeNode() {
            this.childrens = new HashMap<>();
            this.word = false;
        }
    }

    private TreeNode root;

    public PrefixTree() {
         this.root = new TreeNode();
    }

    public void insert(String word) {
        TreeNode curr = this.root;

        for(int i=0; i<word.length(); i++) {
            char c = word.charAt(i);
            if(!curr.childrens.containsKey(c)) {
                curr.childrens.put(c, new TreeNode());
            }
            curr = curr.childrens.get(c);
        }
        curr.word = true;

    }

    public boolean search(String word) {
        TreeNode curr = this.root;

        for(int i=0; i<word.length(); i++) {
            char c = word.charAt(i);
            if(!curr.childrens.containsKey(c)) {
                return false;
            }
            curr = curr.childrens.get(c);
        }
        return curr.word;
    }

    public boolean startsWith(String prefix) {
        TreeNode curr = this.root;

        for(int i=0; i<prefix.length(); i++) {
            char c = prefix.charAt(i);
            if(!curr.childrens.containsKey(c)) {
                return false;
            }
            curr = curr.childrens.get(c);
        }
        return true;
    }
}
