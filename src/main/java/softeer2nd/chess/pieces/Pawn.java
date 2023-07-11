package softeer2nd.chess.pieces;

import softeer2nd.chess.exception.InvalidDirectionException;
import softeer2nd.chess.exception.InvalidPositionException;
import softeer2nd.chess.utils.PositionUtils;

import java.util.List;
import java.util.Map;

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

        int xDegree=degrees.get("xDegree");
        int yDegree=degrees.get("yDegree");

        for (Direction direction : getDirections()) {
            if(direction.getXDegree()==xDegree && direction.getYDegree()==yDegree){
                return;
            }
        }

        throw new InvalidDirectionException("Pawn은 해당 위치로 이동할 수 없습니다.");
    }
}
