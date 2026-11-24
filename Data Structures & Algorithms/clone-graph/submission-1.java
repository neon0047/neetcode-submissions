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
        HashMap<Integer, Node> hm = new HashMap<>();
        Queue<Node[]> q = new LinkedList();
        Node copyNode = new Node(node.val);
        q.offer(new Node[]{node, copyNode});
        while(!q.isEmpty()){
            Node[] n = q.poll();
            for(Node nbr: n[0].neighbors){
                if(hm.containsKey(nbr.val)){
                    n[1].neighbors.add(hm.get(nbr.val));
                }else{
                    Node copyNbr = new Node(nbr.val);
                    n[1].neighbors.add(copyNbr);
                    q.offer(new Node[]{nbr, copyNbr});
                    hm.put(copyNbr.val, copyNbr);
                }
            }
        }
        return copyNode;
    }
}