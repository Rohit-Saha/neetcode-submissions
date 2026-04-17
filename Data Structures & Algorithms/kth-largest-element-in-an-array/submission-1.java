class Solution {
    public int findKthLargest(int[] nums, int k) {
        List<Integer> heap = new ArrayList<>();

        for(int i=0; i<nums.length; i++) {
            insertHeap(heap, nums[i]);

            if(heap.size() > k) {
                getMin(heap);
            }
        }

        return heap.get(0);
    }

    private void insertHeap(List<Integer> heap, int val) {
        heap.add(val);

        int i = heap.size()-1;

        while(i > 0) {
            int p = (i-1)/2;

            if(heap.get(p) < heap.get(i)) {
                break;
            } else {
                swap(heap, p, i);
            }
            i=p;
        }
    }

    private int getMin(List<Integer> heap) {
        int min = heap.get(0);

        heap.set(0, heap.get(heap.size()-1));
        heap.remove(heap.size()-1);

        heapify(heap, 0);
        return min;
    }

    private void heapify(List<Integer> heap, int i) {
        while(2*i+1 < heap.size()) {
            int leftChild = heap.get(2*i+1);
            int rightChild = Integer.MAX_VALUE;

            if(2*i+2 < heap.size()) {
                rightChild = heap.get(2*i+2);
            }

            int min = Math.min(leftChild, rightChild);

            if(heap.get(i) < min) {
                break;
            } else if(leftChild < rightChild) {
                swap(heap, i, 2*i+1);
                i=2*i+1;
            } else {
                swap(heap, i, 2*i+2);
                i=2*i+2;
            }
        }
    }

    private void swap(List<Integer> heap, int i, int j) {
        int temp = heap.get(i);
        heap.set(i, heap.get(j));
        heap.set(j, temp);
    }
}
