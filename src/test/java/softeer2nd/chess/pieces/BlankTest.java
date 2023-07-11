package softeer2nd.chess.pieces;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import softeer2nd.chess.Position;
import softeer2nd.chess.exception.InvalidDirectionException;
import softeer2nd.chess.exception.InvalidPositionException;

import static org.junit.jupiter.api.Assertions.*;

class BlankTest {

    @Test
    @DisplayName("빈 칸의 기물을 이동시킬 수 없어야 한다.")
    void moveBlank() throws InvalidDirectionException, InvalidPositionException {
        Piece blank=Blank.create();
        assertThrows(InvalidDirectionException.class,()->blank.checkPieceMove(new Position("a3"),new Position("a4")));
        assertThrows(InvalidDirectionException.class,()->blank.checkPieceMove(new Position("b1"),new Position("d4")));
        assertThrows(InvalidDirectionException.class,()->blank.checkPieceMove(new Position("f3"),new Position("h4")));
        assertThrows(InvalidPositionException.class,()->blank.checkPieceMove(new Position("13"),new Position("24")));
        assertThrows(InvalidPositionException.class,()->blank.checkPieceMove(new Position("a9"),new Position("a2")));
        assertThrows(InvalidPositionException.class,()->blank.checkPieceMove(new Position("8u"),new Position("a4")));
        assertThrows(InvalidPositionException.class,()->blank.checkPieceMove(new Position("a3"),new Position("04")));
    }

}