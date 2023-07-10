package softeer2nd.chess.pieces;

public class Blank extends Piece{

    private Blank(){
        super();
    }

    public static Piece create(){
        return new Blank();
    }
}
