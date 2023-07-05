package softeer2nd.chess.pieces;
public class Piece {
    public final static String WHITE_COLOR="white";
    public final static String BLACK_COLOR="black";
    public final static char WHITE_PAWN_REPRESENTATION ='p';
    public final static char BLACK_PAWN_REPRESENTATION ='P';
    public final static char WHITE_KNIGHT_REPRESENTATION ='n';
    public final static char BLACK_KNIGHT_REPRESENTATION ='N';
    public final static char WHITE_ROOK_REPRESENTATION ='r';
    public final static char BLACK_ROOK_REPRESENTATION ='R';
    public final static char WHITE_BISHOP_REPRESENTATION ='b';
    public final static char BLACK_BISHOP_REPRESENTATION ='B';
    public final static char WHITE_QUEEN_REPRESENTATION ='q';
    public final static char BLACK_QUEEN_REPRESENTATION ='Q';
    public final static char WHITE_KING_REPRESENTATION ='k';
    public final static char BLACK_KING_REPRESENTATION ='K';

    private String color;

    private char representation;

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

    public boolean isWhite(){
        return isEqualColor(WHITE_COLOR);
    }

    public boolean isBlack(){
        return isEqualColor(BLACK_COLOR);
    }

    private boolean isEqualColor(String color){
        if(this.color.equals(color)){
            return true;
        }

        return false;
    }

    public static Piece createWhitePawn(){
        return new Piece(WHITE_COLOR, WHITE_PAWN_REPRESENTATION);
    }

    public static Piece createBlackPawn(){
        return new Piece(BLACK_COLOR, BLACK_PAWN_REPRESENTATION);
    }

    public static Piece createWhiteKnight(){
        return new Piece(WHITE_COLOR, WHITE_KNIGHT_REPRESENTATION);
    }

    public static Piece createBlackKnight(){
        return new Piece(BLACK_COLOR, BLACK_KNIGHT_REPRESENTATION);
    }
    public static Piece createWhiteRook(){
        return new Piece(WHITE_COLOR, WHITE_ROOK_REPRESENTATION);
    }

    public static Piece createBlackRook(){
        return new Piece(BLACK_COLOR, BLACK_ROOK_REPRESENTATION);
    }

    public static Piece createWhiteBishop(){
        return new Piece(WHITE_COLOR, WHITE_BISHOP_REPRESENTATION);
    }

    public static Piece createBlackBishop(){
        return new Piece(BLACK_COLOR, BLACK_BISHOP_REPRESENTATION);
    }
    public static Piece createWhiteQueen(){
        return new Piece(WHITE_COLOR, WHITE_QUEEN_REPRESENTATION);
    }

    public static Piece createBlackQueen(){
        return new Piece(BLACK_COLOR, BLACK_QUEEN_REPRESENTATION);
    }

    public static Piece createWhiteKing(){
        return new Piece(WHITE_COLOR, WHITE_KING_REPRESENTATION);
    }

    public static Piece createBlackKing(){
        return new Piece(BLACK_COLOR, BLACK_KING_REPRESENTATION);
    }


}
