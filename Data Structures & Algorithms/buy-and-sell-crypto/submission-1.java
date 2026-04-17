class Solution {
    public int maxProfit(int[] prices) {
        int l=0;
        int r =1;
        int max = 0;

        while(r<prices.length) {
            int profit = prices[r]-prices[l];

            if(profit < 0) {
                l = r;
                r++;
            } else {
                r++;
            }
            max = Math.max(max, profit);
        }
        return max;
    }
}
