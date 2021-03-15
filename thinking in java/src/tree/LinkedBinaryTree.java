package tree;

import com.sun.jmx.snmp.SnmpNull;

import java.util.Deque;
import java.util.LinkedList;
import java.util.Queue;

public class LinkedBinaryTree implements BinaryTree {
    //外部构建好树，传入根，内部就可以对这个树进行遍历
    private Node root;

    public LinkedBinaryTree(Node root) {
        this.root = root;
    }

    public LinkedBinaryTree() {
    }

    @Override
    public boolean isEmpty() {
        return root==null;
    }

    //节点的数量
    @Override
    public int size() {
        return size(root);
    }
    public int size(Node node) {
       if(node!=null){
           int nl=size(node.leftChild);
           int nr=size(node.rightChild);
           return nl+nr+1;
       }
       return 0;
    }

    //二叉树的深度
    @Override
    public int getHeight() {
        return getHeight(root);
    }
    public int getHeight(Node node) {
       if(node!=null){
           int nl=getHeight(node.leftChild);
           int nr=getHeight(node.rightChild);
           return nl>nr?nl+1:nr+1;
       }
       return 0;
    }

    @Override
    public Node findKey(int value) {
            return findKey(value,root);
    }

    public Node findKey(Object value,Node node) {
       if(node==null){
           return null;
       }else if(node.value==value){
           return node;
       }else{
           Node left=findKey(value,node.leftChild);
           Node right=findKey(value,node.rightChild);
           if(left!=null&&left.value==value){
               return left;
           }else if(right!=null&&right.value==value){
               return right;
           }else{
               return null;
           }
       }

    }




    @Override
    public void preOrderTraverse() {
        System.out.println("先序排列");
        preOrderTraverse(root);
        System.out.println("");
    }
    public void preOrderTraverse(Node node) {
        if(node!=null){
            System.out.print(node.value+"  ");
            preOrderTraverse(node.leftChild);
            preOrderTraverse(node.rightChild);
        }
    }

    @Override
    public void inOrderTraverse() {
        System.out.println("中序排列");
        inOrderTraverse(root);
        System.out.println("");
    }

    public void inOrderTraverse(Node node) {
       if(node!=null){
           inOrderTraverse(node.leftChild);
           System.out.print(node.value+"  ");
           inOrderTraverse(node.rightChild);
       }
    }
    @Override
    public void postOrderTraverse() {
        System.out.println("后序排列");
        this.postOrderTraverse(root);
        System.out.println("");
    }

    @Override
    public void postOrderTraverse(Node node) {
       if(node!=null){
           postOrderTraverse(node.leftChild);
           postOrderTraverse(node.rightChild);
           System.out.print(node.value+"  ");
       }
    }

   //遍历非递归需要用栈（双端队列接口LinkedList实现）
    @Override
    public void inOrderByStack() {
        System.out.println("中序排列:");
        if(root==null)return;
        Deque deque=new LinkedList();
        Node p=root;
        while(p!=null||!deque.isEmpty()){
            while(p!=null){
                deque.push(p);
                p=p.leftChild;
            }
            Node temp= (Node) deque.poll();
                System.out.print(temp.value+"  ");
                if(temp.rightChild!=null){
                    p=temp.rightChild;
                }
        }


        System.out.println();
    }

    //先序遍历
    @Override
    public void preOrderByStack() {
        System.out.println("先序排列:");
       if(root==null)return;

       Deque deque=new LinkedList();
       deque.push(root);
       while(!deque.isEmpty()){
           Node p= (Node) deque.poll();
           System.out.print(p.value+"  ");
           if(p.rightChild!=null){
               deque.push(p.rightChild);
           }
           if(p.leftChild!=null){
               deque.push(p.leftChild);
           }
       }
        System.out.println();
    }

    @Override
    public void postOrderByStack() {
        System.out.println("后序遍历:");
        Deque deque1=new LinkedList();
        Deque deque2=new LinkedList();
        deque1.push(root);
        while(!deque1.isEmpty()){
            Node p= (Node) deque1.poll();
            deque2.push(p);
            if(p.leftChild!=null){
                deque1.push(p.leftChild);
            }
            if(p.rightChild!=null){
                deque1.push(p.rightChild);
            }
        }
        while(!deque2.isEmpty()){
            Node temp= (Node) deque2.poll();
            System.out.print(temp.value+"  ");
        }
        System.out.println();
    }
    //按层次遍历
    @Override
    public void levelOrderByStack(){
        System.out.println("层级排序:");
        Queue queue=new LinkedList();
        queue.add(root);
        while(!queue.isEmpty()){
            int size=queue.size();
            for(int i=0;i<size;i++){
                Node temp= (Node) queue.poll();
                System.out.print(temp.value+"  ");
                if(temp.leftChild!=null){queue.add(temp.leftChild);}
                if(temp.rightChild!=null){queue.add(temp.rightChild);}
            }
        }
        System.out.println();
    }
}
