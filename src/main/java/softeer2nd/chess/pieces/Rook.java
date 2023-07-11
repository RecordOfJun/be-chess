package softeer2nd.chess.pieces;

import softeer2nd.chess.exception.InvalidDirectionException;
import softeer2nd.chess.exception.InvalidPositionException;
import softeer2nd.chess.utils.PositionUtils;

import java.util.Map;

public class Rook extends Piece{

    private Rook(Color color){
        super(color,Type.ROOK,Direction.linearDirection());
    }

    public static Piece createWhite(){
        return new Rook(Color.WHITE);
    }

    public static Piece createBlack(){
        return new Rook(Color.BLACK);
    }

    @Override
    public void checkPieceMove(String sourcePosition, String targetPosition) throws InvalidPositionException,InvalidDirectionException {

        Map<String ,Integer> degrees= PositionUtils.getDirection(sourcePosition, targetPosition);

        checkSliding(degrees.get("xDegree"),degrees.get("yDegree"),this.getRepresentation());
    }
}
