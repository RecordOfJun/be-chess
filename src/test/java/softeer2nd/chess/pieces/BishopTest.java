package softeer2nd.chess.pieces;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import softeer2nd.chess.Position;
import softeer2nd.chess.exception.InvalidDirectionException;
import softeer2nd.chess.exception.InvalidPositionException;

import static org.junit.jupiter.api.Assertions.*;

class BishopTest {

    @Test
    @DisplayName("비숍은 대각선 이동만이 가능하다")
    void checkBishopMove() throws InvalidDirectionException, InvalidPositionException {

        Piece whiteBishop = Bishop.createWhite();
        Piece blackBishop = Bishop.createBlack();

        whiteBishop.checkPieceMove(new Position("c1"),new Position("f4"));
        whiteBishop.checkPieceMove(new Position("f4"),new Position("d6"));
        whiteBishop.checkPieceMove(new Position("d6"),new Position("a3"));
        whiteBishop.checkPieceMove(new Position("a3"),new Position("c1"));


        assertThrows(InvalidDirectionException.class,()->whiteBishop.checkPieceMove(new Position("c1"),new Position("g1")));
        assertThrows(InvalidDirectionException.class,()->whiteBishop.checkPieceMove(new Position("d4"),new Position("d8")));
        assertThrows(InvalidDirectionException.class,()->whiteBishop.checkPieceMove(new Position("f2"),new Position("b4")));
        assertThrows(InvalidDirectionException.class,()->whiteBishop.checkPieceMove(new Position("h5"),new Position("c8")));
        assertThrows(InvalidDirectionException.class,()->whiteBishop.checkPieceMove(new Position("a7"),new Position("g4")));


        blackBishop.checkPieceMove(new Position("c1"),new Position("f4"));
        blackBishop.checkPieceMove(new Position("f4"),new Position("d6"));
        blackBishop.checkPieceMove(new Position("d6"),new Position("a3"));
        blackBishop.checkPieceMove(new Position("a3"),new Position("c1"));

        assertThrows(InvalidDirectionException.class,()->blackBishop.checkPieceMove(new Position("c1"),new Position("g1")));
        assertThrows(InvalidDirectionException.class,()->blackBishop.checkPieceMove(new Position("d4"),new Position("d8")));
        assertThrows(InvalidDirectionException.class,()->blackBishop.checkPieceMove(new Position("f2"),new Position("b4")));
        assertThrows(InvalidDirectionException.class,()->blackBishop.checkPieceMove(new Position("h5"),new Position("c8")));
        assertThrows(InvalidDirectionException.class,()->blackBishop.checkPieceMove(new Position("a7"),new Position("g4")));
    }


}