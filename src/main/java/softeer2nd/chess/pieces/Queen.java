package softeer2nd.chess.pieces;

public class Queen extends Piece{

    private Queen(Color color){
        super(color,Type.QUEEN);
    }

    public static Piece createWhite(){
        return new Queen(Color.WHITE);
    }

    public static Piece createBlack(){
        return new Queen(Color.BLACK);
    }
}
