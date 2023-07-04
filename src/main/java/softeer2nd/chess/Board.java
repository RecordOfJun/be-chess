package softeer2nd.chess;

import softeer2nd.chess.pieces.Piece;

import java.util.ArrayList;

import static softeer2nd.chess.utils.StringUtils.appendNewLine;

public class Board {
    private ArrayList<ArrayList<Piece>> pieceList=new ArrayList<ArrayList<Piece>>();

    private final static String emptyLine="........";

    public void initialize(){
        initList();
        addBlackPieces();
        addWhitePieces();
    }

    private void initList(){
        for (int i = 0; i < 8; i++) {
            pieceList.add(new ArrayList<Piece>());
        }
    }

    private void addBlackPieces(){
        pieceList.get(0).add(Piece.createBlackRook());
        pieceList.get(0).add(Piece.createBlackKnight());
        pieceList.get(0).add(Piece.createBlackBishop());
        pieceList.get(0).add(Piece.createBlackQueen());
        pieceList.get(0).add(Piece.createBlackKing());
        pieceList.get(0).add(Piece.createBlackBishop());
        pieceList.get(0).add(Piece.createBlackKnight());
        pieceList.get(0).add(Piece.createBlackRook());
        addBlackPawns();
    }

    private void addWhitePieces(){
        pieceList.get(7).add(Piece.createWhiteRook());
        pieceList.get(7).add(Piece.createWhiteKnight());
        pieceList.get(7).add(Piece.createWhiteBishop());
        pieceList.get(7).add(Piece.createWhiteQueen());
        pieceList.get(7).add(Piece.createWhiteKing());
        pieceList.get(7).add(Piece.createWhiteBishop());
        pieceList.get(7).add(Piece.createWhiteKnight());
        pieceList.get(7).add(Piece.createWhiteRook());
        addWhitePawns();
    }



    private void addBlackPawns(){
        for(int i=0;i<8;i++){
            pieceList.get(1).add(Piece.createBlackPawn());
        }
    }

    private void addWhitePawns(){
        for(int i=0;i<8;i++){
            pieceList.get(6).add(Piece.createWhitePawn());
        }
    }
    
    public int pieceCount(){
        int count=0;

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
        if(line.size()==0){
            return appendNewLine(emptyLine);
        }

        StringBuilder lineBuilder=new StringBuilder();

        for (Piece piece : line) {
            lineBuilder.append(piece.getRepresentation());
        }

        return appendNewLine(lineBuilder.toString());
    }

}
