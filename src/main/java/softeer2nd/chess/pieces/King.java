package softeer2nd.chess.pieces;

import softeer2nd.chess.exception.InvalidDirectionException;
import softeer2nd.chess.exception.InvalidPositionException;
import softeer2nd.chess.utils.Constants;
import softeer2nd.chess.utils.PositionUtils;

import java.util.Map;

import static softeer2nd.chess.utils.Constants.X_DEGREE;
import static softeer2nd.chess.utils.Constants.Y_DEGREE;

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
    public void checkPieceMove(String sourcePosition, String targetPosition) throws InvalidPositionException, InvalidDirectionException {

        Map<String, Integer> degrees = PositionUtils.getDirection(sourcePosition, targetPosition);

        checkNonSliding(degrees.get(X_DEGREE), degrees.get(Y_DEGREE), getRepresentation());
    }
}
