package flyWeight;

//主体类   color是不变的属性，Coordinate是要变化的
public interface ChessFlyWeight {
    void setColor(String c);
    String getColor();
    void display(Coordinate c);
}



//代表一个棋子
class ConcreteChess implements ChessFlyWeight{

    private String color;
    public ConcreteChess(String color) {
        this.color = color;
    }

    @Override
    public void setColor(String c) {
        this.color=c;
    }

    @Override
    public String getColor() {
        return color;
    }

    @Override
    public void display(Coordinate c) {
        System.out.println("棋子位置"+" "+c.getX()+" "+c.getY());
    }
}