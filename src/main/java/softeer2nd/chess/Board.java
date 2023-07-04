package softeer2nd.chess;

import softeer2nd.chess.pieces.Piece;

import java.util.ArrayList;

public class Board {
    private ArrayList<Piece> blackPawnList=new ArrayList<>();
    private ArrayList<Piece> whitePawnList=new ArrayList<>();

    private final static String emptyLine="........";

    public void initialize(){
        addBlackPawns();
        addWhitePawns();
    }

    private void addBlackPawns(){
        for(int i=0;i<8;i++){
            blackPawnList.add(Piece.createBlackPawn());
        }
    }

    private void addWhitePawns(){
        for(int i=0;i<8;i++){
            whitePawnList.add(Piece.createWhitePawn());
        }
    }

    public String getBlackPawnsResult(){
        return getPawnsResult(blackPawnList);
    }

    public String getWhitePawnsResult(){
        return getPawnsResult(whitePawnList);
    }

    private String getPawnsResult(ArrayList<Piece> pawnList){
        StringBuilder pawnsResult=new StringBuilder("");

        for (Piece pawn : pawnList) {
            pawnsResult.append(pawn.getRepresentation());
        }
        return pawnsResult.toString();
    }

    public void printBoard(){
        System.out.println(buildBoard());
    }

    private String buildBoard(){
        StringBuilder board=new StringBuilder();
        appendLine(board,emptyLine);
        appendLine(board,getBlackPawnsResult());
        appendLine(board,emptyLine);
        appendLine(board,emptyLine);
        appendLine(board,emptyLine);
        appendLine(board,emptyLine);
        appendLine(board,getWhitePawnsResult());
        appendLine(board,emptyLine);

        return board.toString();
    }

    private void appendLine(StringBuilder board, String line){
        board.append(line+"\n");
    }

}
