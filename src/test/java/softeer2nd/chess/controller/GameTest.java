package softeer2nd.chess.controller;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import softeer2nd.chess.Position;
import softeer2nd.chess.exception.InvalidPositionException;
import softeer2nd.chess.Game;
import softeer2nd.chess.exception.InvalidSequenceException;
import softeer2nd.chess.exception.PieceDuplicationException;
import softeer2nd.chess.pieces.*;

import static org.junit.jupiter.api.Assertions.*;
import static softeer2nd.chess.utils.StringUtils.appendNewLine;

class GameTest {

    Game game;

    @BeforeEach
    public void initGame() {
        game = new Game();
        game.start();
    }

    @Test
    @DisplayName("체스말이 제대로 이동하는지확인")
    void move() throws Exception {
        game.initBoard();

        String blankRank = appendNewLine("........");
        assertEquals(
                appendNewLine("RNBQKBNR") +
                        appendNewLine("PPPPPPPP") +
                        blankRank + blankRank + blankRank + blankRank +
                        appendNewLine("pppppppp") +
                        appendNewLine("rnbqkbnr"),
                game.showBoard());

        String sourcePosition = "b2";
        String targetPosition = "b3";
        game.move(sourcePosition, targetPosition);
        assertEquals(
                appendNewLine("RNBQKBNR") +
                        appendNewLine("PPPPPPPP") +
                        blankRank + blankRank + blankRank +
                        appendNewLine(".p......") +
                        appendNewLine("p.pppppp") +
                        appendNewLine("rnbqkbnr"),
                game.showBoard());
    }

//    @Test
//    @DisplayName("체스판에 임의로 말을 생성하고 색깔별로 점수 계산을 할 수 있어야 한다")
//    void calculatePoint() throws InvalidPositionException {
//
//        initEmptyBoard();
//
//        assertEquals(15.0, game.calculatePoint(Piece.Color.BLACK), 0.01);
//        assertEquals(7.0, game.calculatePoint(Piece.Color.WHITE), 0.01);
//
//    }
//
//    void initEmptyBoard() throws InvalidPositionException {
//
//        game.initEmpty();
//
//        game.putPieceOnTarget(new Position("b6"), Pawn.createBlack());
//        game.putPieceOnTarget(new Position("e6"), Queen.createBlack());
//        game.putPieceOnTarget(new Position("b8"), King.createBlack());
//        game.putPieceOnTarget(new Position("c8"), Rook.createBlack());
//
//        game.putPieceOnTarget(new Position("f2"), Pawn.createWhite());
//        game.putPieceOnTarget(new Position("g2"), Pawn.createWhite());
//        game.putPieceOnTarget(new Position("e1"), Rook.createWhite());
//        game.putPieceOnTarget(new Position("f1"), King.createWhite());
//    }

    @Test
    @DisplayName("특정 색의 말이 움직여지면 다음 턴에는 다른 색의 말만 움직일 수 있어야 한다")
    void checkSequence() throws Exception {
        game.initBoard();
        assertThrows(InvalidSequenceException.class, () -> game.move("a7", "a6"));
        game.move("a2","a3");
        assertThrows(InvalidSequenceException.class, () -> game.move("a3", "a4"));
    }

    @Test
    @DisplayName("같은 색의 말이 있는 곳으로는 이동할 수 없다")
    void checkDuplication() throws Exception {
        game.initBoard();
        assertThrows(PieceDuplicationException.class, () -> game.move("a1", "a2"));
        game.move("a2","a3");
        game.move("a7","a6");
        assertThrows(PieceDuplicationException.class, () -> game.move("a1", "a3"));
    }

    @Test
    @DisplayName("나이트를 제외한 기물이 이동할 때 경로상에 다른 기물이 있으면 이동할 수 없다.")
    void checkPath(){
    }

}