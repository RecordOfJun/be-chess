package softeer2nd.chess;

import softeer2nd.chess.pieces.Pawn;

import java.util.ArrayList;

public class Board {
    private ArrayList<Pawn> pawnList=new ArrayList<>();
    private ArrayList<Pawn> blackPawnList=new ArrayList<>();
    private ArrayList<Pawn> whitePawnList=new ArrayList<>();
    public void initialize(){
        for(int i=0;i<8;i++){
            Pawn black=new Pawn(Pawn.BLACK_COLOR,Pawn.BLACK_REPRESENTATION);
            blackPawnList.add(black);
        }

        for(int i=0;i<8;i++){
            Pawn white=new Pawn(Pawn.WHITE_COLOR,Pawn.WHITE_REPRESENTATION);
            whitePawnList.add(white);
        }
    }

    public void add(Pawn pawn){
        pawnList.add(pawn);
    }

    public int size(){
        return pawnList.size();
    }

    public Pawn findPawn(int index){
        return pawnList.get(index);
    }

    public String getBlackPawnsResult(){
        StringBuilder whitePawnsResult=new StringBuilder("");
        for (Pawn black : blackPawnList) {
            whitePawnsResult.append(black.getRepresentation());
        }
        return whitePawnsResult.toString();
    }

    public String getWhitePawnsResult(){
        StringBuilder whitePawnsResult=new StringBuilder("");
        for (Pawn white : whitePawnList) {
            whitePawnsResult.append(white.getRepresentation());
        }
        return whitePawnsResult.toString();
    }
}
