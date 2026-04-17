class Solution {
    public int[][] insert(int[][] intervals, int[] newInterval) {
        ArrayList<ArrayList<Integer>> newIntervals = new ArrayList<>();

        int i=0;
        int new_s = newInterval[0];
        int new_e = newInterval[1];
        while(i < intervals.length) {
            int s = intervals[i][0];
            int e = intervals[i][1];

            if(e < new_s) {
                ArrayList<Integer> temp = new ArrayList<>();
                temp.add(intervals[i][0]);
                temp.add(intervals[i][1]);
                newIntervals.add(temp);
            } else if(s > new_e) {
                ArrayList<Integer> temp = new ArrayList<>();
                temp.add(new_s);
                temp.add(new_e);
                newIntervals.add(temp);
                break;
            }else {
                new_s = Math.min(new_s, s);
                new_e = Math.max(new_e, e);
            }
            i++;
        }

        if(i == intervals.length) {
            ArrayList<Integer> temp = new ArrayList<>();
            temp.add(new_s);
            temp.add(new_e);
            newIntervals.add(temp);
        }

        while(i < intervals.length) {
            ArrayList<Integer> temp = new ArrayList<>();
            temp.add(intervals[i][0]);
            temp.add(intervals[i][1]);
            newIntervals.add(temp);
            i++;
        }

        int[][] result = new int[newIntervals.size()][2];

        for(int j=0; j<newIntervals.size(); j++) {
            result[j][0] = newIntervals.get(j).get(0);
            result[j][1] = newIntervals.get(j).get(1);
        }
        return result;
    }
}
