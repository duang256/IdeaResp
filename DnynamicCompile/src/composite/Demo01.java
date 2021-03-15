package composite;

public class Demo01 {
    public static void main(String[] args) {

        Holder h1=new Holder("US");
        Holder h2=new Holder("CN");
        Leaf leaf1=new Leaf("F22");
        Leaf leaf2=new Leaf("J20");
        Leaf leaf3=new Leaf("F35");
        Leaf leaf4=new Leaf("F16");
        Leaf leaf5=new Leaf("J15");
        h1.add(leaf1);
        h1.add(leaf3);
        h1.add(leaf4);
        h2.add(leaf2);
        h2.add(leaf5);
        h1.operation();
        System.out.println("#################################");
        h2.operation();



    }
}
