package softeer2nd.chess;

import softeer2nd.chess.pieces.Piece;

import java.util.ArrayList;

public class Board {
    private ArrayList<Rank> board;
    public void initialize(){
        initList();
        addBlackPieces();
        addBlanks();
        addWhitePieces();
    }

    private void initList(){
        board =new ArrayList<>();
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
            board.add(rank);
        }
    }

    private void addBlackPiecesWithoutPawn(){

        ArrayList<Piece> rankOne=new ArrayList<>();

        addBlackRook(rankOne);
        addBlackKnight(rankOne);
        addBlackBishop(rankOne);
        addBlackQueenAndKing(rankOne);

        Rank rank=new Rank(rankOne);
        board.add(rank);
    }

    private void addWhitePiecesWithoutPawn(){

        ArrayList<Piece> rankEight=new ArrayList<>();

        addWhiteRook(rankEight);
        addWhiteKnight(rankEight);
        addWhiteBishop(rankEight);
        addWhiteQueenAndKing(rankEight);

        Rank rank=new Rank(rankEight);
        board.add(rank);
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
        board.add(rank);
    }

    private void addWhitePawns(){
        ArrayList<Piece> rankSeven=new ArrayList<>();

        for(int i=EMPTY_SIZE; i<BOARD_LINE_SIZE;i++){
            rankSeven.add(Piece.createWhitePawn());
        }

        Rank rank=new Rank(rankSeven);
        board.add(rank);
    }
    
    public int pieceCount(){
        int count=EMPTY_SIZE;

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
}
