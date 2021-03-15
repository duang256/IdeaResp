package dataStructure;

import java.util.Arrays;

//顺序表
//底层采用数组，长度可以动态变化
public class ArrayList implements List{

    private Object[] elementData;
    private int size;//不是数组分配的空间，是元素的个数

    //数组的初始长度
    public ArrayList(int initialCapacity) {
        //给数组分配空间
        elementData=new Object[initialCapacity];
    }
    //空构造也必须要new elementData,不然就空指针
    //这里也可以new一个空数组（JDK做法）只是一开始就要扩容
    //这里设置初始就为4
    public ArrayList() {
        this(4);
    }


    @Override
    public int size() {
        return size;
    }

    @Override
    public Object get(int i) {
        if(i<0||i>size-1){
            throw new MyArrayIndexOutOfBoundsException("数组越界:"+i);
        }
        return elementData[i];
    }

    @Override
    public boolean isEmpty() {
        return size==0;
    }

    @Override
    public boolean contains(Object o) {

        for(int i=0;i<size;i++){
            if(elementData[i].equals(o)){   //应该用equals而不是等于
                return true;
            }
        }
        return false;
    }

    @Override
    public int indexOf(Object o) {
       for(int i=0;i<size;i++){
           if(elementData[i].equals(o)){   //应该用equals而不是等于
               return i;
           }
       }
        return -1;//如果找不到就返回-1
    }

    @Override
    public void add(int i, Object o) {
        //因为是一个线性表，所以应该用size来衡量是否越界，而不是数组的长度，
        //而且这个地方是size而不是size-1 当size==i时，正好是没有参数的情况
        if(i<0||i>size){
            throw new MyArrayIndexOutOfBoundsException("数组越界:"+i);
        }

        if(size==elementData.length){
            elementData= Arrays.copyOf(elementData,elementData.length*2);
        }
        //整体后移
        for(int j=size;j>i;j--){
            elementData[j]=elementData[j-1];
        }
        elementData[i]=o;
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
        //因为是一个线性表，所以应该用size来衡量是否越界，而不是数组的长度，
        //而且这个地方是size而不是size-1 当size==i时，正好是没有参数的情况
        if(i<0||i>size){
            throw new MyArrayIndexOutOfBoundsException("数组越界:"+i);
        }

        Object o=elementData[i];
        //整体前移
        for(int j=i;j<size-1;j++){
            elementData[j]=elementData[j+1];
        }
        size--;
        return o;
    }

    @Override
    public boolean remove(Object o) {
        int index=this.indexOf(o);
        if(index!=-1){
            this.remove(index);
            return true;
        }
        return false;
    }

    @Override
    public Object replace(int i, Object o) {
        if(i<0||i>size){
            throw new MyArrayIndexOutOfBoundsException("数组越界:"+i);
        }
        for(int j=0;j<size;j++){
            if(i==j){
                elementData[i]=o;
            }
        }
        return null;
    }

    @Override
    public String toString() {
        StringBuilder sb=new StringBuilder("[");
        for (int i=0;i<size;i++){
            sb.append(elementData[i]);
            sb.append(",");
        }
        if(sb.length()==1){
            sb.append("]");
        }else{
            sb.setCharAt(sb.length()-1,']');
        }
        return sb.toString();
    }
}
