class UnionFind {

    private int[] parents;
    private int[] height;
    private int numComponents;

    public UnionFind(int n) {
        this.parents = new int[n];
        this.height = new int[n];
        this.numComponents = n;
        for(int i=0; i<n; i++) {
            this.parents[i] = i;
        }
    }

    public int find(int x) {
        int p = this.parents[x];

        while(p != this.parents[p]) {
            this.parents[p] = this.parents[this.parents[p]];
            p = this.parents[p];
        }
        return p;
    }

    public boolean isSameComponent(int x, int y) {
        if(find(x) == find(y)) {
            return true;
        }
        return false;
    }

    public boolean union(int x, int y) {
        int p1 = find(x);
        int p2 = find(y);

        if(isSameComponent(p1, p2)) {
            return false;
        }

        if(this.height[p1] > this.height[p2]) {
            this.parents[p2] = p1;
        } else if(this.height[p1] < this.height[p2]) {
            this.parents[p1] = p2;
        } else {
            this.parents[p1] = p2;
            this.height[p2]++;
        }
        this.numComponents--;

        return true;


    }

    public int getNumComponents() {
        return this.numComponents;
    }
}
