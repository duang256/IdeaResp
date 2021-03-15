package composite;

import java.util.ArrayList;
import java.util.List;

public interface Component {
    void operation();
}


class Leaf implements Component{
    private String name;

    public Leaf(String name) {
        this.name = name;
    }

    @Override
    public void operation() {
        System.out.println("叶子"+name);
    }
}

class Leaf2 implements Component{
    private String name;

    public Leaf2(String name) {
        this.name = name;
    }

    @Override
    public void operation() {
        System.out.println("叶子"+name);
    }
}
class Leaf3 implements Component{
    private String name;

    public Leaf3(String name) {
        this.name = name;
    }

    @Override
    public void operation() {
        System.out.println("叶子"+name);
    }
}



//容器
class Holder implements Component {
    private String name;
    //装 子节点
    private List<Component> list=new ArrayList<>();

    public Holder(String name) {
        this.name = name;
    }

    public void add(Component component){
        list.add(component);
    }
    public void remove(Component component){
        list.remove(component);
    }
    public Component getChild(int index){
        return list.get(index);
    }
    @Override
    public void operation() {
        System.out.println("容器"+" "+name);
        for (Component c:list
             ) {
            c.operation();
        }
    }
}