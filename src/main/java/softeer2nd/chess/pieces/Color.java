package softeer2nd.chess.pieces;

public enum Color {
    WHITE, BLACK, NOCOLOR;

    public Color getOppositeColor(){
        if(this.equals(WHITE)){
            return BLACK;
        }

        return WHITE;
    }
}
