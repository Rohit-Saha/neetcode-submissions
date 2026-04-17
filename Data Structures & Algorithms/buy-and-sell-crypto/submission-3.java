class Solution {
    public int maxProfit(int[] prices) {
        int max = 0;

        int s=0;
        int e=0;

        while(e<prices.length) {
            int p = prices[e] - prices[s];

            if(p > 0) {
                max = Math.max(max, p);
            } else {
                s = e;
            }
            e++;
        }

        return max;
    }
}
