class Graph {

    private Map<Integer, List<Integer>> adjacencyList;

    public Graph() {
        this.adjacencyList = new HashMap<>();
    }

    public void addEdge(int src, int dst) {
        if(!adjacencyList.containsKey(src)) {
            adjacencyList.put(src, new LinkedList<>());
        }
        if(!adjacencyList.containsKey(dst)) {
            adjacencyList.put(dst, new LinkedList<>());
        }
        
        adjacencyList.get(src).add(dst);
        System.out.println("Added"+adjacencyList);
    }

    public boolean removeEdge(int src, int dst) {
        if(adjacencyList.containsKey(src) && adjacencyList.containsKey(dst)) {
            adjacencyList.get(src).remove(new Integer(dst));
            System.out.println("Removed"+adjacencyList);
            return true;
        }
        return false;
    }

    public boolean hasPath(int src, int dst) {
        Set<Integer> visited = new HashSet<>();
        visited.add(src);
        return dfs(src, dst, visited);
    }

    private boolean dfs(int node, int target, Set<Integer> visited) {
        if(node == target) {
            return true;
        }

        List<Integer> neighbours = this.adjacencyList.get(node);
        boolean pathExist = false;
        for(int n: neighbours){
            if(!visited.contains(n)) {
                visited.add(n);
                if(dfs(n, target, visited)) {
                    pathExist = true;
                    break;
                }
            }
            
        }
        return pathExist;
    }
}
