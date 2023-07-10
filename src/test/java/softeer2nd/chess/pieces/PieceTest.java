package softeer2nd.chess.pieces;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import softeer2nd.chess.pieces.Piece.Type;
import static org.junit.jupiter.api.Assertions.*;

class PieceTest {

    @Test
    @DisplayName("piece 생성 테스트")
    public void create_piece() {
        verifyPiece(Pawn.createWhite(), Pawn.createBlack(), Type.PAWN);
        verifyPiece(Knight.createWhite(), Knight.createBlack(), Type.KNIGHT);
        verifyPiece(Rook.createWhite(), Rook.createBlack(), Type.ROOK);
        verifyPiece(Bishop.createWhite(), Bishop.createBlack(), Type.BISHOP);
        verifyPiece(Queen.createWhite(), Queen.createBlack(), Type.QUEEN);
        verifyPiece(King.createWhite(), King.createBlack(), Type.KING);

        Piece blank = Blank.create();
        assertFalse(blank.isWhite());
        assertFalse(blank.isBlack());
        assertFalse(blank.isBlack());
        assertEquals(Type.NO_PIECE, blank.getType());
    }

    private void verifyPiece(final Piece whitePiece, final Piece blackPiece, final Type type) {
        assertTrue(whitePiece.isWhite());
        assertEquals(type, whitePiece.getType());

        assertTrue(blackPiece.isBlack());
        assertEquals(type, blackPiece.getType());

        assertTrue(whitePiece.isPiece());
        assertTrue(blackPiece.isPiece());
    }

    @Test
    public void check_color(){
        verifyWhite(Pawn.createWhite());
        verifyWhite(Rook.createWhite());
        verifyWhite(Bishop.createWhite());
        verifyWhite(Queen.createWhite());
        verifyWhite(King.createWhite());
        verifyWhite(Knight.createWhite());

        verifyBlack(Pawn.createBlack());
        verifyBlack(Rook.createBlack());
        verifyBlack(Bishop.createBlack());
        verifyBlack(Queen.createBlack());
        verifyBlack(King.createBlack());
        verifyBlack(Knight.createBlack());
    }

    private void verifyWhite(final Piece piece){
        assertTrue(piece.isWhite());
    }

    private void verifyBlack(final Piece piece){
        assertTrue(piece.isBlack());
    }
}