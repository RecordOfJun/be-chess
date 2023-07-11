package softeer2nd.chess.pieces;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import softeer2nd.chess.exception.InvalidDirectionException;
import softeer2nd.chess.exception.InvalidPositionException;

import static org.junit.jupiter.api.Assertions.*;

class KingTest {

    @Test
    @DisplayName("King은 모든 방향으로 한 칸 씩만 이동이 가능해야 한다.")
    void checkKingMove() throws InvalidDirectionException, InvalidPositionException {

        Piece whiteKing=King.createWhite();
        Piece blackKing=King.createBlack();

        whiteKing.checkPieceMove("d5","e5");
        whiteKing.checkPieceMove("e5","e4");
        whiteKing.checkPieceMove("e4","d4");
        whiteKing.checkPieceMove("d4","d5");
        whiteKing.checkPieceMove("d5","c6");
        whiteKing.checkPieceMove("c6","d7");
        whiteKing.checkPieceMove("d7","e6");
        whiteKing.checkPieceMove("e6","d5");


        assertThrows(InvalidDirectionException.class,()->whiteKing.checkPieceMove("c1","g1"));
        assertThrows(InvalidDirectionException.class,()->whiteKing.checkPieceMove("d4","d8"));
        assertThrows(InvalidDirectionException.class,()->whiteKing.checkPieceMove("f2","b4"));
        assertThrows(InvalidDirectionException.class,()->whiteKing.checkPieceMove("h5","c8"));
        assertThrows(InvalidDirectionException.class,()->whiteKing.checkPieceMove("a7","g4"));


        whiteKing.checkPieceMove("d5","e5");
        whiteKing.checkPieceMove("e5","e4");
        whiteKing.checkPieceMove("e4","d4");
        whiteKing.checkPieceMove("d4","d5");
        whiteKing.checkPieceMove("d5","c6");
        whiteKing.checkPieceMove("c6","d7");
        whiteKing.checkPieceMove("d7","e6");
        whiteKing.checkPieceMove("e6","d5");

        assertThrows(InvalidDirectionException.class,()->blackKing.checkPieceMove("c1","g1"));
        assertThrows(InvalidDirectionException.class,()->blackKing.checkPieceMove("d4","d8"));
        assertThrows(InvalidDirectionException.class,()->blackKing.checkPieceMove("f2","b4"));
        assertThrows(InvalidDirectionException.class,()->blackKing.checkPieceMove("h5","c8"));
        assertThrows(InvalidDirectionException.class,()->blackKing.checkPieceMove("a7","g4"));
    }

}