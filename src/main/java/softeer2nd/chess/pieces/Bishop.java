package softeer2nd.chess.pieces;

import softeer2nd.chess.exception.InvalidDirectionException;
import softeer2nd.chess.exception.InvalidPositionException;
import softeer2nd.chess.utils.PositionUtils;

import java.util.Map;

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
    public void checkPieceMove(String sourcePosition, String targetPosition) throws InvalidDirectionException, InvalidPositionException {

        Map<String, Integer> degrees = PositionUtils.getDirection(sourcePosition, targetPosition);

        checkSliding(degrees.get("xDegree"), degrees.get("yDegree"), getRepresentation());
    }
}
