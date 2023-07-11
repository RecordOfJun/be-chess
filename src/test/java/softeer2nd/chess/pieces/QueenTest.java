package softeer2nd.chess.pieces;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import softeer2nd.chess.Position;
import softeer2nd.chess.exception.InvalidDirectionException;
import softeer2nd.chess.exception.InvalidPositionException;

import static org.junit.jupiter.api.Assertions.*;

class QueenTest {


    @Test
    @DisplayName("Queen은 모든 방향으로 직선 이동이 가능해야 한다.")
    void checkQueenMove() throws InvalidDirectionException, InvalidPositionException {

        Piece whiteQueen=Queen.createWhite();
        Piece blackQueen=Queen.createBlack();

        whiteQueen.checkPieceMove(new Position("d8"),new Position("d1"));
        whiteQueen.checkPieceMove(new Position("d8"),new Position("a8"));
        whiteQueen.checkPieceMove(new Position("d8"),new Position("h8"));
        whiteQueen.checkPieceMove(new Position("d1"),new Position("d8"));
        whiteQueen.checkPieceMove(new Position("d8"),new Position("a5"));
        whiteQueen.checkPieceMove(new Position("d8"),new Position("h4"));
        whiteQueen.checkPieceMove(new Position("d8"),new Position("a5"));
        whiteQueen.checkPieceMove(new Position("h4"),new Position("d8"));
        whiteQueen.checkPieceMove(new Position("a5"),new Position("d8"));


        blackQueen.checkPieceMove(new Position("d8"),new Position("d1"));
        blackQueen.checkPieceMove(new Position("d8"),new Position("a8"));
        blackQueen.checkPieceMove(new Position("d8"),new Position("h8"));
        blackQueen.checkPieceMove(new Position("d1"),new Position("d8"));
        blackQueen.checkPieceMove(new Position("d8"),new Position("a5"));
        blackQueen.checkPieceMove(new Position("d8"),new Position("h4"));
        blackQueen.checkPieceMove(new Position("d8"),new Position("a5"));
        blackQueen.checkPieceMove(new Position("h4"),new Position("d8"));
        blackQueen.checkPieceMove(new Position("a5"),new Position("d8"));


    }
}