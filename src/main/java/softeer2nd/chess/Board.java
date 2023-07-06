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
        board.add(Rank.createBlackPieces());
        board.add(Rank.createBlackPawns());
    }

    private void addWhitePieces(){
        board.add(Rank.createWhitePawns());
        board.add(Rank.createWhitePieces());
    }

    private void addBlanks(){
        for (int i = 0; i < 4; i++) {
            board.add(Rank.createEmpty());
        }
    }
    
    public int pieceCount(){
        int count=0;

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

    public int getSpecificPieceCount(Piece.Color color, Piece.Type type){
        int count=0;

        for (Rank rank : board) {
            count+=rank.getSpecificPieceCount(color, type);
        }

        return count;
    }
}
