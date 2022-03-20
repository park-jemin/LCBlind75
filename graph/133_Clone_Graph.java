// https://leetcode.com/problems/clone-graph/



/*	
	Time complexity: O(V + E)

	Space complexity: O(V)

	V = # nodes, E = # edges
*/



/*
// Definition for a Node.
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

// bottom up dp approach
// BFS, iterative
class Solution {
    public Node cloneGraph(Node node) {
        if (node == null)
            return node;
        
        Node[] copy = new Node[101];
        
        Queue<Node> nodeQueue = new LinkedList<>();

        copy[node.val] = new Node(node.val);
        nodeQueue.offer(node);
        
        while (!nodeQueue.isEmpty()) {
            Node curr = nodeQueue.poll();
            
            for (Node neighbor : curr.neighbors) {
                
                Node newCopy = copy[neighbor.val];
                
                if (copy[neighbor.val] == null) {
                    copy[neighbor.val] = neighbor;
                    nodeQueue.add(neighbor);
                    
                    newCopy = new Node(neighbor.val);
                    copy[neighbor.val] = newCopy;
                }
                
                copy[curr.val].neighbors.add(newCopy);
            }
            
        }       
        
        return copy[1];
    }
}


// top-down memoization
// DFS, recursive
class Solution2 {

	private Map<Integer, Node> copyMap;
    
    public Node cloneGraph(Node node) {
        if (node == null)
            return node;
        
        copyMap = new HashMap<>(100);
        return clone(node);
    }
    
    private Node clone(Node node) {
        if (copyMap.containsKey(node.val))
            return copyMap.get(node.val);    
        
        
        Node copy = new Node(node.val);
        copyMap.put(node.val, copy);
        
        for (Node neighbor : node.neighbors) {
            copy.neighbors.add(clone(neighbor));
        }
        
        return copy;
    }
}