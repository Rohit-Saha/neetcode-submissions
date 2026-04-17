// Definition for a pair.
// class Pair {
//     int key;
//     String value;
//
//     public Pair(int key, String value) {
//         this.key = key;
//         this.value = value;
//     }
// }
class Solution {
    public List<Pair> quickSort(List<Pair> pairs) {
        return quickSort(pairs, 0, pairs.size()-1);
    }

    private List<Pair> quickSort(List<Pair> pairs, int s, int e) {
        if(e-s+1 <=1) {
            return pairs;
        }

        int pivot = e;

        int l=s;
        int r=s;

        while(r<e) {
            if(pairs.get(r).key < pairs.get(pivot).key) {
                Pair temp = pairs.get(l);
                pairs.set(l, pairs.get(r));
                pairs.set(r, temp);
                l++;
            }
            r++;
        }
        Pair temp = pairs.get(l);
        pairs.set(l, pairs.get(pivot));
        pairs.set(pivot, temp);

        quickSort(pairs, s, l-1);
        quickSort(pairs, l+1, e);

        return pairs;

    }
}
