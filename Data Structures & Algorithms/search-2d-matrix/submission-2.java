class Solution {
    public boolean searchMatrix(int[][] matrix, int target) {
        int r = 0;
        int c = matrix[0].length-1;

        while(r < matrix.length && c >= 0) {
            if(target < matrix[r][c]) {
                c--;
            } else if(target > matrix[r][c]) {
                r++;
            } else {
                return true;
            }
        }
        return false;
    }
}
