class LRUCache {

    class Node {
        int key;
        int value;
        Node prev;
        Node next;

        public Node(int key, int value) {
            this.key = key;
            this.value = value;
            this.prev = null;
            this.next = null;
        }
    }

    private HashMap<Integer, Node> cache;
    private int capacity;
    private Node left;
    private Node right;

    

    public LRUCache(int capacity) {
        this.capacity = capacity;
        this.cache = new HashMap<>();
        this.left = new Node(0, 0);
        this.right = new Node(0, 0);
        this.left.next = this.right;
        this.right.prev = this.left;
    }

    private void insert(Node node) {
        Node prev = this.right.prev;
        prev.next = node;
        node.prev = prev;
        node.next = this.right;
        this.right.prev = node;
    }

    private void remove(Node node) {
        Node prev = node.prev;
        Node next = node.next;
        prev.next = next;
        next.prev = prev;
    }
    
    public int get(int key) {
        if(!this.cache.containsKey(key)) {
            return -1;
        }
        
        Node node = this.cache.get(key);
        remove(node);
        insert(node);
        return node.value;
    }
    
    public void put(int key, int value) {
        if(this.cache.containsKey(key)) {
            remove(this.cache.get(key));
        }

        Node newNode = new Node(key, value);
        this.cache.put(key, newNode);
        insert(newNode);

        if(this.cache.size() > this.capacity) {
            Node lru = this.left.next;
            remove(lru);
            this.cache.remove(lru.key);
        }
    }
}
