class Solution {
    public int canCompleteCircuit(int[] gas, int[] cost) {
        int totalGas = 0;
        int totalCost = 0;

        for(int i=0; i<gas.length; i++) {
            totalGas += gas[i];
            totalCost += cost[i];
        }

        if(totalGas < totalCost) {
            return -1;
        }

        int start = 0;
        int total = 0;
        int i = start;
        
        while(true) {
            total += gas[i]-cost[i];
            i = (i+1)%gas.length;
            if(total < 0) {
                start = i;
                total = 0;
            }else if(i == start) {
                break;
            }

        }

        return start;
    }
}
