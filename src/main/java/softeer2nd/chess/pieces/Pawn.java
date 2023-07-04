package softeer2nd.chess.pieces;
public class Pawn {
    public final static String WHITE_COLOR="white";
    public final static String BLACK_COLOR="black";
    public final static char WHITE_REPRESENTATION='p';
    public final static char BLACK_REPRESENTATION='P';
    private String color;

    private char representation;

    public Pawn(){
        this.color= WHITE_COLOR;
    }
    public Pawn(String color){
        this.color=color;
    }

    public Pawn(String color,char representation){
        this.color=color;
        this.representation=representation;
    }

    public String getColor(){
        return this.color;
    }

    public char getRepresentation(){
        return this.representation;
    }
}
