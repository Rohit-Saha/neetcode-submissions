// Definition for a pair
// class Pair {
//     int key;
//     String value;
//
//     Pair(int key, String value) {
//         this.key = key;
//         this.value = value;
//     }
// }
public class Solution {
    public List<List<Pair>> insertionSort(List<Pair> pairs) {
        int N = pairs.size();
        List<List<Pair>> output = new ArrayList<>();
        if(pairs.size() > 0) {
            output.add(addPair(pairs));
        }
        

        for(int i=1; i<N; i++) {
            int j=i-1;

            while(j>=0 && (pairs.get(j+1).key < pairs.get(j).key)) {
                Pair temp = pairs.get(j);
                pairs.set(j, pairs.get(j+1));
                pairs.set(j+1, temp);
                j--;
            }
            output.add(addPair(pairs));
        }
        return output;
    }

    private List<Pair> addPair(List<Pair> pairs) {
        List<Pair> output = new ArrayList<>();
        for(Pair pair: pairs) {
            output.add(pair);
        }
        return output;
    }
}
