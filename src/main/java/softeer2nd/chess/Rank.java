package softeer2nd.chess;

import softeer2nd.chess.pieces.Piece;

import java.util.ArrayList;

import static softeer2nd.chess.utils.StringUtils.appendNewLine;

public class Rank {
    private ArrayList<Piece> row;

    private final static int RANK_FIRST_INDEX=0;
    private final static int RANK_SIZE=8;
    private final static int ROOK_SEQUENCE=0;
    private final static int KNIGHT_SEQUENCE=1;
    private final static int BISHOP_SEQUENCE=2;
    private final static int QUEEN_SEQUENCE=3;
    private final static int KING_SEQUENCE=4;

    public Rank(ArrayList<Piece> row){
        this.row=row;
    }

    public Rank createEmpty(){
        return
    }

    private Rank buildEmptyRank(){
        ArrayList<Piece> rank=new ArrayList<>();

        for(int i=RANK_FIRST_INDEX; i<RANK_SIZE;i++){
            rankTwo.add(Piece.createBlackPawn());
        }

        Rank rank=new Rank(rankTwo);
    }

    public int getPieceCount(){
        int count=0;

        for (Piece piece : row) {
            if(piece.isPiece()){ count+=1; }
        }

        return count;
    }

    public String getRankRepresentation(){

        StringBuilder lineBuilder=new StringBuilder();

        for (Piece piece : row) {
            lineBuilder.append(piece.getRepresentation());
        }

        return appendNewLine(lineBuilder.toString());
    }

}
