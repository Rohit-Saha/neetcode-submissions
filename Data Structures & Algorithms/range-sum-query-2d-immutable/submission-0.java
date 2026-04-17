class NumMatrix {
    private int[][] matrix;
    private int[][] pSumRows;
    public NumMatrix(int[][] matrix) {
        this.matrix = matrix;
        int N = matrix.length;
        int M = matrix[0].length;
        pSumRows = new int[N][M];
        for(int r=0; r<N; r++) {
            pSumRows[r][0] = matrix[r][0];
            for(int c=1; c<M; c++) {
                pSumRows[r][c] = pSumRows[r][c-1] + matrix[r][c];
            }
        }

    }
    
    public int sumRegion(int row1, int col1, int row2, int col2) {
        int sum = 0;
        for(int r=row1; r<=row2; r++) {
            if(col1 == 0) {
                sum += pSumRows[r][col2];
            } else {
                sum += pSumRows[r][col2] - pSumRows[r][col1-1];
            }
        }
        return sum;
    }
}

/**
 * Your NumMatrix object will be instantiated and called as such:
 * NumMatrix obj = new NumMatrix(matrix);
 * int param_1 = obj.sumRegion(row1,col1,row2,col2);
 */