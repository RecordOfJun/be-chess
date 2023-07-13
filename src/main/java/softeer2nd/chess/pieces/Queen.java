package softeer2nd.chess.pieces;

import softeer2nd.chess.Position;
import softeer2nd.chess.exception.InvalidDirectionException;

public class Queen extends Piece {

    private Queen(Color color) {
        super(color, Type.QUEEN, Direction.everyDirection());
    }

    public static Piece createWhite() {
        return new Queen(Color.WHITE);
    }

    public static Piece createBlack() {
        return new Queen(Color.BLACK);
    }

    @Override
    public void checkPieceMove(Position sourcePosition, Position targetPosition) throws InvalidDirectionException {
        checkSliding(sourcePosition, targetPosition, getRepresentation());

    }
}
