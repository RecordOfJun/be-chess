package softeer2nd.chess.pieces;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import softeer2nd.chess.pieces.Piece.Type;
import static org.junit.jupiter.api.Assertions.*;

class PieceTest {

    @Test
    @DisplayName("piece 생성 테스트")
    public void create_piece() {
        verifyPiece(Piece.createWhitePawn(), Piece.createBlackPawn(), Type.PAWN);
        verifyPiece(Piece.createWhiteKnight(), Piece.createBlackKnight(), Type.KNIGHT);
        verifyPiece(Piece.createWhiteRook(), Piece.createBlackRook(), Type.ROOK);
        verifyPiece(Piece.createWhiteBishop(), Piece.createBlackBishop(), Type.BISHOP);
        verifyPiece(Piece.createWhiteQueen(), Piece.createBlackQueen(), Type.QUEEN);
        verifyPiece(Piece.createWhiteKing(), Piece.createBlackKing(), Type.KING);

        Piece blank = Piece.createBlank();
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
        verifyWhite(Piece.createWhitePawn());
        verifyWhite(Piece.createWhiteRook());
        verifyWhite(Piece.createWhiteBishop());
        verifyWhite(Piece.createWhiteQueen());
        verifyWhite(Piece.createWhiteKing());
        verifyWhite(Piece.createWhiteKnight());

        verifyBlack(Piece.createBlackPawn());
        verifyBlack(Piece.createBlackRook());
        verifyBlack(Piece.createBlackBishop());
        verifyBlack(Piece.createBlackQueen());
        verifyBlack(Piece.createBlackKing());
        verifyBlack(Piece.createBlackKnight());
    }

    private void verifyWhite(final Piece piece){
        assertTrue(piece.isWhite());
    }

    private void verifyBlack(final Piece piece){
        assertTrue(piece.isBlack());
    }
}