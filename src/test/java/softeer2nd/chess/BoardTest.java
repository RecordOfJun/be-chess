package softeer2nd.chess;

import static softeer2nd.chess.utils.StringUtils.appendNewLine;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import softeer2nd.chess.pieces.Piece;

import static org.junit.jupiter.api.Assertions.*;

class BoardTest {
    Board board;

    @BeforeEach
    public void initBoard(){

        board = new Board();
        board.initialize();

    }

    @Test
    @DisplayName("체스판 생성 확인하기")
    public void create() throws Exception{

        assertEquals(32, board.pieceCount());
        String blankRank = appendNewLine("........");
        assertEquals(
                appendNewLine("RNBQKBNR") +
                        appendNewLine("PPPPPPPP") +
                        blankRank + blankRank + blankRank + blankRank +
                        appendNewLine("pppppppp") +
                        appendNewLine("rnbqkbnr"),
                board.showBoard());
    }

    @Test
    @DisplayName("입력한 색깔을 가진 기물의 개수가 제대로 반환되어야 한다")
    public void countSpecificPiece(){

        assertEquals(8,board.getSpecificPieceCount(Piece.Color.BLACK,Piece.Type.PAWN));
        assertEquals(8,board.getSpecificPieceCount(Piece.Color.WHITE,Piece.Type.PAWN));
        assertEquals(2,board.getSpecificPieceCount(Piece.Color.BLACK,Piece.Type.ROOK));
        assertEquals(2,board.getSpecificPieceCount(Piece.Color.WHITE,Piece.Type.ROOK));
        assertEquals(2,board.getSpecificPieceCount(Piece.Color.BLACK,Piece.Type.KNIGHT));
        assertEquals(2,board.getSpecificPieceCount(Piece.Color.WHITE,Piece.Type.KNIGHT));
        assertEquals(2,board.getSpecificPieceCount(Piece.Color.BLACK,Piece.Type.BISHOP));
        assertEquals(2,board.getSpecificPieceCount(Piece.Color.WHITE,Piece.Type.BISHOP));
        assertEquals(1,board.getSpecificPieceCount(Piece.Color.BLACK,Piece.Type.QUEEN));
        assertEquals(1,board.getSpecificPieceCount(Piece.Color.WHITE,Piece.Type.QUEEN));
        assertEquals(1,board.getSpecificPieceCount(Piece.Color.BLACK,Piece.Type.KING));
        assertEquals(1,board.getSpecificPieceCount(Piece.Color.WHITE,Piece.Type.KING));

    }

    @Test
    @DisplayName("입력한 좌표에 해당하는 기물을 반환해야 한다.")
    public void findPiece(){

        assertEquals(Piece.createBlackRook(),board.findPiece("a8"));
        assertEquals(Piece.createBlackPawn(),board.findPiece("c7"));
        assertEquals(Piece.createWhitePawn(),board.findPiece("e2"));
        assertEquals(Piece.createBlackKnight(),board.findPiece("g8"));
        assertEquals(Piece.createWhiteKnight(),board.findPiece("b1"));
        assertEquals(Piece.createBlackBishop(),board.findPiece("c8"));
        assertEquals(Piece.createWhiteBishop(),board.findPiece("f1"));
        assertEquals(Piece.createBlackQueen(),board.findPiece("d8"));
        assertEquals(Piece.createWhiteQueen(),board.findPiece("d1"));
        assertEquals(Piece.createBlackKing(),board.findPiece("e8"));
        assertEquals(Piece.createWhiteKing(),board.findPiece("e1"));

    }

}