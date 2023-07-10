package softeer2nd.chess;

import softeer2nd.chess.exception.InvalidPositionException;
import softeer2nd.chess.pieces.Blank;
import softeer2nd.chess.pieces.Piece;
import softeer2nd.chess.utils.PositionUtils;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.stream.IntStream;

public class Game {

    private Board board;
    private final static String ROW = "row";
    private final static String COLUMN = "column";
    private final static int ROW_LENGTH = 8;
    private final static int COLUMN_LENGTH = 8;

    public void start() {
        board = new Board();
    }

    public void initBoard() {
        board.initialize();
    }

    public void initEmpty() {
        board.emptyInitialize();
    }

    public String showBoard() {
        return board.getBoardRepresentation();
    }

    //기물 이동, 배치 관련 메소드

    public void move(String sourcePosition, String targetPosition) throws InvalidPositionException {
        Piece piece = board.findPiece(sourcePosition);


        putPieceOnTarget(targetPosition, piece);
        initSourcePiece(sourcePosition);

    }


    private void initSourcePiece(String sourcePosition) throws InvalidPositionException {

        putPieceOnTarget(sourcePosition, Blank.create());

    }

    public void putPieceOnTarget(String targetPosition, Piece piece) throws InvalidPositionException {

        HashMap<String, Integer> targetRowAndCol = PositionUtils.getRowAndCol(targetPosition);

        int targetRow = targetRowAndCol.get(ROW).intValue();
        int targetColumn = targetRowAndCol.get(COLUMN).intValue();

        board.setPiece(targetRow, targetColumn, piece);

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
                Piece.Type pieceType = piece.getType();
                Piece.Color pieceColor = piece.getColor();

                if (!pieceType.equals(Piece.Type.PAWN) && pieceColor.equals(color)) {
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
                        .filter(col -> board.getPiece(row, col).isEqualColorAndType(color, Piece.Type.PAWN))
                        .forEach(col -> columns.set(col, columns.get(col) + 1)));
    }

    private double getPawnsPoint(ArrayList<Integer> columns) {

        double point = columns.stream()
                .mapToDouble(Integer::doubleValue)
                .map(columnPoint-> columnPoint>1? columnPoint/2.0:columnPoint)
                .sum();

        return point;
    }

}
