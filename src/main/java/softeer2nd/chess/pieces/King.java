package softeer2nd.chess.pieces;

public class King extends Piece{

    private King(Color color){
        super(color,Type.KING);
    }

    public static Piece createWhite(){
        return new King(Color.WHITE);
    }

    public static Piece createBlack(){
        return new King(Color.BLACK);
    }
}
