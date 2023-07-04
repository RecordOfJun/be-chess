package softeer2nd.chess.pieces;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import softeer2nd.chess.pieces.Pawn;

import static org.assertj.core.api.Assertions.*;

class PawnTest {

    @Test
    @DisplayName("간단 테스트")
    public void create() {
        verifyPawn(Pawn.BLACK_COLOR);
        verifyPawn(Pawn.WHITE_COLOR);
    }

    private void verifyPawn(final String color){
        Pawn pawn=new Pawn(color);
        assertThat(pawn.getColor()).isEqualTo(color);
    }
}