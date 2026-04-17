class Solution {
    public int shortestPath(int[][] grid) {
        int ROW = grid.length;
        int COL = grid[0].length;
        int[][] visited = new int[ROW][COL];
        Deque<List<Integer>> queue = new LinkedList<>();
        List<Integer> pair = new ArrayList<>();
        pair.add(0);
        pair.add(0);
        queue.offer(pair);
        visited[0][0] = 1;
        int length = 0;
        while(queue.size() > 0) {
            for(int l=queue.size(); l>0; l--) {
                List<Integer> p = queue.poll();
                int r = p.get(0);
                int c = p.get(1);
                if(r == ROW-1 && c == COL-1) {
                    return length;
                }
                List<List<Integer>> neighbours = new ArrayList<>();
                neighbours.add(List.of(r+1, c));
                neighbours.add(List.of(r-1, c));
                neighbours.add(List.of(r, c+1));
                neighbours.add(List.of(r, c-1));


                for(int i=0; i<neighbours.size(); i++) {
                    List<Integer> n = neighbours.get(i);
                    int nr = n.get(0);
                    int nc = n.get(1);
                    if( nr< 0 || nc < 0 || nr == ROW || nc == COL || grid[nr][nc] == 1 || visited[nr][nc] == 1) {
                        continue;
                    }
                    queue.add(List.of(nr,nc));
                    visited[nr][nc]=1;
                }
            }
            length++;
        }

        return -1;
    }
}
