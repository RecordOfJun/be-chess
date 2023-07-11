package softeer2nd.chess.pieces;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import softeer2nd.chess.exception.InvalidDirectionException;
import softeer2nd.chess.exception.InvalidPositionException;

import static org.junit.jupiter.api.Assertions.*;

class BishopTest {

    @Test
    @DisplayName("비숍은 대각선 이동만이 가능하다")
    void moveBishopWhite() throws InvalidDirectionException, InvalidPositionException {

        Piece whiteBishop = Bishop.createWhite();
        Piece blackBishop = Bishop.createBlack();

        whiteBishop.checkPieceMove("c1","f4");
        whiteBishop.checkPieceMove("f4","d6");
        whiteBishop.checkPieceMove("d6","a3");
        whiteBishop.checkPieceMove("a3","c1");

        assertThrows(InvalidDirectionException.class,()->whiteBishop.checkPieceMove("c1","g1"));
        assertThrows(InvalidDirectionException.class,()->whiteBishop.checkPieceMove("d4","d8"));
        assertThrows(InvalidDirectionException.class,()->whiteBishop.checkPieceMove("f2","b4"));
        assertThrows(InvalidDirectionException.class,()->whiteBishop.checkPieceMove("h5","c8"));
        assertThrows(InvalidDirectionException.class,()->whiteBishop.checkPieceMove("a7","g4"));


        blackBishop.checkPieceMove("c1","f4");
        blackBishop.checkPieceMove("f4","d6");
        blackBishop.checkPieceMove("d6","a3");
        blackBishop.checkPieceMove("a3","c1");

        assertThrows(InvalidDirectionException.class,()->blackBishop.checkPieceMove("c1","g1"));
        assertThrows(InvalidDirectionException.class,()->blackBishop.checkPieceMove("d4","d8"));
        assertThrows(InvalidDirectionException.class,()->blackBishop.checkPieceMove("f2","b4"));
        assertThrows(InvalidDirectionException.class,()->blackBishop.checkPieceMove("h5","c8"));
        assertThrows(InvalidDirectionException.class,()->blackBishop.checkPieceMove("a7","g4"));
    }


}