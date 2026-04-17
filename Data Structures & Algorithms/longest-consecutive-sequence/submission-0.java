class Solution {
    public int longestConsecutive(int[] nums) {

        HashSet<Integer> hash = new HashSet<>();
        int N = nums.length;

        for(int i=0; i<N; i++) {
            hash.add(nums[i]);
        } 

        int longestSeq = 0;

        for(int i=0; i<N; i++) {
            int num = nums[i];
            int seqLength = 1;
            if(!hash.contains(num-1)) { //checking for start of a sequence
                int currSeq = num;
                while(hash.contains(currSeq+1)){
                    seqLength++;
                    currSeq++;
                }
            }

            if(seqLength > longestSeq) {
                longestSeq = seqLength;
            }
        }

        return longestSeq;
        
    }
}
