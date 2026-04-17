class Solution {

    private boolean[][] visited;
    private Set<String> res;

    class TrieNode {
        Map<Character, TrieNode> childrens;
        boolean word;

        public TrieNode() {
            this.childrens = new HashMap<>();
            this.word = false;
        }

        public void addWord(String word) {
            TrieNode curr = this;
            for(char c: word.toCharArray()) {
                if(!curr.childrens.containsKey(c)) {
                    curr.childrens.put(c, new TrieNode());
                }
                curr = curr.childrens.get(c);
            }
            curr.word = true;
        }
    }

    public List<String> findWords(char[][] board, String[] words) {
        TrieNode root = new TrieNode();
        for(String word: words) {
            root.addWord(word);
        }

        int ROWS = board.length;
        int COLS = board[0].length;
        visited = new boolean[ROWS][COLS];
        res = new HashSet<>();

        for(int r=0; r<ROWS; r++) {
            for(int c=0; c<COLS; c++) {
                dfs(board, r, c, root, "");
            }
        }
        return new ArrayList<>(res);
    }

    private void dfs(char[][] board, int row, int col, TrieNode node, String word) {
        int ROWS = board.length;
        int COLS = board[0].length;

        if(row < 0 || col < 0 || row == ROWS || col == COLS || 
        visited[row][col] || 
        !node.childrens.containsKey(board[row][col])) {
            return;
        }

        visited[row][col] = true;
        node = node.childrens.get(board[row][col]);

        word += board[row][col];

        if(node.word) {
            res.add(word);
        }

        dfs(board, row+1, col, node, word);
        dfs(board, row-1, col, node, word);
        dfs(board, row, col+1, node, word);
        dfs(board, row, col-1, node, word);

        visited[row][col] = false;
    }
}
