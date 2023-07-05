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

    public static Rank createEmpty(){
        return buildEmptyRank();
    }

    public static Rank createBlackPawns(){
        return buildBlackPawnsRank();
    }

    public static Rank createBlackPieces(){
        return buildBlackPiecesRank();
    }

    public static Rank createWhitePawns(){
        return buildWhitePawnsRank();
    }

    public static Rank createWhitePieces(){
        return buildWhitePiecesRank();
    }


    private static Rank buildEmptyRank(){
        ArrayList<Piece> rankBuilder=new ArrayList<>();

        for(int i=RANK_FIRST_INDEX; i<RANK_SIZE;i++){
            rankBuilder.add(Piece.createBlank());
        }

        return new Rank(rankBuilder);
    }

    private static Rank buildBlackPiecesRank(){

        ArrayList<Piece> rank=new ArrayList<>();

        addBlackRook(rank);
        addBlackKnight(rank);
        addBlackBishop(rank);
        addBlackQueenAndKing(rank);

        return new Rank(rank);
    }

    private static Rank buildWhitePiecesRank(){

        ArrayList<Piece> rank=new ArrayList<>();

        addWhiteRook(rank);
        addWhiteKnight(rank);
        addWhiteBishop(rank);
        addWhiteQueenAndKing(rank);

        return new Rank(rank);
    }

    private static void addBlackRook(ArrayList<Piece> rank){
        rank.add(ROOK_SEQUENCE,Piece.createBlackRook());
        rank.add(ROOK_SEQUENCE,Piece.createBlackRook());
    }

    private static void addBlackKnight(ArrayList<Piece> rank){
        rank.add(KNIGHT_SEQUENCE,Piece.createBlackKnight());
        rank.add(KNIGHT_SEQUENCE,Piece.createBlackKnight());
    }

    private static void addBlackBishop(ArrayList<Piece> rank){
        rank.add(BISHOP_SEQUENCE,Piece.createBlackBishop());
        rank.add(BISHOP_SEQUENCE,Piece.createBlackBishop());
    }

    private static void addBlackQueenAndKing(ArrayList<Piece> rank){
        rank.add(QUEEN_SEQUENCE,Piece.createBlackQueen());
        rank.add(KING_SEQUENCE,Piece.createBlackKing());
    }

    private static void addWhiteRook(ArrayList<Piece> rank){
        rank.add(ROOK_SEQUENCE,Piece.createWhiteRook());
        rank.add(ROOK_SEQUENCE,Piece.createWhiteRook());
    }

    private static void addWhiteKnight(ArrayList<Piece> rank){
        rank.add(KNIGHT_SEQUENCE,Piece.createWhiteKnight());
        rank.add(KNIGHT_SEQUENCE,Piece.createWhiteKnight());
    }

    private static void addWhiteBishop(ArrayList<Piece> rank){
        rank.add(BISHOP_SEQUENCE,Piece.createWhiteBishop());
        rank.add(BISHOP_SEQUENCE,Piece.createWhiteBishop());
    }

    private static void addWhiteQueenAndKing(ArrayList<Piece> rank){
        rank.add(QUEEN_SEQUENCE,Piece.createWhiteQueen());
        rank.add(KING_SEQUENCE,Piece.createWhiteKing());
    }


    private static Rank buildBlackPawnsRank(){
        ArrayList<Piece> rankBuilder=new ArrayList<>();

        for(int i=RANK_FIRST_INDEX; i<RANK_SIZE;i++){
            rankBuilder.add(Piece.createBlackPawn());
        }

        return new Rank(rankBuilder);
    }

    private static Rank buildWhitePawnsRank(){
        ArrayList<Piece> rankBuilder=new ArrayList<>();

        for(int i=RANK_FIRST_INDEX; i<RANK_SIZE;i++){
            rankBuilder.add(Piece.createWhitePawn());
        }

        return new Rank(rankBuilder);
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
