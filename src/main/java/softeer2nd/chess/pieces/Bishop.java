package softeer2nd.chess.pieces;

import softeer2nd.chess.exception.InvalidDirectionException;
import softeer2nd.chess.exception.InvalidPositionException;
import softeer2nd.chess.utils.Constants;
import softeer2nd.chess.utils.PositionUtils;

import java.util.Map;

import static softeer2nd.chess.utils.Constants.X_DEGREE;
import static softeer2nd.chess.utils.Constants.Y_DEGREE;

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

        checkSliding(degrees.get(X_DEGREE), degrees.get(Y_DEGREE), getRepresentation());
    }
}
