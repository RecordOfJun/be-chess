package softeer2nd.chess.pieces;

import java.util.List;

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
