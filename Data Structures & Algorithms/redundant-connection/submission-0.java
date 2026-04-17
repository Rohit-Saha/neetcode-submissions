class Solution {

    class UnionFind {
        private int parents[];
        private int heights[];

        public UnionFind(int n) {
            this.parents = new int[n];
            this.heights = new int[n];

            for(int i=1; i<=n; i++) {
                this.parents[i-1] = i;
            }
        }

        private int find(int x) {
            int p = this.parents[x-1];
            while(p != this.parents[p-1]) {
                this.parents[p-1] = this.parents[this.parents[p-1]-1];
                p = this.parents[p-1];
            }
            return p;
        }

        public boolean union(int x, int y) {
            int p1 = find(x);
            int p2 = find(y);

            if(p1 == p2) {
                return false;
            }

            if(this.heights[p1-1] > this.heights[p2-1]) {
                this.parents[p2-1] = p1;
            } else if(this.heights[p1-1] < this.heights[p2-1]) {
                this.parents[p1-1] = p2;
            } else {
                this.parents[p1-1] = p2;
                this.heights[p2-1] += 1;
            }
            return true;
        }
    }
    public int[] findRedundantConnection(int[][] edges) {
        int[] result = new int[2];
        UnionFind unionFind = new UnionFind(edges.length);
        for(int[] edge: edges) {
            if(!unionFind.union(edge[0], edge[1])) {
                result = edge;
                break;
            }
        }
        return result;
    }
}
