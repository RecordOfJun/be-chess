package softeer2nd.chess.pieces;

import softeer2nd.chess.exception.InvalidDirectionException;
import softeer2nd.chess.exception.InvalidPositionException;
import softeer2nd.chess.utils.PositionUtils;

import java.util.Map;

public class Blank extends Piece {

    private Blank() {
        super();
    }

    public static Piece create() {
        return new Blank();
    }

    @Override
    public void checkPieceMove(String sourcePosition, String targetPosition) throws InvalidDirectionException, InvalidPositionException {

        Map<String, Integer> degrees = PositionUtils.getDirection(sourcePosition, targetPosition);

        throw new InvalidDirectionException("빈 칸을 움직일 수 없습니다!");
    }
}
