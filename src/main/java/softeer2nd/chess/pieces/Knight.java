package softeer2nd.chess.pieces;

public class Knight extends Piece{
    private Knight(Color color){
        super(color,Type.KNIGHT);
    }

    public static Piece createWhite(){
        return new Knight(Color.WHITE);
    }

    public static Piece createBlack(){
        return new Knight(Color.BLACK);
    }
}
