class Solution {
    public int[][] kClosest(int[][] points, int k) {
        List<List<Integer>> heap = new ArrayList<>();

        for(int i=0; i< points.length; i++) {
            List<Integer> p = new ArrayList<>();
            p.add(points[i][0]);
            p.add(points[i][1]);
            insertHeap(heap, p);

            if(heap.size() > k) {
                getMax(heap);
            }
        }
        // System.out.println(heap);
        int[][] kthPoints = new int[heap.size()][2];
        int i=0;
        while(heap.size() > 0) {
            List<Integer> p = getMax(heap);
            int[] point = new int[2];
            point[0] = p.get(0);
            point[1] = p.get(1);
            kthPoints[i] = point;
            i++;
        }
        return kthPoints;

    }

    private List<Integer> getMax(List<List<Integer>> heap) {
        List<Integer> max = heap.get(0);
        heap.set(0, heap.get(heap.size()-1));
        heap.remove(heap.size()-1);
        heapify(heap, 0);
        return max;
    }

    private void insertHeap(List<List<Integer>> heap, List<Integer> point) {
        heap.add(point);

        int i = heap.size()-1;

        while(i > 0) {
            int p = (i-1)/2;
            if(compare(heap.get(p), heap.get(i)) > 0) {
                break;
            } else {
                swap(heap, p, i);
            }
            i=p;
        }
    }

    private void heapify(List<List<Integer>> heap, int i) {
        while(2*i+1 < heap.size()) {
            List<Integer> leftChild = heap.get(2*i+1);
            List<Integer> rightChild = null;
            if(2*i+2 < heap.size()) {
                rightChild = heap.get(2*i+2);
            }
            List<Integer> max = maxPoint(leftChild, rightChild);

            if(compare(heap.get(i), max) > 0) {
                break;
            } else if(compare(leftChild, rightChild) > 0) {
                swap(heap, i, 2*i+1);
                i = 2*i+1;
            } else {
                swap(heap, i, 2*i+2);
                i=2*i+2;
            }
        }
    }

    private List<Integer> maxPoint(List<Integer> p1, List<Integer> p2) {
        if(p2 == null) return p1;
        double d1 = Math.sqrt(Math.pow(p1.get(0), 2)+Math.pow(p1.get(1), 2));
        double d2 = Math.sqrt(Math.pow(p2.get(0), 2)+Math.pow(p2.get(1), 2));

        if(d1 > d2) {
            return p1;
        } else {
            return p2;
        }
    }

    private int compare(List<Integer> p1, List<Integer> p2) {
        if(p2 == null) return 1;
        double d1 = Math.sqrt(Math.pow(p1.get(0), 2)+Math.pow(p1.get(1), 2));
        double d2 = Math.sqrt(Math.pow(p2.get(0), 2)+Math.pow(p2.get(1), 2));

        if(d1 < d2) {
            return -1;
        } else if(d1 > d2){
            return 1;
        } else {
            return 0;
        }
    }

    private void swap(List<List<Integer>> heap, int i, int j) {
        List<Integer> temp = heap.get(i);
        heap.set(i, heap.get(j));
        heap.set(j, temp);
    }
}
