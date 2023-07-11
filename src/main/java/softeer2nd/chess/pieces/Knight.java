package softeer2nd.chess.pieces;

import softeer2nd.chess.Position;
import softeer2nd.chess.exception.InvalidDirectionException;

public class Knight extends Piece {
    private Knight(Color color) {
        super(color, Type.KNIGHT, Direction.knightDirection());
    }

    public static Piece createWhite() {
        return new Knight(Color.WHITE);
    }

    public static Piece createBlack() {
        return new Knight(Color.BLACK);
    }

    @Override
    public void checkPieceMove(Position sourcePosition, Position targetPosition) throws InvalidDirectionException {

        Position degrees = Position.getDirection(sourcePosition, targetPosition);

        checkNonSliding(degrees.getX(), degrees.getY(), getRepresentation());
    }
}
