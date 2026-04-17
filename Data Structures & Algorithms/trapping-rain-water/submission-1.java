class Solution {
    public int trap(int[] height) {
        int N = height.length;
        int[] lmax = new int[N];
        int[] rmax = new int[N];

        int totalVolume = 0;

        lmax[0] = height[0];
        rmax[N-1] = height[N-1];
        for(int i=1; i<N; i++) {
            lmax[i] = Math.max(lmax[i-1], height[i]);
            rmax[N-i-1] = Math.max(rmax[N-i], height[N-i-1]);
        }

        // rmax[height.length-1] = height[height.length-1];
        // for(int i=height.length-2; i>=0; i--) {
        //     rmax[i] = Math.max(rmax[i+1], height[i]);
        // }

        for(int i=0;i<height.length; i++) {
            int min = Math.min(lmax[i], rmax[i]);
            totalVolume += min-height[i];
        }
        return totalVolume;
        
    }
}
