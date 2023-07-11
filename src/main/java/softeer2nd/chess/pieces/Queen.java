package softeer2nd.chess.pieces;

import softeer2nd.chess.exception.InvalidDirectionException;
import softeer2nd.chess.exception.InvalidPositionException;
import softeer2nd.chess.utils.PositionUtils;

import java.util.Map;

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
    public void checkPieceMove(String sourcePosition, String targetPosition) throws InvalidPositionException, InvalidDirectionException {

        Map<String ,Integer> degrees= PositionUtils.getDirection(sourcePosition, targetPosition);

        checkSliding(degrees.get("xDegree"),degrees.get("yDegree"),this.getRepresentation());

    }
}
