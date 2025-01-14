package softeer2nd.chess;

import softeer2nd.chess.exception.*;
import softeer2nd.chess.pieces.Blank;
import softeer2nd.chess.pieces.Color;
import softeer2nd.chess.pieces.Piece;
import softeer2nd.chess.pieces.Type;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

public class Game {
    private Board board;
    private Color sequence;
    private final static int ROW_LENGTH = 8;
    private final static int COLUMN_LENGTH = 8;

    public void start() {
        board = new Board();
    }

    public void initBoard() {
        board.initialize();
        sequence = Color.WHITE;
    }

    public void initEmpty() {
        board.emptyInitialize();
    }

    public String showBoard() {
        return board.getBoardRepresentation();
    }

    //기물 이동, 배치 관련 메소드

    public void move(String source, String target) throws ChessException {
        Position sourcePosition = new Position(source);
        Position targetPosition = new Position(target);

        Piece piece = board.findPiece(sourcePosition.getX(), sourcePosition.getY());
        checkMoveExceptions(piece, sourcePosition, targetPosition);
        movePiece(piece, sourcePosition, targetPosition);
    }

    //점수 관련 메소드

    public double calculatePoint(Color color) {
        return calculatePiecesPoint(color) + calculatePawnsPoint(color);
    }

    private void checkMoveExceptions(Piece piece, Position sourcePosition, Position targetPosition) throws ChessException {
        checkNonMove(sourcePosition,targetPosition);
        piece.checkPieceMove(sourcePosition, targetPosition);
        checkSequence(piece);
        checkTargetPosition(targetPosition);
        checkPath(piece, sourcePosition, targetPosition);
    }

    private void movePiece(Piece piece, Position sourcePosition, Position targetPosition) {
        putPieceOnTarget(targetPosition, piece);
        initSourcePiece(sourcePosition);
        convertSequence();
    }

    private void initSourcePiece(Position sourcePosition) {
        putPieceOnTarget(sourcePosition, Blank.create());
    }

    public void putPieceOnTarget(Position targetPosition, Piece piece) {
        board.setPiece(targetPosition.getY(), targetPosition.getX(), piece);
    }

    private double calculatePiecesPoint(Color color) {
        return board.getPiecesPoint(color);
    }

    private double calculatePawnsPoint(Color color) {
        return getPawnsPoint(findPawns(color));
    }

    private List<Long> findPawns(Color color) {
        return IntStream.range(0, COLUMN_LENGTH)
                .mapToObj(col -> IntStream.range(0, ROW_LENGTH)
                        .filter(row -> board.findPiece(col, row).isEqualColorAndType(color, Type.PAWN))
                        .count())
                .collect(Collectors.toList());
    }

    private double getPawnsPoint(List<Long> columns) {
        return columns.stream()
                .mapToDouble(Long::doubleValue)
                .map(columnPoint -> columnPoint > 1 ? columnPoint / 2.0 : columnPoint)
                .sum();
    }

    private void checkSequence(Piece piece) throws InvalidSequenceException {
        if (!piece.isPiece()) {
            throw new InvalidSequenceException("빈 칸은 이동시킬 수 없습니다");
        }

        if (!piece.isEqualColor(sequence)) {
            throw new InvalidSequenceException("해당 색상을 움직일 차례가 아닙니다!");
        }
    }

    private void convertSequence() {
        sequence = sequence.getOppositeColor();
    }

    private void checkTargetPosition(Position targetPosition) throws PieceDuplicationException {
        Piece piece = board.findPiece(targetPosition.getX(), targetPosition.getY());

        if (piece.isEqualColor(sequence)) {
            throw new PieceDuplicationException("해당 좌표에 이미 같은 색의 기물이 존재합니다!");
        }
    }

    private void checkPath(Piece piece, Position sourcePosition, Position targetPosition) throws InvalidPathException {
        if (piece.isEqualType(Type.KNIGHT)) {
            return;
        }

        List<Position> path = Position.getPath(sourcePosition, targetPosition);
        if (path.stream().anyMatch(position -> board.findPiece(position.getX(), position.getY()).isPiece())) {
            throw new InvalidPathException("해당 경로상에 기물이 위치해 있습니다!");
        }
    }

    private void checkNonMove(Position sourcePosition, Position targetPosition) throws InvalidDirectionException{
        if(sourcePosition.equals(targetPosition)){
            throw new InvalidDirectionException("제자리 이동은 불가능합니다!");
        }
    }
}
