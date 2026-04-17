class Solution {
    public int maxArea(int[] heights) {
        

        int s = 0;
        int e = heights.length-1;
        int max = 0;
        while(s<e) {
            max = Math.max(max, (e-s) * Math.min(heights[s], heights[e]));

            if(heights[s] < heights[e]) {
                s++;
            } else {
                e--;
            }
        }

        return max;
    }
}
