package softeer2nd.chess.pieces;
public class Piece {
    public final static String WHITE_COLOR="white";
    public final static String BLACK_COLOR="black";

    private Type type;

    private Color color;
    public enum Color {
        WHITE, BLACK, NOCOLOR;
    }
    public enum Type {
        PAWN('p'), ROOK('r'), KNIGHT('n'),
        BISHOP('b'), QUEEN('q'), KING('k'), NO_PIECE('.');

        private char representation;

        Type(char representation){
            this.representation=representation;
        }

        public char getWhiteRepresentation(){
            return this.representation;
        }

        public char getBlackRepresentation(){
            return Character.toUpperCase(this.representation);
        }
    }

    private Piece(){
        this.color=Color.NOCOLOR;
        this.type=Type.NO_PIECE;
    }

    private Piece(Color color, Type type){
        this.color=color;
        this.type=type;
    }

    private static Piece createWhite(Type type){
        return new Piece(Color.WHITE,type);
    }

    private static Piece createBlack(Type type){
        return new Piece(Color.BLACK,type);
    }

    public Color getColor(){
        return this.color;
    }

    public Type getType(){return  this.type;}

    public char getRepresentation(){

        if(this.color.equals(Color.BLACK)){
            return type.getBlackRepresentation();
        }

        return type.getWhiteRepresentation();
    }

    public boolean isWhite(){
        return isEqualColor(Color.WHITE);
    }

    public boolean isBlack(){
        return isEqualColor(Color.BLACK);
    }

    private boolean isEqualColor(Color color){
        if(this.color.equals(color)){
            return true;
        }

        return false;
    }

    public boolean isPiece(){

        if(this.type.equals(Type.NO_PIECE)){
            return false;
        }

        return true;
    }

    public static Piece createWhitePawn(){
        return createWhite(Type.PAWN);
    }

    public static Piece createBlackPawn(){
        return createBlack(Type.PAWN);
    }

    public static Piece createWhiteKnight(){
        return createWhite(Type.KNIGHT);
    }

    public static Piece createBlackKnight(){
        return createBlack(Type.KNIGHT);
    }
    public static Piece createWhiteRook(){
        return createWhite(Type.ROOK);
    }

    public static Piece createBlackRook(){
        return createBlack(Type.ROOK);
    }

    public static Piece createWhiteBishop(){
        return createWhite(Type.BISHOP);
    }

    public static Piece createBlackBishop(){
        return createBlack(Type.BISHOP);
    }
    public static Piece createWhiteQueen(){
        return createWhite(Type.QUEEN);
    }

    public static Piece createBlackQueen(){
        return createBlack(Type.QUEEN);
    }

    public static Piece createWhiteKing(){
        return createWhite(Type.KING);
    }

    public static Piece createBlackKing(){
        return createBlack(Type.KING);
    }

    public static Piece createBlank(){
        return new Piece();
    }




}
