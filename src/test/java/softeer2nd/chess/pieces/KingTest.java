package softeer2nd.chess.pieces;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import softeer2nd.chess.Position;
import softeer2nd.chess.exception.InvalidDirectionException;
import softeer2nd.chess.exception.InvalidPositionException;

import static org.junit.jupiter.api.Assertions.*;

class KingTest {

    @Test
    @DisplayName("King은 모든 방향으로 한 칸 씩만 이동이 가능해야 한다.")
    void checkKingMove() throws InvalidDirectionException, InvalidPositionException {

        Piece whiteKing=King.createWhite();
        Piece blackKing=King.createBlack();

        whiteKing.checkPieceMove(new Position("d5"),new Position("e5"));
        whiteKing.checkPieceMove(new Position("e5"),new Position("e4"));
        whiteKing.checkPieceMove(new Position("e4"),new Position("d4"));
        whiteKing.checkPieceMove(new Position("d4"),new Position("d5"));
        whiteKing.checkPieceMove(new Position("d5"),new Position("c6"));
        whiteKing.checkPieceMove(new Position("c6"),new Position("d7"));
        whiteKing.checkPieceMove(new Position("d7"),new Position("e6"));
        whiteKing.checkPieceMove(new Position("e6"),new Position("d5"));


        assertThrows(InvalidDirectionException.class,()->whiteKing.checkPieceMove(new Position("c1"),new Position("g1")));
        assertThrows(InvalidDirectionException.class,()->whiteKing.checkPieceMove(new Position("d4"),new Position("d8")));
        assertThrows(InvalidDirectionException.class,()->whiteKing.checkPieceMove(new Position("f2"),new Position("b4")));
        assertThrows(InvalidDirectionException.class,()->whiteKing.checkPieceMove(new Position("h5"),new Position("c8")));
        assertThrows(InvalidDirectionException.class,()->whiteKing.checkPieceMove(new Position("a7"),new Position("g4")));


        whiteKing.checkPieceMove(new Position("d5"),new Position("e5"));
        whiteKing.checkPieceMove(new Position("e5"),new Position("e4"));
        whiteKing.checkPieceMove(new Position("e4"),new Position("d4"));
        whiteKing.checkPieceMove(new Position("d4"),new Position("d5"));
        whiteKing.checkPieceMove(new Position("d5"),new Position("c6"));
        whiteKing.checkPieceMove(new Position("c6"),new Position("d7"));
        whiteKing.checkPieceMove(new Position("d7"),new Position("e6"));
        whiteKing.checkPieceMove(new Position("e6"),new Position("d5"));

        assertThrows(InvalidDirectionException.class,()->blackKing.checkPieceMove(new Position("c1"),new Position("g1")));
        assertThrows(InvalidDirectionException.class,()->blackKing.checkPieceMove(new Position("d4"),new Position("d8")));
        assertThrows(InvalidDirectionException.class,()->blackKing.checkPieceMove(new Position("f2"),new Position("b4")));
        assertThrows(InvalidDirectionException.class,()->blackKing.checkPieceMove(new Position("h5"),new Position("c8")));
        assertThrows(InvalidDirectionException.class,()->blackKing.checkPieceMove(new Position("a7"),new Position("g4")));
    }

}