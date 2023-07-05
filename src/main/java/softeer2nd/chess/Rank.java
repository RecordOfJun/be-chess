package softeer2nd.chess;

import softeer2nd.chess.pieces.Piece;

import java.util.ArrayList;

public class Rank {
    private ArrayList<Piece> row;

    public Rank(ArrayList<Piece> row){
        this.row=row;
    }

    public int getPieceCount(){
        int count=0;

        for (Piece piece : row) {
            if(piece.isPiece()){ count+=1; }
        }

        return count;
    }
}
