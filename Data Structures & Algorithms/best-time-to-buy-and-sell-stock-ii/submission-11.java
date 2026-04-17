class Solution {
    public int maxProfit(int[] prices) {
        int l=0;
        int r=1;
        int totalProfit = 0;

        while(r<prices.length) {
            
            if(prices[r] > prices[l]) {
                totalProfit += prices[r] - prices[l];
            }
            r++;
            l++;
            
        }

        return totalProfit;
    }
}