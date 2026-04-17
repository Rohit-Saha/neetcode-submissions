/*
Definition for a Node.
class Node {
    public int val;
    public List<Node> neighbors;
    public Node() {
        val = 0;
        neighbors = new ArrayList<Node>();
    }
    public Node(int _val) {
        val = _val;
        neighbors = new ArrayList<Node>();
    }
    public Node(int _val, ArrayList<Node> _neighbors) {
        val = _val;
        neighbors = _neighbors;
    }
}
*/

class Solution {
    public Node cloneGraph(Node node) {

        Deque<Node> queue = new LinkedList<>();
        Map<Integer, Node> visited = new HashMap<>();
        if(node == null) {
            return null;
        }
        Node root = new Node(node.val, new ArrayList<>(node.neighbors));

        queue.offer(root);
        visited.put(root.val, root);

        while(queue.size() > 0) {
            for(int l=queue.size(); l>0; l--) {
                Node currentNode = queue.poll();

                List<Node> neighbours = currentNode.neighbors;
                List<Node> newNeighbours = new ArrayList<>();
                for(Node n: neighbours) {
                    
                    if(!visited.containsKey(n.val)) {
                        Node newNode = new Node(n.val, new ArrayList<>(n.neighbors));
                        newNeighbours.add(newNode);
                        queue.offer(newNode);
                        visited.put(newNode.val, newNode);
                    } else {
                        newNeighbours.add(visited.get(n.val));
                    }
                    
                }
                
                currentNode.neighbors = newNeighbours;
                System.out.println(currentNode.val +" " + currentNode.neighbors);

            }
        }

        return root;
        
    }
}