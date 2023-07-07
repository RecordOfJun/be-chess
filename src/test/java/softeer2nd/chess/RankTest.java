package softeer2nd.chess;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;
import static softeer2nd.chess.utils.StringUtils.appendNewLine;
class RankTest {

    @Test
    @DisplayName("팩토리 메소드로 Rank 생성 확인하기")
    public void createRank(){
        verifyRank(Rank.createEmpty(),appendNewLine("........"));
        verifyRank(Rank.createBlackPawns(),appendNewLine("PPPPPPPP"));
        verifyRank(Rank.createBlackPieces(),appendNewLine("RNBQKBNR"));
        verifyRank(Rank.createWhitePawns(),appendNewLine("pppppppp"));
        verifyRank(Rank.createWhitePieces(),appendNewLine("rnbqkbnr"));
    }

    private void verifyRank(Rank rank,String rankRepresentation){
        assertEquals(rank.getRankRepresentation(),rankRepresentation);
    }
}