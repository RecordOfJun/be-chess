package softeer2nd.chess.pieces;

public class Pawn extends Piece{

    private Pawn(Color color){
        super(color,Type.PAWN);
    }

    public static Piece createWhite(){
        return new Pawn(Color.WHITE);
    }

    public static Piece createBlack(){
        return new Pawn(Color.BLACK);
    }
}
