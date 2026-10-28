/*
// Definition for a Node.
class Node {
    int val;
    Node next;
    Node random;

    public Node(int val) {
        this.val = val;
        this.next = null;
        this.random = null;
    }
}
*/

class Solution {
    public Node copyRandomList(Node head) {
        HashMap<Node, Node> hm = new HashMap();
        Node copy = new Node(0);
        Node main = head, dummy = copy;
        while(main != null){
            dummy.next = new Node(main.val);
            hm.put(main, dummy.next);
            main = main.next;
            dummy = dummy.next;
        }
        Node temp = copy.next, mainr = head;
        while(temp != null){
            temp.random = hm.get(mainr.random);
            temp = temp.next;
            mainr = mainr.next;
        }
        return copy.next;
    }
}
