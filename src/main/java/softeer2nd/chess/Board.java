package softeer2nd.chess;

import softeer2nd.chess.pieces.Piece;

import java.util.ArrayList;

import static softeer2nd.chess.utils.StringUtils.appendNewLine;

public class Board {
    private ArrayList<Rank> rankList;
    private final static String EMPTY_LINE ="........";
    private final static int EMPTY_SIZE=0;
    private final static int BOARD_LINE_SIZE=8;
    private final static int ROOK_SEQUENCE=0;
    private final static int KNIGHT_SEQUENCE=1;
    private final static int BISHOP_SEQUENCE=2;
    private final static int QUEEN_SEQUENCE=3;
    private final static int KING_SEQUENCE=4;
    public void initialize(){
        initList();
        addBlackPieces();
        addBlanks();
        addWhitePieces();
    }

    private void initList(){
        rankList=new ArrayList<>();
    }

    private void addBlackPieces(){//하드코딩 스러움,0 1 별로
        addBlackPiecesWithoutPawn();
        addBlackPawns();
    }

    private void addWhitePieces(){
        addWhitePawns();
        addWhitePiecesWithoutPawn();
    }

    private void addBlanks(){

        for (int i = 2; i < 6; i++) {

            ArrayList<Piece> pieces=new ArrayList<>();

            for (int j = 0; j < 8; j++) {
                pieces.add(Piece.createBlank());
            }

            Rank rank=new Rank(pieces);
            rankList.add(rank);
        }
    }

    private void addBlackPiecesWithoutPawn(){

        ArrayList<Piece> rankOne=new ArrayList<>();

        addBlackRook(rankOne);
        addBlackKnight(rankOne);
        addBlackBishop(rankOne);
        addBlackQueenAndKing(rankOne);

        Rank rank=new Rank(rankOne);
        rankList.add(rank);
    }

    private void addWhitePiecesWithoutPawn(){

        ArrayList<Piece> rankEight=new ArrayList<>();

        addWhiteRook(rankEight);
        addWhiteKnight(rankEight);
        addWhiteBishop(rankEight);
        addWhiteQueenAndKing(rankEight);

        Rank rank=new Rank(rankEight);
        rankList.add(rank);
    }

    private void addBlackRook(ArrayList<Piece> rankOne){
        rankOne.add(ROOK_SEQUENCE,Piece.createBlackRook());
        rankOne.add(ROOK_SEQUENCE,Piece.createBlackRook());
    }

    private void addBlackKnight(ArrayList<Piece> rankOne){
        rankOne.add(KNIGHT_SEQUENCE,Piece.createBlackKnight());
        rankOne.add(KNIGHT_SEQUENCE,Piece.createBlackKnight());
    }

    private void addBlackBishop(ArrayList<Piece> rankOne){
        rankOne.add(BISHOP_SEQUENCE,Piece.createBlackBishop());
        rankOne.add(BISHOP_SEQUENCE,Piece.createBlackBishop());
    }

    private void addBlackQueenAndKing(ArrayList<Piece> rankOne){
        rankOne.add(QUEEN_SEQUENCE,Piece.createBlackQueen());
        rankOne.add(KING_SEQUENCE,Piece.createBlackKing());
    }

    private void addWhiteRook(ArrayList<Piece> rankEight){
        rankEight.add(ROOK_SEQUENCE,Piece.createWhiteRook());
        rankEight.add(ROOK_SEQUENCE,Piece.createWhiteRook());
    }

    private void addWhiteKnight(ArrayList<Piece> rankEight){
        rankEight.add(KNIGHT_SEQUENCE,Piece.createWhiteKnight());
        rankEight.add(KNIGHT_SEQUENCE,Piece.createWhiteKnight());
    }

    private void addWhiteBishop(ArrayList<Piece> rankEight){
        rankEight.add(BISHOP_SEQUENCE,Piece.createWhiteBishop());
        rankEight.add(BISHOP_SEQUENCE,Piece.createWhiteBishop());
    }

    private void addWhiteQueenAndKing(ArrayList<Piece> rankEight){
        rankEight.add(QUEEN_SEQUENCE,Piece.createWhiteQueen());
        rankEight.add(KING_SEQUENCE,Piece.createWhiteKing());
    }



    private void addBlackPawns(){
        ArrayList<Piece> rankTwo=new ArrayList<>();

        for(int i=EMPTY_SIZE; i<BOARD_LINE_SIZE;i++){
            rankTwo.add(Piece.createBlackPawn());
        }

        Rank rank=new Rank(rankTwo);
        rankList.add(rank);
    }

    private void addWhitePawns(){
        ArrayList<Piece> rankSeven=new ArrayList<>();

        for(int i=EMPTY_SIZE; i<BOARD_LINE_SIZE;i++){
            rankSeven.add(Piece.createWhitePawn());
        }

        Rank rank=new Rank(rankSeven);
        rankList.add(rank);
    }
    
    public int pieceCount(){
        int count=EMPTY_SIZE;

        for (Rank rank : rankList) {
            count+=rank.getPieceCount();
        }

        return count;
    }

    public String showBoard(){
        StringBuilder boardBuilder=new StringBuilder();

        for (Rank rank : rankList) {
            boardBuilder.append(rank.getRankRepresentation());
        }

        return  boardBuilder.toString();
    }
}
