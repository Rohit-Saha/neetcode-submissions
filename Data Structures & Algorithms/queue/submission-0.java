class Deque {

    private LinkedList<Integer> dequeue;

    public Deque() {
        dequeue = new LinkedList<>();
    }

    public boolean isEmpty() {
        return dequeue.size() == 0;
    }

    public void append(int value) {
       dequeue.add(value);
    }

    public void appendleft(int value) {
        dequeue.addFirst(value);
    }

    public int pop() {
        if(dequeue.size() == 0) return -1;
        return dequeue.removeLast();
    }

    public int popleft() {
        if(dequeue.size() == 0) return -1;
        return dequeue.removeFirst();
    }
}
