package softeer2nd.chess;

import softeer2nd.chess.pieces.Pawn;

import java.util.ArrayList;

public class Board {
    private ArrayList<Pawn> pawnList=new ArrayList<>();

    public void add(Pawn pawn){
        pawnList.add(pawn);
    }

    public int size(){
        return pawnList.size();
    }

    public Pawn findPawn(int index){
        return pawnList.get(index);
    }
}
