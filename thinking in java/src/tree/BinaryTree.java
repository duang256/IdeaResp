package tree;

public interface BinaryTree {

    public boolean isEmpty();
    //节点数量
    public int size();
    //树的深度
    public int getHeight();
    public Node findKey(int value);
    //先序遍历
    public void preOrderTraverse();
    //中序遍历
    public void inOrderTraverse();
    //后序遍历
    public void postOrderTraverse();
    public void postOrderTraverse(Node node);
    //非递归遍历
    public  void  inOrderByStack();
    public void preOrderByStack();
    public void postOrderByStack();
    public void levelOrderByStack();
}
