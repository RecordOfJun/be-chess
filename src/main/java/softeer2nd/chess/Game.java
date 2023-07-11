package softeer2nd.chess;

import softeer2nd.chess.exception.*;
import softeer2nd.chess.pieces.Blank;
import softeer2nd.chess.pieces.Piece;
import softeer2nd.chess.pieces.Type;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.stream.IntStream;

public class Game {

    private Board board;
    private Piece.Color sequence;
    private final static int ROW_LENGTH = 8;
    private final static int COLUMN_LENGTH = 8;

    public void start() {
        board = new Board();
    }

    public void initBoard() {
        board.initialize();
        sequence = Piece.Color.WHITE;
    }

    public void initEmpty() {
        board.emptyInitialize();
    }

    public String showBoard() {
        return board.getBoardRepresentation();
    }

    //기물 이동, 배치 관련 메소드

    public void move(String source, String target) throws InvalidPositionException, InvalidDirectionException, InvalidSequenceException, PieceDuplicationException,InvalidPathException {
        Position sourcePosition = new Position(source);
        Position targetPosition = new Position(target);

        Piece piece = board.findPiece(sourcePosition);
        checkMoveExceptions(piece,sourcePosition,targetPosition);
        movePiece(piece, sourcePosition, targetPosition);
    }

    private void checkMoveExceptions(Piece piece, Position sourcePosition, Position targetPosition) throws InvalidDirectionException, InvalidSequenceException, PieceDuplicationException,InvalidPathException{
        piece.checkPieceMove(sourcePosition, targetPosition);
        checkSequence(piece);
        checkTargetPosition(targetPosition);
        checkPath(piece, sourcePosition, targetPosition);
    }

    private void movePiece(Piece piece, Position sourcePosition, Position targetPosition){
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

    //점수 관련 메소드

    public double calculatePoint(Piece.Color color) {
        return calculatePiecesPoint(color) + calculatePawnsPoint(color);
    }

    private double calculatePiecesPoint(Piece.Color color) {

        double point = 0;

        for (int row = 0; row < ROW_LENGTH; row++) {
            for (int col = 0; col < COLUMN_LENGTH; col++) {
                Piece piece = board.getPiece(row, col);
                Type pieceType = piece.getType();
                Piece.Color pieceColor = piece.getColor();

                if (!pieceType.equals(Type.PAWN) && pieceColor.equals(color)) {
                    point += pieceType.getPoint();
                }
            }
        }

        return point;
    }

    private double calculatePawnsPoint(Piece.Color color) {

        ArrayList<Integer> columns = new ArrayList<>(Arrays.asList(0, 0, 0, 0, 0, 0, 0, 0));
        findPawns(columns, color);

        return getPawnsPoint(columns);
    }

    private void findPawns(ArrayList<Integer> columns, Piece.Color color) {

        IntStream.range(0, ROW_LENGTH)
                .forEach(row -> IntStream.range(0, COLUMN_LENGTH)
                        .filter(col -> board.getPiece(row, col).isEqualColorAndType(color, Type.PAWN))
                        .forEach(col -> columns.set(col, columns.get(col) + 1)));
    }

    private double getPawnsPoint(ArrayList<Integer> columns) {

        double point = columns.stream()
                .mapToDouble(Integer::doubleValue)
                .map(columnPoint -> columnPoint > 1 ? columnPoint / 2.0 : columnPoint)
                .sum();

        return point;
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
        Piece piece = board.findPiece(targetPosition);

        if (piece.isEqualColor(sequence)) {
            throw new PieceDuplicationException("해당 좌표에 이미 같은 색의 기물이 존재합니다!");
        }
    }

    private void checkPath(Piece piece, Position sourcePosition, Position targetPosition) throws InvalidPathException {
        if (piece.isEqualType(Type.KNIGHT)) {
            return;
        }

        List<Position> path = Position.getPath(sourcePosition, targetPosition);
        if (path.stream().anyMatch(position -> board.findPiece(position).isPiece())) {
            throw new InvalidPathException("해당 경로상에 기물이 위치해 있습니다!");
        }
    }

}
