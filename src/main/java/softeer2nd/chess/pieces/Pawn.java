package softeer2nd.chess.pieces;

import softeer2nd.chess.exception.InvalidDirectionException;
import softeer2nd.chess.exception.InvalidPositionException;
import softeer2nd.chess.utils.Constants;
import softeer2nd.chess.utils.PositionUtils;

import java.util.List;
import java.util.Map;

import static softeer2nd.chess.utils.Constants.X_DEGREE;
import static softeer2nd.chess.utils.Constants.Y_DEGREE;

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
    public void checkPieceMove(String sourcePosition, String targetPosition) throws InvalidPositionException, InvalidDirectionException {
        Map<String ,Integer> degrees= PositionUtils.getDirection(sourcePosition, targetPosition);

        checkNonSliding(degrees.get(X_DEGREE),degrees.get(Y_DEGREE),getRepresentation());
    }
}
