package softeer2nd.chess;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import softeer2nd.chess.exception.InvalidPositionException;
import softeer2nd.chess.pieces.*;
import softeer2nd.chess.utils.PositionUtils;

import java.util.HashMap;

import static org.junit.jupiter.api.Assertions.*;
import static softeer2nd.chess.utils.Constants.COLUMN;
import static softeer2nd.chess.utils.Constants.ROW;
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

        assertEquals(8, board.getSpecificPieceCount(Piece.Color.BLACK, Type.PAWN));
        assertEquals(8, board.getSpecificPieceCount(Piece.Color.WHITE, Type.PAWN));
        assertEquals(2, board.getSpecificPieceCount(Piece.Color.BLACK, Type.ROOK));
        assertEquals(2, board.getSpecificPieceCount(Piece.Color.WHITE, Type.ROOK));
        assertEquals(2, board.getSpecificPieceCount(Piece.Color.BLACK, Type.KNIGHT));
        assertEquals(2, board.getSpecificPieceCount(Piece.Color.WHITE, Type.KNIGHT));
        assertEquals(2, board.getSpecificPieceCount(Piece.Color.BLACK, Type.BISHOP));
        assertEquals(2, board.getSpecificPieceCount(Piece.Color.WHITE, Type.BISHOP));
        assertEquals(1, board.getSpecificPieceCount(Piece.Color.BLACK, Type.QUEEN));
        assertEquals(1, board.getSpecificPieceCount(Piece.Color.WHITE, Type.QUEEN));
        assertEquals(1, board.getSpecificPieceCount(Piece.Color.BLACK, Type.KING));
        assertEquals(1, board.getSpecificPieceCount(Piece.Color.WHITE, Type.KING));

    }

    @Test
    @DisplayName("보드 내의 입력한 좌표에 해당하는 기물을 반환해야 한다.")
    public void findPiece() throws InvalidPositionException {

        board.initialize();

        assertEquals(Rook.createBlack(), board.findPiece("a8"));
        assertEquals(Pawn.createBlack(), board.findPiece("c7"));
        assertEquals(Pawn.createWhite(), board.findPiece("e2"));
        assertEquals(Knight.createBlack(), board.findPiece("g8"));
        assertEquals(Knight.createWhite(), board.findPiece("b1"));
        assertEquals(Bishop.createBlack(), board.findPiece("c8"));
        assertEquals(Bishop.createWhite(), board.findPiece("f1"));
        assertEquals(Queen.createBlack(), board.findPiece("d8"));
        assertEquals(Queen.createWhite(), board.findPiece("d1"));
        assertEquals(King.createBlack(), board.findPiece("e8"));
        assertEquals(King.createWhite(), board.findPiece("e1"));

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
        HashMap<String, Integer> targetRowAndCol = PositionUtils.getRowAndCol(position);

        int row = targetRowAndCol.get(ROW).intValue();
        int column = targetRowAndCol.get(COLUMN).intValue();

        board.setPiece(row, column, piece);
        assertEquals(piece, board.findPiece(position));
    }

    @Test
    @DisplayName("보드 내의 기물을 색깔별로 저장하고 기물의 점수별로 정렬하여 출력할 수 있어야 한다.")
    public void divideColor() {
        board.initialize();

        assertEquals("QRRBBNNPPPPPPPPK", board.descendingBlackPieces());
        assertEquals("qrrbbnnppppppppk", board.descendingWhitePieces());
        assertEquals("KPPPPPPPPNNBBRRQ", board.ascendingBlackPieces());
        assertEquals("kppppppppnnbbrrq", board.ascendingWhitePieces());

    }

}