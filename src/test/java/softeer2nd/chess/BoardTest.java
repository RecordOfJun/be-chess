package softeer2nd.chess;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import softeer2nd.chess.exception.InvalidPositionException;
import softeer2nd.chess.pieces.*;

import java.util.HashMap;

import static org.junit.jupiter.api.Assertions.*;
import static softeer2nd.chess.utils.StringUtils.appendNewLine;

class BoardTest {
    Board board;

    @BeforeEach
    public void initBoard() {
        board = new Board();
    }

    @Test
    @DisplayName("체스판 생성 확인하기")
    public void create() throws Exception {

        board.initialize();

        assertEquals(32, board.getPieceCount());
        String blankRank = appendNewLine("........");
        assertEquals(
                appendNewLine("RNBQKBNR") +
                        appendNewLine("PPPPPPPP") +
                        blankRank + blankRank + blankRank + blankRank +
                        appendNewLine("pppppppp") +
                        appendNewLine("rnbqkbnr"),
                board.getBoardRepresentation());
    }

    @Test
    @DisplayName("보드 내의 입력한 색깔을 가진 기물의 개수가 제대로 반환되어야 한다")
    public void countSpecificPiece() {

        board.initialize();

        assertEquals(8, board.getSpecificPieceCount(Color.BLACK, Type.PAWN));
        assertEquals(8, board.getSpecificPieceCount(Color.WHITE, Type.PAWN));
        assertEquals(2, board.getSpecificPieceCount(Color.BLACK, Type.ROOK));
        assertEquals(2, board.getSpecificPieceCount(Color.WHITE, Type.ROOK));
        assertEquals(2, board.getSpecificPieceCount(Color.BLACK, Type.KNIGHT));
        assertEquals(2, board.getSpecificPieceCount(Color.WHITE, Type.KNIGHT));
        assertEquals(2, board.getSpecificPieceCount(Color.BLACK, Type.BISHOP));
        assertEquals(2, board.getSpecificPieceCount(Color.WHITE, Type.BISHOP));
        assertEquals(1, board.getSpecificPieceCount(Color.BLACK, Type.QUEEN));
        assertEquals(1, board.getSpecificPieceCount(Color.WHITE, Type.QUEEN));
        assertEquals(1, board.getSpecificPieceCount(Color.BLACK, Type.KING));
        assertEquals(1, board.getSpecificPieceCount(Color.WHITE, Type.KING));

    }

    @Test
    @DisplayName("보드 내의 입력한 좌표에 해당하는 기물을 반환해야 한다.")
    public void findPiece() throws InvalidPositionException {

        board.initialize();

        assertTrue(Rook.createBlack().equals(findPiece(new Position("a8"))));
        assertTrue(Pawn.createBlack().equals(findPiece(new Position("c7"))));
        assertTrue(Pawn.createWhite().equals(findPiece(new Position("e2"))));
        assertTrue(Knight.createBlack().equals(findPiece(new Position("g8"))));
        assertTrue(Knight.createWhite().equals(findPiece(new Position("b1"))));
        assertTrue(Bishop.createBlack().equals(findPiece(new Position("c8"))));
        assertTrue(Bishop.createWhite().equals(findPiece(new Position("f1"))));
        assertTrue(Queen.createBlack().equals(findPiece(new Position("d8"))));
        assertTrue(Queen.createWhite().equals(findPiece(new Position("d1"))));
        assertTrue(King.createBlack().equals(findPiece(new Position("e8"))));
        assertTrue(King.createWhite().equals(findPiece(new Position("e1"))));

    }

    Piece findPiece(Position position){
        return board.findPiece(position.getX(), position.getY());
    }

    @Test
    @DisplayName("빈 체스판을 생성하고 원하는 좌표에 기물을 배치할 수 있어야 한다.")
    public void add() throws InvalidPositionException {
        //빈 체스판 생성
        board.emptyInitialize();
        verifyAdd(King.createWhite(), "b5");
        verifyAdd(Pawn.createWhite(), "c8");
        verifyAdd(Bishop.createWhite(), "d4");
    }

    private void verifyAdd(Piece piece, String position) throws InvalidPositionException {
        Position target = new Position(position);

        board.setPiece(target.getY(), target.getX(), piece);
        assertEquals(piece, board.findPiece(target.getX(), target.getY()));
    }

}