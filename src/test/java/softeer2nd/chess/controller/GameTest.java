package softeer2nd.chess.controller;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import softeer2nd.chess.Position;
import softeer2nd.chess.exception.InvalidPositionException;
import softeer2nd.chess.Game;
import softeer2nd.chess.pieces.*;

import static org.junit.jupiter.api.Assertions.*;
import static softeer2nd.chess.utils.StringUtils.appendNewLine;

class GameTest {

    Game game;

    @BeforeEach
    public void initGame(){
        game=new Game();
        game.start();
    }

    @Test
    @DisplayName("체스말이 제대로 이동하는지확인")
    public void move() throws Exception {
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

    @Test
    @DisplayName("체스판에 임의로 말을 생성하고 색깔별로 점수 계산을 할 수 있어야 한다")
    public void calculatePoint() throws InvalidPositionException {

        initEmptyBoard();

        assertEquals(15.0, game.calculatePoint(Piece.Color.BLACK), 0.01);
        assertEquals(7.0, game.calculatePoint(Piece.Color.WHITE), 0.01);

    }

    private void initEmptyBoard() throws InvalidPositionException {

        game.initEmpty();

        game.putPieceOnTarget(new Position("b6"), Pawn.createBlack());
        game.putPieceOnTarget(new Position("e6"), Queen.createBlack());
        game.putPieceOnTarget(new Position("b8"), King.createBlack());
        game.putPieceOnTarget(new Position("c8"), Rook.createBlack());

        game.putPieceOnTarget(new Position("f2"), Pawn.createWhite());
        game.putPieceOnTarget(new Position("g2"), Pawn.createWhite());
        game.putPieceOnTarget(new Position("e1"), Rook.createWhite());
        game.putPieceOnTarget(new Position("f1"), King.createWhite());
    }

}