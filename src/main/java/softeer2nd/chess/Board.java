package softeer2nd.chess;

import softeer2nd.chess.pieces.Piece;

import java.util.ArrayList;

import static softeer2nd.chess.utils.StringUtils.appendNewLine;

public class Board {
    private ArrayList<ArrayList<Piece>> pieceList=new ArrayList<ArrayList<Piece>>();

    private final static String EMPTY_LINE ="........";
    private final static int EMPTY_SIZE=0;
    private final static int BOARD_LINE_SIZE=8;
    private final static int BLACK_PIECES_LINE=0;
    private final static int BLACK_PAWNS_LINE=1;
    private final static int WHITE_PIECES_LINE=7;
    private final static int WHITE_PAWNS_LINE=6;
    private final static int ROOK_SEQUENCE=0;
    private final static int KNIGHT_SEQUENCE=1;
    private final static int BISHOP_SEQUENCE=2;
    private final static int QUEEN_SEQUENCE=3;
    private final static int KING_SEQUENCE=4;
    public void initialize(){
        initList();
        addBlackPieces();
        addWhitePieces();
    }

    private void initList(){
        for (int i = BLACK_PIECES_LINE; i <=WHITE_PIECES_LINE; i++) {
            pieceList.add(new ArrayList<Piece>());
        }
    }

    private void addBlackPieces(){//하드코딩 스러움,0 1 별로
        addBlackRook();
        addBlackKnight();
        addBlackBishop();
        addBlackQueenAndKing();
        addBlackPawns();
    }

    private void addWhitePieces(){
        addWhiteRook();
        addWhiteKnight();
        addWhiteBishop();
        addWhiteQueenAndKing();
        addWhitePawns();
    }

    private void addBlackRook(){
        pieceList.get(BLACK_PIECES_LINE).add(ROOK_SEQUENCE,Piece.createBlackRook());
        pieceList.get(BLACK_PIECES_LINE).add(ROOK_SEQUENCE,Piece.createBlackRook());
    }

    private void addBlackKnight(){
        pieceList.get(BLACK_PIECES_LINE).add(KNIGHT_SEQUENCE,Piece.createBlackKnight());
        pieceList.get(BLACK_PIECES_LINE).add(KNIGHT_SEQUENCE,Piece.createBlackKnight());
    }

    private void addBlackBishop(){
        pieceList.get(BLACK_PIECES_LINE).add(BISHOP_SEQUENCE,Piece.createBlackBishop());
        pieceList.get(BLACK_PIECES_LINE).add(BISHOP_SEQUENCE,Piece.createBlackBishop());
    }

    private void addBlackQueenAndKing(){
        pieceList.get(BLACK_PIECES_LINE).add(QUEEN_SEQUENCE,Piece.createBlackQueen());
        pieceList.get(BLACK_PIECES_LINE).add(KING_SEQUENCE,Piece.createBlackKing());
    }

    private void addWhiteRook(){
        pieceList.get(WHITE_PIECES_LINE).add(ROOK_SEQUENCE,Piece.createWhiteRook());
        pieceList.get(WHITE_PIECES_LINE).add(ROOK_SEQUENCE,Piece.createWhiteRook());
    }

    private void addWhiteKnight(){
        pieceList.get(WHITE_PIECES_LINE).add(KNIGHT_SEQUENCE,Piece.createWhiteKnight());
        pieceList.get(WHITE_PIECES_LINE).add(KNIGHT_SEQUENCE,Piece.createWhiteKnight());
    }

    private void addWhiteBishop(){
        pieceList.get(WHITE_PIECES_LINE).add(BISHOP_SEQUENCE,Piece.createWhiteBishop());
        pieceList.get(WHITE_PIECES_LINE).add(BISHOP_SEQUENCE,Piece.createWhiteBishop());
    }

    private void addWhiteQueenAndKing(){
        pieceList.get(WHITE_PIECES_LINE).add(QUEEN_SEQUENCE,Piece.createWhiteQueen());
        pieceList.get(WHITE_PIECES_LINE).add(KING_SEQUENCE,Piece.createWhiteKing());
    }



    private void addBlackPawns(){
        for(int i=EMPTY_SIZE; i<BOARD_LINE_SIZE;i++){
            pieceList.get(BLACK_PAWNS_LINE).add(Piece.createBlackPawn());
        }
    }

    private void addWhitePawns(){
        for(int i=EMPTY_SIZE; i<BOARD_LINE_SIZE;i++){
            pieceList.get(WHITE_PAWNS_LINE).add(Piece.createWhitePawn());
        }
    }
    
    public int pieceCount(){
        int count=EMPTY_SIZE;

        for (ArrayList<Piece> line : pieceList) {
            count+=line.size();
        }

        return count;
    }

    public String showBoard(){
        StringBuilder boardBuilder=new StringBuilder();

        for (ArrayList<Piece> line : pieceList) {
            boardBuilder.append(getLine(line));
        }

        return  boardBuilder.toString();
    }

    private String getLine(ArrayList<Piece> line){
        if(line.size()==EMPTY_SIZE){
            return appendNewLine(EMPTY_LINE);
        }

        StringBuilder lineBuilder=new StringBuilder();

        for (Piece piece : line) {
            lineBuilder.append(piece.getRepresentation());
        }

        return appendNewLine(lineBuilder.toString());
    }

}
