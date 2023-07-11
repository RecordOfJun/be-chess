package softeer2nd.chess.pieces;

import softeer2nd.chess.Position;
import softeer2nd.chess.exception.InvalidDirectionException;

public class Blank extends Piece {

    private Blank() {
        super();
    }

    public static Piece create() {
        return new Blank();
    }

    @Override
    public void checkPieceMove(Position sourcePosition, Position targetPosition) throws InvalidDirectionException {
        throw new InvalidDirectionException("빈 칸을 움직일 수 없습니다!");
    }
}
