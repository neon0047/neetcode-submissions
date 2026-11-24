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
        if(node == null) return null;
        Node copyNode = new Node(node.val);
        HashMap<Integer, Node> hm = new HashMap();
        hm.put(node.val, copyNode);
        dfs(node, copyNode, hm);
        return copyNode;
    }
    public void dfs(Node node, Node copyNode, HashMap<Integer, Node> hm){
        for(Node nbr: node.neighbors){
            if(hm.containsKey(nbr.val)){
                copyNode.neighbors.add(hm.get(nbr.val));
            }else{
                Node nbrCopy = new Node(nbr.val);
                copyNode.neighbors.add(nbrCopy);
                hm.put(nbrCopy.val, nbrCopy);
                dfs(nbr, nbrCopy, hm);
            }
        }
    }
}