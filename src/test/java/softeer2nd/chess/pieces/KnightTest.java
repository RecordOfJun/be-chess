package softeer2nd.chess.pieces;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import softeer2nd.chess.Position;
import softeer2nd.chess.exception.InvalidDirectionException;
import softeer2nd.chess.exception.InvalidPositionException;

import static org.junit.jupiter.api.Assertions.*;

class KnightTest {

    @Test
    @DisplayName("Knight는 NNE,NNW,SSE,SSW,EEN,EES,WWN,WWS 이동만이 가능해야 한다.")
    void checkKnightMove() throws InvalidDirectionException, InvalidPositionException {

        Piece whiteKnight=Knight.createWhite();
        Piece blackKnight=Knight.createBlack();

        whiteKnight.checkPieceMove(new Position("b8"), new Position("c6"));//SSE
        whiteKnight.checkPieceMove(new Position("c6"), new Position("b4"));//SSW
        whiteKnight.checkPieceMove(new Position("b4"), new Position("d3"));//EEW
        whiteKnight.checkPieceMove(new Position("d3"), new Position("f4"));//EEN
        whiteKnight.checkPieceMove(new Position("f4"), new Position("g6"));//NNE
        whiteKnight.checkPieceMove(new Position("g6"), new Position("f8"));//NNW
        whiteKnight.checkPieceMove(new Position("f8"), new Position("d7"));//WWS
        whiteKnight.checkPieceMove(new Position("d7"), new Position("b8"));//WWN


        assertThrows(InvalidDirectionException.class,()->whiteKnight.checkPieceMove(new Position("c1"), new Position("g1")));
        assertThrows(InvalidDirectionException.class,()->whiteKnight.checkPieceMove(new Position("d4"), new Position("d8")));
        assertThrows(InvalidDirectionException.class,()->whiteKnight.checkPieceMove(new Position("f2"), new Position("b4")));
        assertThrows(InvalidDirectionException.class,()->whiteKnight.checkPieceMove(new Position("h5"), new Position("c8")));
        assertThrows(InvalidDirectionException.class,()->whiteKnight.checkPieceMove(new Position("a7"), new Position("g4")));


        blackKnight.checkPieceMove(new Position("b8"), new Position("c6"));//SSE
        blackKnight.checkPieceMove(new Position("c6"), new Position("b4"));//SSW
        blackKnight.checkPieceMove(new Position("b4"), new Position("d3"));//EEW
        blackKnight.checkPieceMove(new Position("d3"), new Position("f4"));//EEN
        blackKnight.checkPieceMove(new Position("f4"), new Position("g6"));//NNE
        blackKnight.checkPieceMove(new Position("g6"), new Position("f8"));//NNW
        blackKnight.checkPieceMove(new Position("f8"), new Position("d7"));//WWS
        blackKnight.checkPieceMove(new Position("d7"), new Position("b8"));//WWN

        assertThrows(InvalidDirectionException.class,()->blackKnight.checkPieceMove(new Position("c1"), new Position("g1")));
        assertThrows(InvalidDirectionException.class,()->blackKnight.checkPieceMove(new Position("d4"), new Position("d8")));
        assertThrows(InvalidDirectionException.class,()->blackKnight.checkPieceMove(new Position("f2"), new Position("b4")));
        assertThrows(InvalidDirectionException.class,()->blackKnight.checkPieceMove(new Position("h5"), new Position("c8")));
        assertThrows(InvalidDirectionException.class,()->blackKnight.checkPieceMove(new Position("a7"), new Position("g4")));
    }

}