package softeer2nd.chess;



import org.junit.Before;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import softeer2nd.chess.pieces.Pawn;

import static org.junit.jupiter.api.Assertions.*;

class BoardTest {
    Board board;
    int boardSize;
    int boardLastIndex;

    @BeforeEach
    public void initBoard(){
        board = new Board();
        boardSize=0;
        boardLastIndex=-1;
    }

    @Test
    public void create() throws Exception {
        verifyPawn(Pawn.WHITE_COLOR);
        verifyPawn(Pawn.BLACK_COLOR);
    }

    private void verifyPawn(final String color){
        Pawn pawn = new Pawn(color);
        board.add(pawn);
        boardSize+=1;
        boardLastIndex+=1;
        assertEquals(boardSize, board.size());
        assertEquals(pawn, board.findPawn(boardLastIndex));
    }

    @Test
    public void initialize() throws Exception{
        Board board = new Board();
        board.initialize();
        assertEquals("pppppppp", board.getWhitePawnsResult());
        assertEquals("PPPPPPPP", board.getBlackPawnsResult());
    }

}