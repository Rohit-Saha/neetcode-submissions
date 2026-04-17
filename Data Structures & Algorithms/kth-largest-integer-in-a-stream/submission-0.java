class KthLargest {
    private List<Integer> heap;
    private int k;
    public KthLargest(int k, int[] nums) {
        this.k = k;
        this.heap = new ArrayList<>();
        for(int i=0; i<nums.length; i++) {
            insertHeap(nums[i]);
            maintainHeapOfSizeK();
        }

    }

    private void maintainHeapOfSizeK() {
        // System.out.println("Before:"+heap);
       if(heap.size() > k) {
        int last = heap.get(heap.size() - 1);
        heap.set(0, last);
        heap.remove(heap.size()-1);
        heapify(0);
       }
    //    System.out.println(heap);
    }

    private void insertHeap(int val) {
        heap.add(val);
        int i = heap.size()-1;

        while(i > 0) {
            int p = (i-1)/2;

            if(heap.get(p) < heap.get(i)) {
                break;
            } else {
                int temp = heap.get(p);
                heap.set(p, heap.get(i));
                heap.set(i, temp);
            }
            i = p;
        }
    }

    private void heapify(int i) {
        while((2*i+1) < heap.size()) {
            int leftChild = heap.get(2*i+1);
            int rightChild = Integer.MAX_VALUE;
            if((2*i+2) < heap.size()) {
                rightChild = heap.get(2*i+2);
            }
            int min = Math.min(leftChild, rightChild);

            if(heap.get(i) <= min) {
                break;
            } else if(leftChild < rightChild) {
                int temp = heap.get(i);
                heap.set(i, leftChild);
                heap.set(2*i+1, temp);
                i=2*i+1;
            } else {
                int temp = heap.get(i);
                heap.set(i, rightChild);
                heap.set(2*i+2, temp);
                i=2*i+2;
            }
        }
    }
    
    public int add(int val) {
        insertHeap(val);
        maintainHeapOfSizeK();
        
        return heap.get(0);
    }
}
