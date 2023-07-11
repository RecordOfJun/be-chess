package softeer2nd.chess.pieces;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import softeer2nd.chess.Position;
import softeer2nd.chess.exception.InvalidDirectionException;
import softeer2nd.chess.exception.InvalidPositionException;

import static org.junit.jupiter.api.Assertions.*;

class RookTest {
    @Test
    @DisplayName("ROOK은 동서남북으로 직선 이동이 가능해야 한다.")
    void checkRookMove() throws InvalidDirectionException, InvalidPositionException {

        Piece whiteRook=Rook.createWhite();
        Piece blackRook=Rook.createBlack();

        whiteRook.checkPieceMove(new Position("d8"),new Position("d1"));
        whiteRook.checkPieceMove(new Position("d8"),new Position("a8"));
        whiteRook.checkPieceMove(new Position("d8"),new Position("h8"));
        whiteRook.checkPieceMove(new Position("d1"),new Position("d8"));


        blackRook.checkPieceMove(new Position("d8"),new Position("d1"));
        blackRook.checkPieceMove(new Position("d8"),new Position("a8"));
        blackRook.checkPieceMove(new Position("d8"),new Position("h8"));
        blackRook.checkPieceMove(new Position("d1"),new Position("d8"));


    }
}