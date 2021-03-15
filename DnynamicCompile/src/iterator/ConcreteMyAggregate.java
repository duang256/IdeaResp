package iterator;

import java.util.ArrayList;
import java.util.List;

public class ConcreteMyAggregate {
    List<Object>list=new ArrayList();
    public void addObj(Object object){
        this.list.add(object);
    }
    public void removeObj(Object object){
        this.list.remove(object);
    }
    public  List<Object>getList(){
        return list;
    }


    //获得迭代器
    public MyIterator createIterator(){
        return new ConcreteItetator();
    }

    private class ConcreteItetator implements MyIterator{

        private int cursor;
        @Override
        public void first() {
            cursor=0;
        }

        @Override
        public void next() {
            cursor++;
        }

        @Override
        public boolean hasNext() {
            return cursor<(list.size())?true:false;
        }

        @Override
        public boolean isFirst() {
            return cursor==(list.size()-1)?true:false;
        }

        @Override
        public boolean isLast() {
            return cursor==(list.size()-1)?true:false;
        }

        @Override
        public Object getCurrentObj() {
            return list.get(cursor);
        }
    }


}
