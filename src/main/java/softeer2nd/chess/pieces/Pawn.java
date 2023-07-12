package softeer2nd.chess.pieces;

import softeer2nd.chess.Position;
import softeer2nd.chess.exception.InvalidDirectionException;

import java.util.List;

public class Pawn extends Piece {

    private Pawn(Color color, List<Direction> directions) {
        super(color, Type.PAWN, directions);
    }

    public static Piece createWhite() {
        return new Pawn(Color.WHITE, Direction.whitePawnDirection());
    }

    public static Piece createBlack() {
        return new Pawn(Color.BLACK, Direction.blackPawnDirection());
    }

    @Override
    public void checkPieceMove(Position sourcePosition, Position targetPosition) throws InvalidDirectionException {
        checkNonSliding(Position.getDirection(sourcePosition, targetPosition), getRepresentation());
    }
}
