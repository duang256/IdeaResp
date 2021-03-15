package flyWeight;

import java.security.cert.CertificateFactory;

public class Demo01 {
    public static void main(String[] args) {
        ChessFlyWeight chess= ChessWeightFactory.getChess("黑色");
        ChessFlyWeight chess2= ChessWeightFactory.getChess("黑色");
        System.out.println(chess);
        System.out.println(chess2);
        //
        chess.display(new Coordinate(10,10));
        chess2.display(new Coordinate(20,20));

    }
}
