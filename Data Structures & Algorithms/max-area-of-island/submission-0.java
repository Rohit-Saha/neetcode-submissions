class Solution {
    public int maxAreaOfIsland(int[][] grid) {
        int[][] visited = new int[grid.length][grid[0].length];
        int maxArea = 0;
        for(int r=0; r<grid.length; r++) {
            for(int c=0; c<grid[0].length; c++) {
                if(grid[r][c] == 1 && visited[r][c] == 0) {
                    int[] area = new int[1];
                    dfs(grid, r, c, visited, area);
                    maxArea = Math.max(maxArea, area[0]);
                }
            }
        }

        
        return maxArea;
    }

    private int[] dfs(int[][] grid, int r, int c, int[][] visited, int[] area) {
        int ROW = grid.length;
        int COL = grid[0].length;

        if(r<0 || c<0 || r == ROW || c == COL || grid[r][c] == 0 || visited[r][c] == 1) {
            return null;
        }

        visited[r][c] = 1;
        area[0]++;
        dfs(grid, r+1, c, visited, area);
        dfs(grid, r-1, c, visited, area);
        dfs(grid, r, c+1, visited, area);
        dfs(grid, r, c-1, visited, area);

        return area;
    }
}
