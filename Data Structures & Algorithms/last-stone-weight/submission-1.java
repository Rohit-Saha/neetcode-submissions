class Solution {
    public int lastStoneWeight(int[] stones) {
        List<Integer> heap = new ArrayList<>();
        for(int i=0; i<stones.length; i++) {
            heap.add(stones[i]);
        }
        int i = heap.size()/2;

        while(i >= 0) {
            heapify(heap, i);
            i--;
        }

        while(heap.size() > 1) {
            int x = getMax(heap);
            int y = getMax(heap);

            if(x > y){
                insertHeap(heap, x-y);
            }
        }

        if(heap.size() > 0) {
            return heap.get(0);
        }

        return 0;
    }

    private void heapify(List<Integer> heap, int i) {
        while(2*i+1 < heap.size()) {
            int leftChild = heap.get(2*i+1);
            int rightChild = Integer.MIN_VALUE;
            if(2*i+2 < heap.size()) {
                rightChild = heap.get(2*i+2);
            }
            int max = Math.max(leftChild, rightChild);

            if(heap.get(i) > max) {
                break;
            } else if(leftChild > rightChild) {
                swap(heap, i, 2*i+1);
                i = 2*i+1;
            } else {
                swap(heap, i, 2*i+2);
                i = 2*i+2;
            }
        }
    }

    private void swap(List<Integer> list, int i, int j) {
        int temp = list.get(i);
        list.set(i, list.get(j));
        list.set(j, temp);
    }

    private int getMax(List<Integer> heap) {
        int max = heap.get(0);
        heap.set(0, heap.get(heap.size()-1));
        heap.remove(heap.size()-1);
        heapify(heap, 0);
        return max;
    }

    private void insertHeap(List<Integer> heap, int val) {
        heap.add(val);
        int i = heap.size()-1;

        while(i>0) {
            int p = (i-1)/2;
            if(heap.get(p) > heap.get(i)) {
                break;
            } else {
                swap(heap, p, i);
            }
            i = p;
        }
    }
}
