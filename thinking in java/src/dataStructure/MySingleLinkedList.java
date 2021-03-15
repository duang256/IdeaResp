package dataStructure;

public class MySingleLinkedList implements List{

    private int size;
    private Node head=new Node();
    @Override
    public int size() {
        return size;
    }

    @Override
    public Object get(int i) {
        if(i<0||i>size){
            throw new MyArrayIndexOutOfBoundsException("链表越界:"+i);
        }
        Node p=head;
        for(int j=0;j<i+1;j++){
            p=p.next;
        }
        return p.data;
    }

    @Override
    public boolean isEmpty() {
        return size==0;
    }

    @Override
    public boolean contains(Object o) {
        return false;
    }

    @Override
    public int indexOf(Object o) {
        return 0;
    }

    @Override
    public void add(int i, Object o) {
        if(i<0||i>size){
            throw new MyArrayIndexOutOfBoundsException("链表越界:"+i);
        }
        Node p=head;
        Node newNode=new Node(o);
        for(int j=0;j<i;j++){
            p=p.next;
        }
        newNode.next=p.next;
        p.next=newNode;
        size++;
    }

    @Override
    public void add(Object o) {
        this.add(size,o);
    }

    @Override
    public boolean addBefore(Object o, Object e) {
        return false;
    }

    @Override
    public boolean addAfter(Object o, Object e) {
        return false;
    }

    @Override
    public Object remove(int i) {
        return null;
    }

    @Override
    public boolean remove(Object o) {
        return false;
    }

    @Override
    public Object replace(int i, Object o) {
        return null;
    }

    @Override
    public String toString() {
        StringBuilder sb=new StringBuilder("[");
        for (int i=0;i<size;i++){
            sb.append(this.get(i));
            sb.append(",");
        }
        if(sb.length()==1) {
            sb.append("]");
        }else{
            sb.setCharAt(sb.length()-1,']');
        }
        return sb.toString();

    }
}
