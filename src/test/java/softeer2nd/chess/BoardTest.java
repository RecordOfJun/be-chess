package softeer2nd.chess;



import org.junit.Before;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import softeer2nd.chess.pieces.Pawn;

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