package softeer2nd.chess;

import softeer2nd.chess.pieces.Color;
import softeer2nd.chess.pieces.Piece;
import softeer2nd.chess.pieces.Type;

import java.util.*;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

public class Board {
    private List<Rank> ranks;

    private List<Piece> whitePieces;

    private List<Piece> blackPieces;


    //보드 초기화 메소드
    public void initialize() {
        initList();
        addBlackPieces();
        addBlanks();
        addWhitePieces();
    }

    public void emptyInitialize() {
        initList();
        IntStream.range(0, 8)
                .forEach(row -> ranks.add(Rank.createEmpty()));
    }

    //count,point get

    public int getPieceCount() {
        return ranks.stream()
                .mapToInt(Rank::getPieceCount)
                .sum();
    }

    public int getSpecificPieceCount(Color color, Type type) {
        return ranks.stream()
                .mapToInt(rank -> rank.getSpecificPieceCount(color,type))
                .sum();
    }

    public double getPiecesPoint(Color color){
        return ranks.stream()
                .mapToDouble(rank-> rank.getRankPoint(color))
                .sum();
    }

    //기물 리스트 정렬

    public String ascendingBlackPieces() {
        getBlackPieces();
        blackPieces.sort(Comparator.comparingDouble(Piece::getPoint));
        return getPiecesRepresentation(blackPieces);
    }

    public String ascendingWhitePieces() {
        getWhitePieces();
        whitePieces.sort(Comparator.comparingDouble(Piece::getPoint));
        return getPiecesRepresentation(whitePieces);
    }

    public String descendingBlackPieces() {
        getBlackPieces();
        blackPieces.sort(Comparator.comparingDouble(Piece::getPoint).reversed());
        return getPiecesRepresentation(blackPieces);
    }

    public String descendingWhitePieces() {
        getWhitePieces();
        whitePieces.sort(Comparator.comparingDouble(Piece::getPoint).reversed());
        return getPiecesRepresentation(whitePieces);
    }

    //get, set
    public void setPiece(int targetRow, int targetColumn, Piece piece) {
        ranks.get(targetRow).setPiece(targetColumn, piece);
    }

    public Piece getPiece(int row, int column) {
        return ranks.get(row).getPiece(column);
    }

    public Piece findPiece(Position sourcePosition) {
        return ranks.get(sourcePosition.getY()).getPiece(sourcePosition.getX());
    }


    private void initList() {
        ranks = new ArrayList<>();
    }

    private void addBlackPieces() {//하드코딩 스러움,0 1 별로
        ranks.add(Rank.createBlackPieces());
        ranks.add(Rank.createBlackPawns());
    }

    private void addWhitePieces() {
        ranks.add(Rank.createWhitePawns());
        ranks.add(Rank.createWhitePieces());
    }

    private void addBlanks() {
        IntStream.range(0,4)
                .mapToObj(index->Rank.createEmpty())
                .forEach(ranks::add);
    }

    private void getBlackPieces() {
        blackPieces = ranks.stream()
                .flatMap(rank -> rank.getBlackPieces().stream())
                .collect(Collectors.toList());
    }

    private void getWhitePieces() {
        whitePieces = ranks.stream()
                .flatMap(rank -> rank.getWhitePieces().stream())
                .collect(Collectors.toList());
    }

    public String getBoardRepresentation() {
        StringBuilder boardBuilder = new StringBuilder();

        ranks.stream()
                .map(Rank::getRankRepresentation)
                .forEach(boardBuilder::append);

        return boardBuilder.toString();
    }

    private String getPiecesRepresentation(List<Piece> pieces) {
        StringBuilder representationBuilder = new StringBuilder();

        pieces.stream()
                .map(Piece::getRepresentation)
                .forEach(representationBuilder::append);

        return representationBuilder.toString();
    }
}
