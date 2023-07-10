package softeer2nd.chess.pieces;

public class Rook extends Piece{

    private Rook(Color color){
        super(color,Type.ROOK);
    }

    public static Piece createWhite(){
        return new Rook(Color.WHITE);
    }

    public static Piece createBlack(){
        return new Rook(Color.BLACK);
    }
}
