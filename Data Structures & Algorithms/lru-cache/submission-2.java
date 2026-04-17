class LRUCache {
    private Map<Integer, Integer> cache;
    private LinkedList<Integer> lru;
    private int capacity;

    public LRUCache(int capacity) {
        this.capacity = capacity;
        this.cache = new HashMap<>();
        this.lru = new LinkedList<>();
    }
    
    public int get(int key) {
        if(!this.cache.containsKey(key)) {
            return -1;
        }
        lru.removeFirstOccurrence(key);
        lru.add(key);

        return this.cache.get(key);
    }
    
    public void put(int key, int value) {
        if(!this.cache.containsKey(key)) {
            this.cache.put(key, value);
            lru.add(key);
        } else {
            this.cache.put(key, value);
            lru.removeFirstOccurrence(key);
            lru.add(key);
        }

        if(this.cache.keySet().size() > capacity) {
            int leastRUsedKey = lru.removeFirst();
            this.cache.remove(leastRUsedKey);
        }
    }
}
