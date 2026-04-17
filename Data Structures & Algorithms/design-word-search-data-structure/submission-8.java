class WordDictionary {

    class TreeNode {
        Map<Character, TreeNode> childrens = new HashMap<>();
        boolean word;
    }

    private TreeNode root;

    public WordDictionary() {
        this.root = new TreeNode();
    }

    public void addWord(String word) {
        TreeNode curr = this.root;
        for(char c: word.toCharArray()) {
            if(!curr.childrens.containsKey(c)) {
                curr.childrens.put(c, new TreeNode());
            }
            curr = curr.childrens.get(c);
        }
        curr.word = true;
    }

    public boolean search(String word) {
        return search(word, 0, this.root);
    }

    private boolean search(String word, int i, TreeNode curr) {
        if(curr == null) {
            return false;
        }
        System.out.println(i);
        while(i<word.length()) {
            
            char c = word.charAt(i);
            System.out.println(c+ ": "+curr.childrens.keySet());
            if(c == '.') {
                for(char p: curr.childrens.keySet()) {
                    if(search(word, i+1, curr.childrens.get(p))) {
                        return true;
                    }
                 }
                 return false;
            } else if(!curr.childrens.containsKey(c)) {
                return false;
            }
            curr = curr.childrens.get(c);
            i++;
        }
        return curr.word;
    }
}
