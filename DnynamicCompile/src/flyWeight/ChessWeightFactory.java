package flyWeight;

import java.util.HashMap;
import java.util.Map;

public class ChessWeightFactory  {
    //享元池对象   同一个颜色只能有一个对象
    private static Map<String ,ChessFlyWeight>map=new HashMap<>();
    public static ChessFlyWeight getChess(String color){
        if(map.get(color)!=null){
            return map.get(color);
        }else{
            ChessFlyWeight cfw=new ConcreteChess(color);
            map.put(color,cfw);
            return cfw;
        }
    }
}
