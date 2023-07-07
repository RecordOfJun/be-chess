package softeer2nd.chess;

import softeer2nd.chess.exception.InvalidPositionException;
import softeer2nd.chess.pieces.Piece;
import softeer2nd.chess.utils.PositionUtils;

import java.util.*;

 class PieceComparator implements Comparator<Piece> {
    @Override
    public int compare(Piece p1, Piece p2){
        double point1=p1.getType().getPoint();
        double point2=p2.getType().getPoint();

        if (point1 > point2) {
            return 1;
        } else if (point1 < point2) {
            return -1;
        }
        return 0;
    }
}

public class Board {
    private List<Rank> ranks;

    private List<Piece> whitePieces;

    private List<Piece> blackPieces;




    //보드 초기화 메소드
    public void initialize(){
        initList();
        addBlackPieces();
        addBlanks();
        addWhitePieces();
    }

    public void emptyInitialize(){
        initList();
        for (int i = 0; i < 8; i++) {
            ranks.add(Rank.createEmpty());
        }
    }

    private void initList(){
        ranks =new ArrayList<>();
    }

    private void addBlackPieces(){//하드코딩 스러움,0 1 별로
        ranks.add(Rank.createBlackPieces());
        ranks.add(Rank.createBlackPawns());
    }

    private void addWhitePieces(){
        ranks.add(Rank.createWhitePawns());
        ranks.add(Rank.createWhitePieces());
    }

    private void addBlanks(){
        for (int i = 0; i < 4; i++) {
            ranks.add(Rank.createEmpty());
        }
    }
    


    //기물 리스트 정렬

    public String ascendingBlackPieces(){
        getBlackPieces();
        Collections.sort(blackPieces,new PieceComparator());
        return getPiecesRepresentation(blackPieces);
    }

    public String ascendingWhitePieces(){
        getWhitePieces();
        Collections.sort(whitePieces,new PieceComparator());
        return getPiecesRepresentation(whitePieces);
    }

    public String descendingBlackPieces(){
        getBlackPieces();
        Collections.sort(blackPieces,new PieceComparator().reversed());
        return getPiecesRepresentation(blackPieces);
    }

    public String descendingWhitePieces(){
        getWhitePieces();
        Collections.sort(whitePieces,new PieceComparator().reversed());
        return getPiecesRepresentation(whitePieces);
    }




    //get, set
    public void setPiece(int targetRow, int targetColumn, Piece piece){
        ranks.get(targetRow).setPiece(targetColumn,piece);
    }

    public Piece getPiece(int row, int column){
        return ranks.get(row).getPiece(column);
    }

    public Piece findPiece(String position) throws InvalidPositionException{

        HashMap<String,Integer> rowAndCol= PositionUtils.getRowAndCol(position);

        int row=rowAndCol.get("row").intValue();
        int column=rowAndCol.get("column").intValue();

        return ranks.get(row).getPiece(column);
    }

    private void getBlackPieces(){
        blackPieces=new ArrayList<>();

        for (Rank rank : ranks) {
            blackPieces.addAll(rank.getBlackPieces());
        }
    }

    private void getWhitePieces(){
        whitePieces=new ArrayList<>();

        for (Rank rank : ranks) {
            whitePieces.addAll(rank.getWhitePieces());
        }
    }

    public String getBoardRepresentation(){
        StringBuilder boardBuilder=new StringBuilder();

        for (Rank rank : ranks) {
            boardBuilder.append(rank.getRankRepresentation());
        }

        return boardBuilder.toString();
    }

    private String getPiecesRepresentation(List<Piece> pieces){

        StringBuilder representationBuilder=new StringBuilder();

        for (Piece piece : pieces) {
            representationBuilder.append(piece.getRepresentation());
        }

        return representationBuilder.toString();
    }

    public int getPieceCount(){
        int count=0;

        for (Rank rank : ranks) {
            count+=rank.getPieceCount();
        }

        return count;
    }

    public int getSpecificPieceCount(Piece.Color color, Piece.Type type){
        int count=0;

        for (Rank rank : ranks) {
            count+=rank.getSpecificPieceCount(color, type);
        }

        return count;
    }
}
