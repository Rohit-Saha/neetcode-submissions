class Solution {
    public int orangesRotting(int[][] grid) {
        int ROW = grid.length;
        int COL = grid[0].length;
        Deque<List<Integer>> rotten = new LinkedList<>();
        int[][] visited = new int[ROW][COL];
        int fresh = 0;
        for(int r=0; r<ROW; r++) {
            for(int c=0; c<COL; c++) {
                if(grid[r][c] == 2) {
                    rotten.offer(List.of(r,c));
                    visited[r][c] = 1;
                } else if(grid[r][c] == 1) {
                    fresh++;
                }
            }
        }

        if(rotten.size() == 0 && fresh == 0) {
            return 0;
        }

        int minutesElapsed = -1;

        while(rotten.size() > 0) {
            for(int l=rotten.size(); l>0; l--) {
                List<Integer> rot = rotten.poll();
                int r=rot.get(0);
                int c = rot.get(1);

                List<List<Integer>> neighbours = new ArrayList<>();
                neighbours.add(List.of(r+1, c));
                neighbours.add(List.of(r-1, c));
                neighbours.add(List.of(r, c+1));
                neighbours.add(List.of(r, c-1));

                for(int i=0; i<neighbours.size(); i++) {
                    List<Integer> n = neighbours.get(i);
                    int nr = n.get(0);
                    int nc = n.get(1);

                    if(nr<0 || nc<0 || nr==ROW || nc==COL || grid[nr][nc] != 1 || visited[nr][nc] == 1) {
                        continue;
                    }

                    rotten.offer(List.of(nr, nc));
                    visited[nr][nc] = 1;
                    grid[nr][nc] = 2;
                }
            }
            minutesElapsed++;
        }

        for(int r=0; r<ROW; r++) {
            for(int c=0; c<COL; c++) {
                if(grid[r][c] == 1) {
                    return -1;
                }
            }
        }

        return minutesElapsed;


    }
}
