package softeer2nd.chess.pieces;

import softeer2nd.chess.Position;
import softeer2nd.chess.exception.InvalidDirectionException;

public class King extends Piece {

    private King(Color color) {
        super(color, Type.KING, Direction.everyDirection());
    }

    public static Piece createWhite() {
        return new King(Color.WHITE);
    }

    public static Piece createBlack() {
        return new King(Color.BLACK);
    }

    @Override
    public void checkPieceMove(Position sourcePosition, Position targetPosition) throws InvalidDirectionException {
        Position degrees = Position.getDirection(sourcePosition, targetPosition);

        checkNonSliding(degrees.getX(), degrees.getY(), getRepresentation());
    }
}
