class Solution {
    public int shortestPathBinaryMatrix(int[][] grid) {
        int ROW = grid.length;
        int COL = grid[0].length;

        Deque<List<Integer>> queue = new LinkedList<>();
        int[][] visited = new int[ROW][COL];
        
        if(grid[0][0] == 1) return -1;
        queue.offer(List.of(0,0));
        visited[0][0]=1;
        int length = 1;
        while(queue.size() > 0) {
            for(int l=queue.size(); l>0; l--) {
                List<Integer> pair = queue.poll();
                int r = pair.get(0);
                int c = pair.get(1);

                if(r == ROW-1 && c == COL-1 && grid[r][c] == 0) {
                    return length;
                }

                List<List<Integer>> neighbours = new ArrayList<>();
                neighbours.add(List.of(r+1, c));
                neighbours.add(List.of(r-1, c));
                neighbours.add(List.of(r, c+1));
                neighbours.add(List.of(r, c-1));
                neighbours.add(List.of(r+1, c+1));
                neighbours.add(List.of(r-1, c-1));
                neighbours.add(List.of(r+1, c-1));
                neighbours.add(List.of(r-1, c+1));

                for(int i=0; i<neighbours.size(); i++) {
                    List<Integer> n = neighbours.get(i);
                    int nr = n.get(0);
                    int nc = n.get(1);

                    if(nr<0 || nc<0 || nr == ROW || nc ==COL || grid[nr][nc] == 1 || visited[nr][nc] == 1) {
                        continue;
                    }
                    queue.add(List.of(nr,nc));
                    visited[nr][nc] = 1;
                }
            }
            length++;
        }
        return -1;
    }
}