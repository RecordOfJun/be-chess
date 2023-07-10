package softeer2nd.chess;

import softeer2nd.chess.pieces.Piece;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

import static softeer2nd.chess.utils.StringUtils.appendNewLine;

public class Rank {
    private List<Piece> row;

    private final static int RANK_FIRST_INDEX = 0;
    private final static int RANK_SIZE = 8;
    private final static int ROOK_SEQUENCE = 0;
    private final static int KNIGHT_SEQUENCE = 1;
    private final static int BISHOP_SEQUENCE = 2;
    private final static int QUEEN_SEQUENCE = 3;
    private final static int KING_SEQUENCE = 4;

    public Rank(List<Piece> row) {
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
        int count = (int) row.stream()
                .filter(piece -> piece.isPiece()).count();

        return count;
    }

    public int getSpecificPieceCount(Piece.Color color, Piece.Type type) {
        int count = (int) row.stream()
                .filter(piece -> piece.isEqualColorAndType(color, type))
                .count();

        return count;
    }

    public String getRankRepresentation() {

        StringBuilder lineBuilder = new StringBuilder();

        row.stream()
                .map(Piece::getRepresentation)
                .forEach(lineBuilder::append);

        return appendNewLine(lineBuilder.toString());
    }

    public List<Piece> getBlackPieces() {
        return getSpecificColorPieces(Piece.Color.BLACK);
    }

    public List<Piece> getWhitePieces() {
        return getSpecificColorPieces(Piece.Color.WHITE);
    }

    private List<Piece> getSpecificColorPieces(Piece.Color color) {
        List<Piece> pieces = row.stream()
                .filter(piece -> piece.isPiece() && piece.getColor().equals(color))
                .collect(Collectors.toList());

        return pieces;
    }


    //Rank 한줄을 생성하는 팩토리 메소드
    public static Rank createEmpty() {
        return buildEmptyRank();
    }

    public static Rank createBlackPawns() {
        return buildBlackPawnsRank();
    }

    public static Rank createBlackPieces() {
        return buildBlackPiecesRank();
    }

    public static Rank createWhitePawns() {
        return buildWhitePawnsRank();
    }

    public static Rank createWhitePieces() {
        return buildWhitePiecesRank();
    }


    //팩토리 메소드 구현 부분
    private static Rank buildEmptyRank() {
        List<Piece> rankBuilder = IntStream.range(RANK_FIRST_INDEX, RANK_SIZE)
                .mapToObj(index -> Piece.createBlank())
                .collect(Collectors.toList());

        return new Rank(rankBuilder);
    }

    private static Rank buildBlackPiecesRank() {

        List<Piece> rank = new ArrayList<>();

        addBlackRook(rank);
        addBlackKnight(rank);
        addBlackBishop(rank);
        addBlackQueenAndKing(rank);

        return new Rank(rank);
    }

    private static Rank buildWhitePiecesRank() {

        List<Piece> rank = new ArrayList<>();

        addWhiteRook(rank);
        addWhiteKnight(rank);
        addWhiteBishop(rank);
        addWhiteQueenAndKing(rank);

        return new Rank(rank);
    }


    //기물 생성 메소드
    private static void addBlackRook(List<Piece> rank) {
        rank.add(ROOK_SEQUENCE, Piece.createBlackRook());
        rank.add(ROOK_SEQUENCE, Piece.createBlackRook());
    }

    private static void addBlackKnight(List<Piece> rank) {
        rank.add(KNIGHT_SEQUENCE, Piece.createBlackKnight());
        rank.add(KNIGHT_SEQUENCE, Piece.createBlackKnight());
    }

    private static void addBlackBishop(List<Piece> rank) {
        rank.add(BISHOP_SEQUENCE, Piece.createBlackBishop());
        rank.add(BISHOP_SEQUENCE, Piece.createBlackBishop());
    }

    private static void addBlackQueenAndKing(List<Piece> rank) {
        rank.add(QUEEN_SEQUENCE, Piece.createBlackQueen());
        rank.add(KING_SEQUENCE, Piece.createBlackKing());
    }

    private static void addWhiteRook(List<Piece> rank) {
        rank.add(ROOK_SEQUENCE, Piece.createWhiteRook());
        rank.add(ROOK_SEQUENCE, Piece.createWhiteRook());
    }

    private static void addWhiteKnight(List<Piece> rank) {
        rank.add(KNIGHT_SEQUENCE, Piece.createWhiteKnight());
        rank.add(KNIGHT_SEQUENCE, Piece.createWhiteKnight());
    }

    private static void addWhiteBishop(List<Piece> rank) {
        rank.add(BISHOP_SEQUENCE, Piece.createWhiteBishop());
        rank.add(BISHOP_SEQUENCE, Piece.createWhiteBishop());
    }

    private static void addWhiteQueenAndKing(List<Piece> rank) {
        rank.add(QUEEN_SEQUENCE, Piece.createWhiteQueen());
        rank.add(KING_SEQUENCE, Piece.createWhiteKing());
    }


    //폰 생성 메소드
    private static Rank buildBlackPawnsRank() {
        List<Piece> rankBuilder = IntStream.range(RANK_FIRST_INDEX, RANK_SIZE)
                .mapToObj(index -> Piece.createBlackPawn())
                .collect(Collectors.toList());

        return new Rank(rankBuilder);
    }

    private static Rank buildWhitePawnsRank() {
        List<Piece> rankBuilder = IntStream.range(RANK_FIRST_INDEX, RANK_SIZE)
                .mapToObj(index -> Piece.createWhitePawn())
                .collect(Collectors.toList());

        return new Rank(rankBuilder);
    }


}
