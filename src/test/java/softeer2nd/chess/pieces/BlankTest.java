package softeer2nd.chess.pieces;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import softeer2nd.chess.exception.InvalidDirectionException;
import softeer2nd.chess.exception.InvalidPositionException;

import static org.junit.jupiter.api.Assertions.*;

class BlankTest {

    @Test
    @DisplayName("빈 칸의 기물을 이동시킬 수 없어야 한다.")
    void moveBlank() throws InvalidDirectionException, InvalidPositionException {
        Piece blank=Blank.create();
        assertThrows(InvalidDirectionException.class,()->blank.checkPieceMove("a3","a4"));
        assertThrows(InvalidDirectionException.class,()->blank.checkPieceMove("b1","d4"));
        assertThrows(InvalidDirectionException.class,()->blank.checkPieceMove("f3","h4"));
        assertThrows(InvalidPositionException.class,()->blank.checkPieceMove("13","24"));
        assertThrows(InvalidPositionException.class,()->blank.checkPieceMove("a9","a2"));
        assertThrows(InvalidPositionException.class,()->blank.checkPieceMove("8u","a4"));
        assertThrows(InvalidPositionException.class,()->blank.checkPieceMove("a3","04"));
    }

}