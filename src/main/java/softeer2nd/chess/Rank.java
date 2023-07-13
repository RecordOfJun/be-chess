package softeer2nd.chess;

import softeer2nd.chess.pieces.*;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

import static softeer2nd.chess.utils.StringUtils.appendNewLine;

public class Rank {
    private final List<Piece> row;

    private final static int RANK_FIRST_INDEX = 0;
    private final static int RANK_SIZE = 8;
    private final static int ROOK_SEQUENCE = 0;
    private final static int KNIGHT_SEQUENCE = 1;
    private final static int BISHOP_SEQUENCE = 2;
    private final static int QUEEN_SEQUENCE = 3;
    private final static int KING_SEQUENCE = 4;

    private Rank(List<Piece> row) {
        this.row = row;
    }

    //get,set
    public Piece getPiece(int column) {
        return row.get(column);
    }

    public void setPiece(int column, Piece piece) {
        row.set(column, piece);
    }

    public int getPieceCount() {
        return (int) row.stream()
                .filter(Piece::isPiece).count();
    }

    public int getSpecificPieceCount(Color color, Type type) {
        return (int) row.stream()
                .filter(piece -> piece.isEqualColorAndType(color, type))
                .count();
    }

    public String getRankRepresentation() {
        StringBuilder lineBuilder = new StringBuilder();

        row.stream()
                .map(Piece::getRepresentation)
                .forEach(lineBuilder::append);

        return appendNewLine(lineBuilder.toString());
    }

    public double getRankPoint(Color color){
        return row.stream()
                .filter(piece -> !piece.isEqualType(Type.PAWN) && piece.isEqualColor(color))
                .mapToDouble(Piece::getPoint)
                .sum();
    }

    public List<Piece> getBlackPieces() {
        return getSpecificColorPieces(Color.BLACK);
    }

    public List<Piece> getWhitePieces() {
        return getSpecificColorPieces(Color.WHITE);
    }

    private List<Piece> getSpecificColorPieces(Color color) {
        return row.stream()
                .filter(piece -> piece.isPiece() && piece.getColor().equals(color))
                .collect(Collectors.toList());
    }


    //팩토리 메소드 구현 부분
    public static Rank createEmpty() {
        List<Piece> rankBuilder = IntStream.range(RANK_FIRST_INDEX, RANK_SIZE)
                .mapToObj(index -> Blank.create())
                .collect(Collectors.toList());

        return new Rank(rankBuilder);
    }

    //폰 생성 메소드
    public static Rank createBlackPawns() {
        List<Piece> rankBuilder = IntStream.range(RANK_FIRST_INDEX, RANK_SIZE)
                .mapToObj(index -> Pawn.createBlack())
                .collect(Collectors.toList());

        return new Rank(rankBuilder);
    }

    public static Rank createWhitePawns() {
        List<Piece> rankBuilder = IntStream.range(RANK_FIRST_INDEX, RANK_SIZE)
                .mapToObj(index -> Pawn.createWhite())
                .collect(Collectors.toList());

        return new Rank(rankBuilder);
    }

    //pieces 생성 메소드

    public static Rank createBlackPieces() {

        List<Piece> rank = new ArrayList<>();

        addBlackRook(rank);
        addBlackKnight(rank);
        addBlackBishop(rank);
        addBlackQueenAndKing(rank);

        return new Rank(rank);
    }

    public static Rank createWhitePieces() {

        List<Piece> rank = new ArrayList<>();

        addWhiteRook(rank);
        addWhiteKnight(rank);
        addWhiteBishop(rank);
        addWhiteQueenAndKing(rank);

        return new Rank(rank);
    }


    //기물 생성 메소드
    private static void addBlackRook(List<Piece> rank) {
        rank.add(ROOK_SEQUENCE, Rook.createBlack());
        rank.add(ROOK_SEQUENCE, Rook.createBlack());
    }

    private static void addBlackKnight(List<Piece> rank) {
        rank.add(KNIGHT_SEQUENCE, Knight.createBlack());
        rank.add(KNIGHT_SEQUENCE, Knight.createBlack());
    }

    private static void addBlackBishop(List<Piece> rank) {
        rank.add(BISHOP_SEQUENCE, Bishop.createBlack());
        rank.add(BISHOP_SEQUENCE, Bishop.createBlack());
    }

    private static void addBlackQueenAndKing(List<Piece> rank) {
        rank.add(QUEEN_SEQUENCE, Queen.createBlack());
        rank.add(KING_SEQUENCE, King.createBlack());
    }

    private static void addWhiteRook(List<Piece> rank) {
        rank.add(ROOK_SEQUENCE, Rook.createWhite());
        rank.add(ROOK_SEQUENCE, Rook.createWhite());
    }

    private static void addWhiteKnight(List<Piece> rank) {
        rank.add(KNIGHT_SEQUENCE, Knight.createWhite());
        rank.add(KNIGHT_SEQUENCE, Knight.createWhite());
    }

    private static void addWhiteBishop(List<Piece> rank) {
        rank.add(BISHOP_SEQUENCE, Bishop.createWhite());
        rank.add(BISHOP_SEQUENCE, Bishop.createWhite());
    }

    private static void addWhiteQueenAndKing(List<Piece> rank) {
        rank.add(QUEEN_SEQUENCE, Queen.createWhite());
        rank.add(KING_SEQUENCE, King.createWhite());
    }


}
