package softeer2nd.chess.pieces;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import softeer2nd.chess.exception.InvalidDirectionException;
import softeer2nd.chess.exception.InvalidPositionException;

import static org.junit.jupiter.api.Assertions.*;

class KnightTest {

    @Test
    @DisplayName("Knight는 NNE,NNW,SSE,SSW,EEN,EES,WWN,WWS 이동만이 가능해야 한다.")
    void checkKnightMove() throws InvalidDirectionException, InvalidPositionException {

        Piece whiteKnight=Knight.createWhite();
        Piece blackKnight=Knight.createBlack();

        whiteKnight.checkPieceMove("b8","c6");//SSE
        whiteKnight.checkPieceMove("c6","b4");//SSW
        whiteKnight.checkPieceMove("b4","d3");//EEW
        whiteKnight.checkPieceMove("d3","f4");//EEN
        whiteKnight.checkPieceMove("f4","g6");//NNE
        whiteKnight.checkPieceMove("g6","f8");//NNW
        whiteKnight.checkPieceMove("f8","d7");//WWS
        whiteKnight.checkPieceMove("d7","b8");//WWN


        assertThrows(InvalidDirectionException.class,()->whiteKnight.checkPieceMove("c1","g1"));
        assertThrows(InvalidDirectionException.class,()->whiteKnight.checkPieceMove("d4","d8"));
        assertThrows(InvalidDirectionException.class,()->whiteKnight.checkPieceMove("f2","b4"));
        assertThrows(InvalidDirectionException.class,()->whiteKnight.checkPieceMove("h5","c8"));
        assertThrows(InvalidDirectionException.class,()->whiteKnight.checkPieceMove("a7","g4"));


        blackKnight.checkPieceMove("b8","c6");//SSE
        blackKnight.checkPieceMove("c6","b4");//SSW
        blackKnight.checkPieceMove("b4","d3");//EEW
        blackKnight.checkPieceMove("d3","f4");//EEN
        blackKnight.checkPieceMove("f4","g6");//NNE
        blackKnight.checkPieceMove("g6","f8");//NNW
        blackKnight.checkPieceMove("f8","d7");//WWS
        blackKnight.checkPieceMove("d7","b8");//WWN

        assertThrows(InvalidDirectionException.class,()->blackKnight.checkPieceMove("c1","g1"));
        assertThrows(InvalidDirectionException.class,()->blackKnight.checkPieceMove("d4","d8"));
        assertThrows(InvalidDirectionException.class,()->blackKnight.checkPieceMove("f2","b4"));
        assertThrows(InvalidDirectionException.class,()->blackKnight.checkPieceMove("h5","c8"));
        assertThrows(InvalidDirectionException.class,()->blackKnight.checkPieceMove("a7","g4"));
    }

}