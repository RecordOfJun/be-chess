package softeer2nd.chess.pieces;
public class Piece {
    public final static String WHITE_COLOR="white";
    public final static String BLACK_COLOR="black";
    public final static char WHITE_REPRESENTATION='p';
    public final static char BLACK_REPRESENTATION='P';
    private String color;

    private char representation;

    private Piece(){
        this.color=WHITE_COLOR;
        this.representation=WHITE_REPRESENTATION;
    }

    private Piece(String color, char representation){
        this.color=color;
        this.representation=representation;
    }

    public String getColor(){
        return this.color;
    }

    public char getRepresentation(){
        return this.representation;
    }

    public static Piece createWhitePawn(){
        return new Piece(WHITE_COLOR,WHITE_REPRESENTATION);
    }

    public static Piece createBlackPawn(){
        return new Piece(BLACK_COLOR,BLACK_REPRESENTATION);
    }
}
