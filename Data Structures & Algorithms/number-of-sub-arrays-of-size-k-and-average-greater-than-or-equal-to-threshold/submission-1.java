class Solution {
    public int numOfSubarrays(int[] arr, int k, int threshold) {
        int count=0;
        int windowSum = 0;

        for(int i=0; i< k-1; i++) {
            windowSum += arr[i];
        } 

        for(int l=0; l <= arr.length-k ; l++) {
            windowSum += arr[l+k-1];

            if(windowSum / k >= threshold) {
                count++;
            }
            windowSum -= arr[l];
        }

        return count;
    }
}