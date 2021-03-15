package dataStructure;

public interface List {
    public int size();
    public Object get(int i);
    public boolean isEmpty();
    public boolean contains(Object o);
    public int indexOf(Object o);
    public void add(int i,Object o);
    public void add(Object o);
    //将o元素插入到e元素之前
    public boolean addBefore(Object o,Object e);
    public  boolean addAfter(Object o,Object e);
    //删除序号i元素，返回这个元素
    public  Object remove(int i);
    public boolean remove(Object o);
    //替换序号为i的元素
    public Object replace(int i,Object o);
}
