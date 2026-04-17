class Solution {
    public int numIslands(char[][] grid) {
        int[][] visited = new int[grid.length][grid[0].length];
        int islandCount = 0;
        for(int r=0; r<grid.length; r++) {
            for(int c=0; c<grid[0].length; c++) {
                if(grid[r][c] == '1' && visited[r][c] == 0) {
                    dfs(grid, r, c, visited);
                    islandCount++;
                    // System.out.println(Arrays.deepToString(visited));
                }
            }
        }
        return islandCount;
    }

    private void dfs(char[][] grid, int r, int c, int[][] visited) {
        int ROW = grid.length;
        int COL = grid[0].length;

        if(r < 0 || c < 0|| r == ROW || c == COL || visited[r][c] == 1 
        || grid[r][c] == '0') {
            return;
        }

        visited[r][c] = 1;

        dfs(grid, r, c+1, visited);
        dfs(grid, r, c-1, visited);
        dfs(grid, r+1, c, visited);
        dfs(grid, r-1, c, visited);
        
        return;
    }
}
