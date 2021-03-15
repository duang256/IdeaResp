package tree;

public class Node {
     Object value;
      Node leftChild;
      Node rightChild;

    public Node( Node leftChild,Object value, Node rightChild) {
        this.leftChild = leftChild;
        this.value = value;
        this.rightChild = rightChild;
    }

    public Node(Object value) {
        this.value = value;
    }

    @Override
    public String toString() {
        return "Node{" +
                "value=" + value +
                ", leftChild=" + leftChild +
                ", rightChild=" + rightChild +
                '}';
    }
}
