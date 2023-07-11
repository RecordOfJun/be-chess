package softeer2nd.chess.pieces;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import softeer2nd.chess.exception.InvalidDirectionException;
import softeer2nd.chess.exception.InvalidPositionException;

import static org.junit.jupiter.api.Assertions.*;

class RookTest {
    @Test
    @DisplayName("ROOK은 동서남북으로 직선 이동이 가능해야 한다.")
    void checkRookMove() throws InvalidDirectionException, InvalidPositionException {

        Piece whiteRook=Rook.createWhite();
        Piece blackRook=Rook.createBlack();

        whiteRook.checkPieceMove("d8","d1");
        whiteRook.checkPieceMove("d8","a8");
        whiteRook.checkPieceMove("d8","h8");
        whiteRook.checkPieceMove("d1","d8");


        blackRook.checkPieceMove("d8","d1");
        blackRook.checkPieceMove("d8","a8");
        blackRook.checkPieceMove("d8","h8");
        blackRook.checkPieceMove("d1","d8");


    }
}