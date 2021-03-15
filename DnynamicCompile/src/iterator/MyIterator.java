package iterator;

//迭代器底层实现
public interface MyIterator {
        void first();    //将游标指向第一个
        void next();       //将游标指向下一个
        boolean hasNext();  //判断是否存在下一个

        boolean isFirst();
        boolean isLast();

        Object getCurrentObj();  //获得当前游标对象
}
