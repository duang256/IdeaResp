package tree;

public class test {
    public static void main(String[] args) {
        Node node7=new Node(null,7,null);
        Node node6=new Node(null,6,node7);
        Node node3=new Node(null,3,null);
        Node node2=new Node(node3,2,node6);
        Node node5=new Node(null,5,null);
        Node node4=new Node(null,4,node5);
        Node node1=new Node(node4,1,node2);
        BinaryTree bt=new LinkedBinaryTree(node1);

        System.out.println(bt.size());
        System.out.println(bt.getHeight());
        System.out.println(bt.findKey(6));
        bt.preOrderTraverse();
        bt.inOrderTraverse();
        bt.postOrderTraverse();
        bt.levelOrderByStack();
        bt.preOrderByStack();
        bt.inOrderByStack();
        bt.postOrderByStack();






    }
}
