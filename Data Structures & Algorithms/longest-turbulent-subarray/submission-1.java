class Solution {
    public int maxTurbulenceSize(int[] arr) {
        int l=0;
        int r=1;
        int globalL = 0;
        int globalR = 0;
        int maxLen = 0;

        while(l < r && r < arr.length) {

            if(r == arr.length-1 && (arr[r] < arr[r-1] || arr[r] > arr[r-1])) {
                globalR = r;
                globalL = l;
            }else if((arr[r] < arr[r-1] && arr[r] < arr[r+1]) || (arr[r] > arr[r-1] && arr[r] > arr[r+1])) {
                globalR = r+1;
                globalL = l;
            } else {
                l = r;
            }

            maxLen = Math.max(maxLen, globalR-globalL+1);
            r++;
        }

        return Math.max(maxLen, globalR-globalL+1);
    }
}