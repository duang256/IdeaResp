package dataStructure;

public class Node {

     Object data;
     Node next;

    public Node(Object data, Node next) {
        this.data = data;
        this.next = next;
    }

    public Node(Object data) {
        this.data = data;
    }

    public Node() {
    }
}
