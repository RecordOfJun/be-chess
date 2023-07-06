package softeer2nd.chess;

import softeer2nd.chess.pieces.Piece;
import softeer2nd.chess.utils.PositionUtils;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;

public class Board {
    private ArrayList<Rank> board;
    public void initialize(){
        initList();
        addBlackPieces();
        addBlanks();
        addWhitePieces();
    }

    public void emptyInitialize(){
        initList();
        for (int i = 0; i < 8; i++) {
            board.add(Rank.createEmpty());
        }
    }

    private void initList(){
        board =new ArrayList<>();
    }

    private void addBlackPieces(){//하드코딩 스러움,0 1 별로
        board.add(Rank.createBlackPieces());
        board.add(Rank.createBlackPawns());
    }

    private void addWhitePieces(){
        board.add(Rank.createWhitePawns());
        board.add(Rank.createWhitePieces());
    }

    private void addBlanks(){
        for (int i = 0; i < 4; i++) {
            board.add(Rank.createEmpty());
        }
    }
    
    public int pieceCount(){
        int count=0;

        for (Rank rank : board) {
            count+=rank.getPieceCount();
        }

        return count;
    }

    public String showBoard(){
        StringBuilder boardBuilder=new StringBuilder();

        for (Rank rank : board) {
            boardBuilder.append(rank.getRankRepresentation());
        }

        return  boardBuilder.toString();
    }

    public int getSpecificPieceCount(Piece.Color color, Piece.Type type){
        int count=0;

        for (Rank rank : board) {
            count+=rank.getSpecificPieceCount(color, type);
        }

        return count;
    }

    //포지션은 항상 완벽하다고 가정
    public Piece findPiece(String position){
        HashMap<String,Integer> rowAndCol= PositionUtils.getRowAndCol(position);

        int row=rowAndCol.get("row").intValue();
        int column=rowAndCol.get("column").intValue();

        return board.get(row).findPiece(column);
    }

    public void move(String position, Piece piece){
        HashMap<String,Integer> rowAndCol= PositionUtils.getRowAndCol(position);

        int row=rowAndCol.get("row").intValue();
        int column=rowAndCol.get("column").intValue();

        board.get(row).move(column, piece);
    }

    public double calculatePoint(Piece.Color color){
        double point=0;

        point+=calculatePiecePoint(color);



        return point;
    }

    private double calculatePiecePoint(Piece.Color color){
        double point=0;

        for (Rank rank : board) {
            point+=rank.calculatePiecePoint(color);
        }

        return point;
    }

    private double calculatePawnPoint(Piece.Color color){
        double point=0;

        ArrayList<Integer> columns=new ArrayList<>(Arrays.asList(0,0,0,0,0,0,0,0));


    }

    private void findPawns(ArrayList<Integer> columns){

        for (int i = 0; i < 8; i++) {
            for (int j = 0; j < 8; j++) {

                Piece piece=board.get(i).findPiece(j);

                if(piece.isEqualColorAndType(color, Piece.Type.PAWN)){

                    columns.set(j,columns.get(j)+1);
                }
            }
        }
    }

    private double getPawnPoint(ArrayList<Integer> columns){
        double point=0;

        for (Integer count : columns) {

            if(count>1){
                point+=count/2;
            }

        }
    }
}
