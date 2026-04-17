class Solution {
    public int minEatingSpeed(int[] piles, int h) {
        Arrays.sort(piles);

        int L = 1;
        int R = piles[piles.length-1];
        int minRate = Integer.MAX_VALUE;

        while(L <= R) {
            int mid = L + (R-L)/2;

            boolean isValid = canFinishWithinTime(piles, mid, h);

            if(isValid) {
                R = mid-1;
                minRate = Math.min(minRate, mid);
            } else {
                L = mid+1;
            }

        }
        return minRate;
    }

    private boolean canFinishWithinTime(int[] piles, int rate, int h) {
        int time = 0;

        for(int i=0; i<piles.length; i++) {
            time += Math.ceil((piles[i] * 1.0)/rate);
        }

        return time <= h;
    }
}
