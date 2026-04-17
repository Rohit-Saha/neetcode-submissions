class MyStack {

    // private Deque<Integer> q1;
    // private Deque<Integer> q2;
    private Deque<Integer> q;

    public MyStack() {
        // this.q1 = new LinkedList<>();
        // this.q2 = new LinkedList<>();
        this.q = new LinkedList<>();
    }
    
    public void push(int x) {
        // q2.offer(x);
        // while(!q1.isEmpty()) {
        //     q2.offer(q1.poll());
        // }
        // Deque<Integer> temp = new LinkedList<>();
        // temp = q1;
        // q1 = q2;
        // q2 = temp;
        q.offer(x);
        for(int i = q.size()-1; i>0; i--) {
            q.offer(q.poll());
        }
    }
    
    public int pop() {
        return q.poll();
    }
    
    public int top() {
        return q.peek();
    }
    
    public boolean empty() {
        return q.size() == 0;
    }
}

/**
 * Your MyStack object will be instantiated and called as such:
 * MyStack obj = new MyStack();
 * obj.push(x);
 * int param_2 = obj.pop();
 * int param_3 = obj.top();
 * boolean param_4 = obj.empty();
 */