package softeer2nd.chess.pieces;

import softeer2nd.chess.Position;
import softeer2nd.chess.exception.InvalidDirectionException;

public class Rook extends Piece{

    private Rook(Color color){
        super(color,Type.ROOK,Direction.linearDirection());
    }

    public static Piece createWhite(){
        return new Rook(Color.WHITE);
    }

    public static Piece createBlack(){
        return new Rook(Color.BLACK);
    }

    @Override
    public void checkPieceMove(Position sourcePosition, Position targetPosition) throws InvalidDirectionException {

        Position degrees = Position.getDirection(sourcePosition, targetPosition);

        checkSliding(degrees.getX(), degrees.getY(), getRepresentation());
    }
}
