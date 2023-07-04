package softeer2nd.chess;

import static softeer2nd.chess.utils.StringUtils.appendNewLine;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class BoardTest {
    Board board;

    @BeforeEach
    public void initBoard(){
        board = new Board();
    }

    @Test
    public void initialize() throws Exception{
        Board board = new Board();
        board.initialize();
        assertEquals("pppppppp", board.getWhitePawnsResult().toString());
        assertEquals("PPPPPPPP", board.getBlackPawnsResult().toString());
    }

}