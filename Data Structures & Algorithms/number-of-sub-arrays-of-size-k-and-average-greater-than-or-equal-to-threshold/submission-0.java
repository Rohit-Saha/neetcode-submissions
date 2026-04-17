class Solution {
    public int numOfSubarrays(int[] arr, int k, int threshold) {
        int count=0;
        int windowSum = 0;

        int l=0;
        int r=0;
        int avg = 0;

        while(r-l < k) {
            windowSum += arr[r];
            r++;
        }

        avg = windowSum /k;

        if(avg >= threshold) {
            count++;
        }
    

        while(r < arr.length) {
            windowSum -= arr[l];
            windowSum += arr[r];

            avg = windowSum / k;

            if(avg >= threshold) {
                count++;
            }
            l++;
            r++;
        }

        return count;
    }
}