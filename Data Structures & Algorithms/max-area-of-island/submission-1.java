class Solution {
    public int maxAreaOfIsland(int[][] grid) {
        int[][] visited = new int[grid.length][grid[0].length];
        int maxArea = 0;
        for(int r=0; r<grid.length; r++) {
            for(int c=0; c<grid[0].length; c++) {
                if(grid[r][c] == 1 && visited[r][c] == 0) {
                    int area = dfs(grid, r, c, visited);
                    maxArea = Math.max(maxArea, area);
                }
            }
        }

        
        return maxArea;
    }

    private int dfs(int[][] grid, int r, int c, int[][] visited) {
        int ROW = grid.length;
        int COL = grid[0].length;

        if(r<0 || c<0 || r == ROW || c == COL || grid[r][c] == 0 || visited[r][c] == 1) {
            return 0;
        }

        visited[r][c] = 1;
        int area = 0;
        area += dfs(grid, r+1, c, visited);
        area += dfs(grid, r-1, c, visited);
        area += dfs(grid, r, c+1, visited);
        area += dfs(grid, r, c-1, visited);

        return area+1;
    }
}
