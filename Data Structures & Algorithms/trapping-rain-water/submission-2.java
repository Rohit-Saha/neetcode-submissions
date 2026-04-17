class Solution {
    public int trap(int[] height) {
        int N = height.length;
        int[] lmax = new int[N];
        int[] rmax = new int[N];
        lmax[0] = height[0];
        for(int i=1; i<N; i++) {
            lmax[i] = Math.max(lmax[i-1], height[i]);
        }

        rmax[N-1] = height[N-1];

        for(int i=N-2; i>=0; i--) {
            rmax[i] = Math.max(rmax[i+1], height[i]);
        }
        int total = 0;
        for(int i=0; i<N; i++) {
            total += Math.min(lmax[i], rmax[i]) - height[i];
        }
        return total;
    }
}
