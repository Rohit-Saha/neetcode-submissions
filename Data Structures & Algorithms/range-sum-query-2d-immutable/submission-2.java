class NumMatrix {
    private int[][] matrix;
    private int[][] pSumMatrix;
    public NumMatrix(int[][] matrix) {
        this.matrix = matrix;
        int N = matrix.length;
        int M = matrix[0].length;
        pSumMatrix = new int[N+1][M+1];
        
        for(int r=0; r<N; r++) {
            int prefix = 0;
            for(int c=0; c<M; c++) {
                prefix += matrix[r][c];
                int above = pSumMatrix[r][c+1];
                pSumMatrix[r+1][c+1] = prefix + above;
            }
        }

    }
    
    public int sumRegion(int row1, int col1, int row2, int col2) {
        int bottomRight = pSumMatrix[row2+1][col2+1];
        int above = pSumMatrix[row1][col2+1];
        int left = pSumMatrix[row2+1][col1];
        int topLeft = pSumMatrix[row1][col1];

        return bottomRight - above - left + topLeft;
    }
}

/**
 * Your NumMatrix object will be instantiated and called as such:
 * NumMatrix obj = new NumMatrix(matrix);
 * int param_1 = obj.sumRegion(row1,col1,row2,col2);
 */