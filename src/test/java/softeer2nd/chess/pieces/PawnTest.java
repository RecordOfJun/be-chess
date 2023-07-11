package softeer2nd.chess.pieces;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import softeer2nd.chess.exception.InvalidDirectionException;
import softeer2nd.chess.exception.InvalidPositionException;

import static org.junit.jupiter.api.Assertions.*;

class PawnTest {

    @Test
    @DisplayName("White Pawn은 N,NE,NW 이동만이 가능하다.")
    void checkWhitePawnMove() throws InvalidDirectionException, InvalidPositionException {

        Piece whitePawn= Pawn.createWhite();

        whitePawn.checkPieceMove("d2","d3");//SSE
        whitePawn.checkPieceMove("d3","c4");//SSW
        whitePawn.checkPieceMove("c4","d5");//EEW


        assertThrows(InvalidDirectionException.class,()->whitePawn.checkPieceMove("c1","g1"));
        assertThrows(InvalidDirectionException.class,()->whitePawn.checkPieceMove("d4","d8"));
        assertThrows(InvalidDirectionException.class,()->whitePawn.checkPieceMove("f2","b4"));
        assertThrows(InvalidDirectionException.class,()->whitePawn.checkPieceMove("h5","c8"));
        assertThrows(InvalidDirectionException.class,()->whitePawn.checkPieceMove("a7","g4"));

    }

    @Test
    @DisplayName("Black Pawn은 S,SE,SW 이동만이 가능하다.")
    void checkBlackPawnMove() throws InvalidDirectionException, InvalidPositionException {

        Piece blackPawn= Pawn.createBlack();

        blackPawn.checkPieceMove("d7","d6");//SSE
        blackPawn.checkPieceMove("d6","c5");//SSW
        blackPawn.checkPieceMove("c5","d4");//EEW


        assertThrows(InvalidDirectionException.class,()->blackPawn.checkPieceMove("c1","g1"));
        assertThrows(InvalidDirectionException.class,()->blackPawn.checkPieceMove("d4","d8"));
        assertThrows(InvalidDirectionException.class,()->blackPawn.checkPieceMove("f2","b4"));
        assertThrows(InvalidDirectionException.class,()->blackPawn.checkPieceMove("h5","c8"));
        assertThrows(InvalidDirectionException.class,()->blackPawn.checkPieceMove("a7","g4"));

    }

}