package softeer2nd.chess;

import softeer2nd.chess.pieces.Pawn;

import java.util.ArrayList;

public class Board {
    private ArrayList<Pawn> pawnList=new ArrayList<>();
    private ArrayList<Pawn> blackPawnList=new ArrayList<>();
    private ArrayList<Pawn> whitePawnList=new ArrayList<>();

    private final static String emptyLine="........";

    public void add(Pawn pawn){
        pawnList.add(pawn);
    }

    public int size(){
        return pawnList.size();
    }

    public Pawn findPawn(int index){
        return pawnList.get(index);
    }

    public void initialize(){
        initPawns(blackPawnList, Pawn.BLACK_COLOR, Pawn.BLACK_REPRESENTATION);
        initPawns(whitePawnList, Pawn.WHITE_COLOR, Pawn.WHITE_REPRESENTATION);
    }

    private void initPawns(ArrayList<Pawn> pawnList,String color, char representaion){
        for(int i=0;i<8;i++){
            Pawn pawn=new Pawn(color,representaion);
            pawnList.add(pawn);
        }
    }

    public String getBlackPawnsResult(){
        return getPawnsResult(blackPawnList);
    }

    public String getWhitePawnsResult(){
        return getPawnsResult(whitePawnList);
    }

    private String getPawnsResult(ArrayList<Pawn> pawnList){
        StringBuilder pawnsResult=new StringBuilder("");

        for (Pawn pawn : pawnList) {
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
