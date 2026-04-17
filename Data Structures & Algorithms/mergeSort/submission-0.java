// Definition for a pair.
// class Pair {
//     public int key;
//     public String value;
//
//     public Pair(int key, String value) {
//         this.key = key;
//         this.value = value;
//     }
// }
class Solution {
    public List<Pair> mergeSort(List<Pair> pairs) {
        return mergeSort(pairs, 0, pairs.size()-1);
    }

    private List<Pair> mergeSort(List<Pair> pairs, int s, int e) {
        if(e-s+1 <=1) {
            return pairs;
        }

        int m = (s+e)/2;

        mergeSort(pairs, s, m);
        mergeSort(pairs, m+1, e);

        merge(pairs, s, m, e);

        return pairs;
        
    }

    private void merge(List<Pair> pairs, int s, int m, int e) {
        List<Pair> tempArr = new ArrayList<>();
        int i=s;
        int j=m+1;
        while(i<=m && j<=e) {
            if(pairs.get(i).key <= pairs.get(j).key) {
                tempArr.add(pairs.get(i));
                i++;
            } else {
                tempArr.add(pairs.get(j));
                j++;
            }
        }

        while(i<=m) {
            tempArr.add(pairs.get(i));
            i++;
        }
        while(j<=e) {
            tempArr.add(pairs.get(j));
            j++;
        }

        for(int k=s; k<=e; k++) {
            pairs.set(k, tempArr.get(k-s));
        }
    }

}
