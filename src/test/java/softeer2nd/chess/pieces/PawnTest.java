package softeer2nd.chess.pieces;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import softeer2nd.chess.Position;
import softeer2nd.chess.exception.InvalidDirectionException;
import softeer2nd.chess.exception.InvalidPositionException;

import static org.junit.jupiter.api.Assertions.*;

class PawnTest {

    @Test
    @DisplayName("White Pawn은 N,NE,NW 이동만이 가능하다.")
    void checkWhitePawnMove() throws InvalidDirectionException, InvalidPositionException {

        Piece whitePawn= Pawn.createWhite();

        whitePawn.checkPieceMove(new Position("d2"),new Position("d3"));//SSE
        whitePawn.checkPieceMove(new Position("d3"),new Position("c4"));//SSW
        whitePawn.checkPieceMove(new Position("c4"),new Position("d5"));//EEW


        assertThrows(InvalidDirectionException.class,()->whitePawn.checkPieceMove(new Position("c1"),new Position("g1")));
        assertThrows(InvalidDirectionException.class,()->whitePawn.checkPieceMove(new Position("d4"),new Position("d8")));
        assertThrows(InvalidDirectionException.class,()->whitePawn.checkPieceMove(new Position("f2"),new Position("b4")));
        assertThrows(InvalidDirectionException.class,()->whitePawn.checkPieceMove(new Position("h5"),new Position("c8")));
        assertThrows(InvalidDirectionException.class,()->whitePawn.checkPieceMove(new Position("a7"),new Position("g4")));

    }

    @Test
    @DisplayName("Black Pawn은 S,SE,SW 이동만이 가능하다.")
    void checkBlackPawnMove() throws InvalidDirectionException, InvalidPositionException {

        Piece blackPawn= Pawn.createBlack();

        blackPawn.checkPieceMove(new Position("d7"),new Position("d6"));//SSE
        blackPawn.checkPieceMove(new Position("d6"),new Position("c5"));//SSW
        blackPawn.checkPieceMove(new Position("c5"),new Position("d4"));//EEW


        assertThrows(InvalidDirectionException.class,()->blackPawn.checkPieceMove(new Position("c1"),new Position("g1")));
        assertThrows(InvalidDirectionException.class,()->blackPawn.checkPieceMove(new Position("d4"),new Position("d8")));
        assertThrows(InvalidDirectionException.class,()->blackPawn.checkPieceMove(new Position("f2"),new Position("b4")));
        assertThrows(InvalidDirectionException.class,()->blackPawn.checkPieceMove(new Position("h5"),new Position("c8")));
        assertThrows(InvalidDirectionException.class,()->blackPawn.checkPieceMove(new Position("a7"),new Position("g4")));

    }

}