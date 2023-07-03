package softeer2nd;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.*;

class PawnTest {

    @Test
    @DisplayName("간단 테스트")
    public void create() {
        String[] colorArray={"white","black"};

        for (String color : colorArray) {
            verifyPawn(color);
        }
    }

    private void verifyPawn(final String color){
        Pawn pawn=new Pawn(color);
        assertThat(pawn.getColor()).isEqualTo(color);
    }
}