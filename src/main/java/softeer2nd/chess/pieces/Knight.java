package softeer2nd.chess.pieces;

import softeer2nd.chess.exception.InvalidDirectionException;
import softeer2nd.chess.exception.InvalidPositionException;
import softeer2nd.chess.utils.PositionUtils;

import java.util.Map;

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
    public void checkPieceMove(String sourcePosition, String targetPosition) throws InvalidPositionException, InvalidDirectionException {

        Map<String, Integer> degrees = PositionUtils.getDirection(sourcePosition, targetPosition);

        checkNonSliding(degrees.get("xDegree"), degrees.get("yDegree"), getRepresentation());
    }
}
