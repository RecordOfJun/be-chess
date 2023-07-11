package softeer2nd.chess.pieces;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import softeer2nd.chess.exception.InvalidDirectionException;
import softeer2nd.chess.exception.InvalidPositionException;

import static org.junit.jupiter.api.Assertions.*;

class QueenTest {


    @Test
    @DisplayName("Queen은 모든 방향으로 직선 이동이 가능해야 한다.")
    void checkQueenMove() throws InvalidDirectionException, InvalidPositionException {

        Piece whiteQueen=Queen.createWhite();
        Piece blackQueen=Queen.createBlack();

        whiteQueen.checkPieceMove("d8","d1");
        whiteQueen.checkPieceMove("d8","a8");
        whiteQueen.checkPieceMove("d8","h8");
        whiteQueen.checkPieceMove("d1","d8");
        whiteQueen.checkPieceMove("d8","a5");
        whiteQueen.checkPieceMove("d8","h4");
        whiteQueen.checkPieceMove("d8","a5");
        whiteQueen.checkPieceMove("h4","d8");
        whiteQueen.checkPieceMove("a5","d8");


        blackQueen.checkPieceMove("d8","d1");
        blackQueen.checkPieceMove("d8","a8");
        blackQueen.checkPieceMove("d8","h8");
        blackQueen.checkPieceMove("d1","d8");
        blackQueen.checkPieceMove("d8","a5");
        blackQueen.checkPieceMove("d8","h4");
        blackQueen.checkPieceMove("d8","a5");
        blackQueen.checkPieceMove("h4","d8");
        blackQueen.checkPieceMove("a5","d8");


    }
}