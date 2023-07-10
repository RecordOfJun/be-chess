package softeer2nd.chess.pieces;

import java.util.Objects;

public class Piece {

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Piece piece = (Piece) o;
        return type.equals(piece.type) && color.equals(piece.color);
    }

    @Override
    public int hashCode() {
        return Objects.hash(type, color);
    }

    private Color color;

    private Type type;

    public enum Color {
        WHITE, BLACK, NOCOLOR;
    }
    public enum Type {
        PAWN('p',1.0), ROOK('r',5.0), KNIGHT('n',2.5),
        BISHOP('b',3.0), QUEEN('q',9.0), KING('k',0.0), NO_PIECE('.',0.0);

        private char representation;

        private double point;

        Type(char representation, double point){
            this.representation=representation;
            this.point=point;
        }

        public char getWhiteRepresentation(){
            return this.representation;
        }

        public char getBlackRepresentation(){
            return Character.toUpperCase(this.representation);
        }

        public double getPoint(){ return this.point; }

    }

    private Piece(){
        this.color=Color.NOCOLOR;
        this.type=Type.NO_PIECE;
    }

    protected Piece(Color color, Type type){
        this.color=color;
        this.type=type;
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

    public boolean isEqualColorAndType(Color color,Type type){

        if(this.color.equals(color) && this.type.equals(type)){
            return true;
        }

        return false;
    }

//    private static Piece createWhite(Type type){
//        return new Piece(Color.WHITE,type);
//    }
//
//    private static Piece createBlack(Type type){
//        return new Piece(Color.BLACK,type);
//    }
//
//    public static Piece createWhitePawn(){
//        return createWhite(Type.PAWN);
//    }
//
//    public static Piece createBlackPawn(){
//        return createBlack(Type.PAWN);
//    }
//
//    public static Piece createWhiteKnight(){
//        return createWhite(Type.KNIGHT);
//    }
//
//    public static Piece createBlackKnight(){
//        return createBlack(Type.KNIGHT);
//    }
//    public static Piece createWhiteRook(){
//        return createWhite(Type.ROOK);
//    }
//
//    public static Piece createBlackRook(){
//        return createBlack(Type.ROOK);
//    }
//
//    public static Piece createWhiteBishop(){
//        return createWhite(Type.BISHOP);
//    }
//
//    public static Piece createBlackBishop(){
//        return createBlack(Type.BISHOP);
//    }
//    public static Piece createWhiteQueen(){
//        return createWhite(Type.QUEEN);
//    }
//
//    public static Piece createBlackQueen(){
//        return createBlack(Type.QUEEN);
//    }
//
//    public static Piece createWhiteKing(){
//        return createWhite(Type.KING);
//    }
//
//    public static Piece createBlackKing(){
//        return createBlack(Type.KING);
//    }
//
//    public static Piece createBlank(){
//        return new Piece();
//    }




}
