package softeer2nd.chess.pieces;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import softeer2nd.chess.pieces.Pawn;

import static org.assertj.core.api.Assertions.*;

class PawnTest {

    @Test
    public void create() {
        verifyPawn(Pawn.WHITE_COLOR, Pawn.WHITE_REPRESENTATION);
        verifyPawn(Pawn.BLACK_COLOR, Pawn.BLACK_REPRESENTATION);
    }

    void verifyPawn(final String color, final char representation) {
        Pawn pawn = new Pawn(color, representation);
        assertEquals(color, pawn.getColor());
        assertEquals(representation, pawn.getRepresentation());
    }
}