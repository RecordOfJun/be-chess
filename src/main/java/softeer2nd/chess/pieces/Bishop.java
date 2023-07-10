package softeer2nd.chess.pieces;

public class Bishop extends Piece{

    private Bishop(Color color){
        super(color,Type.BISHOP);
    }

    public static Piece createWhite(){
        return new Bishop(Color.WHITE);
    }

    public static Piece createBlack(){
        return new Bishop(Color.BLACK);
    }
}
