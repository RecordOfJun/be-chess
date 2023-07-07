package softeer2nd.chess;

import softeer2nd.chess.exception.InvalidPositionException;
import softeer2nd.chess.pieces.Piece;
import softeer2nd.chess.utils.PositionUtils;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;

public class Game {

    private Board board;

    public void start(){
        board=new Board();
    }

    public void initBoard(){
        board.initialize();
    }

    public void initEmpty(){
        board.emptyInitialize();
    }

    public String showBoard(){
        return board.getBoardRepresentation();
    }

    //기물 이동, 배치 관련 메소드

    public void move(String sourcePosition, String targetPosition) throws InvalidPositionException {

        putPieceOnTarget(targetPosition, board.findPiece(sourcePosition));
        initSourcePiece(sourcePosition);

    }


    private void initSourcePiece(String sourcePosition) throws InvalidPositionException{

        putPieceOnTarget(sourcePosition,Piece.createBlank());

    }

    public void putPieceOnTarget(String targetPosition, Piece piece) throws InvalidPositionException{

        HashMap<String,Integer> targetRowAndCol= PositionUtils.getRowAndCol(targetPosition);

        int targetRow=targetRowAndCol.get("row").intValue();
        int targetColumn=targetRowAndCol.get("column").intValue();

        board.setPiece(targetRow,targetColumn,piece);

    }

    //점수 관련 메소드

    public double calculatePoint(Piece.Color color){
        return calculatePiecesPoint(color) + calculatePawnsPoint(color);
    }

    private double calculatePiecesPoint(Piece.Color color){

        double point=0;

        for (int i = 0; i < 8; i++) {
            for (int j = 0; j < 8; j++) {
                Piece piece=board.getPiece(i,j);
                Piece.Type pieceType=piece.getType();
                Piece.Color pieceColor=piece.getColor();

                if(!pieceType.equals(Piece.Type.PAWN) && pieceColor.equals(color)){
                    point+=pieceType.getPoint();
                }
            }
        }

        return point;
    }

    private double calculatePawnsPoint(Piece.Color color){

        ArrayList<Integer> columns=new ArrayList<>(Arrays.asList(0,0,0,0,0,0,0,0));
        findPawns(columns,color);

        return getPawnsPoint(columns);
    }

    private void findPawns(ArrayList<Integer> columns, Piece.Color color){

        for (int i = 0; i < 8; i++) {
            for (int j = 0; j < 8; j++) {

                Piece piece= board.getPiece(i,j);

                if(piece.isEqualColorAndType(color, Piece.Type.PAWN)){

                    columns.set(j,columns.get(j)+1);
                }
            }
        }
    }

    private double getPawnsPoint(ArrayList<Integer> columns){

        double point=0;

        for (Integer count : columns) {
            double columnPoint=count.doubleValue();

            if(count>1){
                columnPoint/=2.0;
            }

            point+=columnPoint;

        }

        return point;
    }

}
