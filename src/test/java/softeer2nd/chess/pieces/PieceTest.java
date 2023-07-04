package softeer2nd.chess.pieces;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class PieceTest {

    @Test
    @DisplayName("pawn 생성 테스트")
    public void create() {
        verifyPawn(Piece.createWhitePawn(), Piece.WHITE_COLOR, Piece.WHITE_PAWN_REPRESENTATION);
        verifyPawn(Piece.createBlackPawn(), Piece.BLACK_COLOR, Piece.BLACK_PAWN_REPRESENTATION);
        verifyPawn(Piece.createWhiteKnight(), Piece.WHITE_COLOR, Piece.WHITE_KNIGHT_REPRESENTATION);
        verifyPawn(Piece.createBlackKnight(), Piece.BLACK_COLOR, Piece.BLACK_KNIGHT_REPRESENTATION);
        verifyPawn(Piece.createWhiteRook(), Piece.WHITE_COLOR, Piece.WHITE_ROOK_REPRESENTATION);
        verifyPawn(Piece.createBlackRook(), Piece.BLACK_COLOR, Piece.BLACK_ROOK_REPRESENTATION);
        verifyPawn(Piece.createWhiteBishop(), Piece.WHITE_COLOR, Piece.WHITE_BISHOP_REPRESENTATION);
        verifyPawn(Piece.createBlackBishop(), Piece.BLACK_COLOR, Piece.BLACK_BISHOP_REPRESENTATION);
        verifyPawn(Piece.createWhiteQueen(), Piece.WHITE_COLOR, Piece.WHITE_QUEEN_REPRESENTATION);
        verifyPawn(Piece.createBlackQueen(), Piece.BLACK_COLOR, Piece.BLACK_QUEEN_REPRESENTATION);
        verifyPawn(Piece.createWhiteKing(), Piece.WHITE_COLOR, Piece.WHITE_KING_REPRESENTATION);
        verifyPawn(Piece.createBlackKing(), Piece.BLACK_COLOR, Piece.BLACK_KING_REPRESENTATION);
    }

    void verifyPawn(final Piece piece, final String color, final char representation) {
        assertEquals(color, piece.getColor());
        assertEquals(representation, piece.getRepresentation());
    }
}