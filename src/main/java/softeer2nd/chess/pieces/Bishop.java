package softeer2nd.chess.pieces;

import softeer2nd.chess.Position;
import softeer2nd.chess.exception.InvalidDirectionException;

public class Bishop extends Piece {

    private Bishop(Color color) {
        super(color, Type.BISHOP, Direction.diagonalDirection());
    }

    public static Piece createWhite() {
        return new Bishop(Color.WHITE);
    }

    public static Piece createBlack() {
        return new Bishop(Color.BLACK);
    }

    @Override
    public void checkPieceMove(Position sourcePosition, Position targetPosition) throws InvalidDirectionException {
        checkSliding(Position.getDirection(sourcePosition, targetPosition), getRepresentation());
    }
}
