package softeer2nd.chess.pieces;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class PieceTest {

    @Test
    @DisplayName("pawn 생성 테스트")
    public void create() {
        verifyPawn(Piece.createWhitePawn(), Piece.WHITE_COLOR, Piece.WHITE_REPRESENTATION);
        verifyPawn(Piece.createBlackPawn(), Piece.BLACK_COLOR, Piece.BLACK_REPRESENTATION);
    }

    void verifyPawn(final Piece piece, final String color, final char representation) {
        assertEquals(color, piece.getColor());
        assertEquals(representation, piece.getRepresentation());
    }
}