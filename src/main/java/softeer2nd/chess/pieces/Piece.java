package softeer2nd.chess.pieces;

import softeer2nd.chess.Position;
import softeer2nd.chess.exception.InvalidDirectionException;
import softeer2nd.chess.exception.InvalidPositionException;

import java.util.List;
import java.util.Objects;

public abstract class Piece {

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

    private List<Direction> directions;

    public enum Color {
        WHITE, BLACK, NOCOLOR;

        public Color getOppositeColor(){
            if(this.equals(WHITE)){
                return BLACK;
            }

            return WHITE;
        }
    }

    protected Piece() {
        this.color = Piece.Color.NOCOLOR;
        this.type = Type.NO_PIECE;
    }

    protected Piece(Piece.Color color, Type type, List<Direction> directions) {
        this.color = color;
        this.type = type;
        this.directions = directions;
    }

    public abstract void checkPieceMove(Position sourcePosition, Position targetPosition) throws InvalidDirectionException;


    protected void checkSliding(Position position, char representation) throws InvalidDirectionException{
        int largerDegree=Math.max(Math.abs(position.getX()), Math.abs(position.getY()));

        checkDirection(position,representation,largerDegree);
    }

    protected void checkNonSliding(Position position, char representation) throws InvalidDirectionException{
        checkDirection(position,representation,1);
    }

    private void checkDirection(Position position, char representation, int largerDegree) throws InvalidDirectionException {
        if(position.getX()==0 && position.getY()==0){
            throw new InvalidDirectionException("제자리 이동은 불가능합니다!");
        }

        for (Direction direction : getDirections()) {
            if(direction.getXDegree()*largerDegree==position.getX() && direction.getYDegree()*largerDegree==position.getY()){
                return;
            }
        }

        throw new InvalidDirectionException(representation+"(은)는 해당 위치로 이동할 수 없습니다!");
    }



    public Color getColor() {
        return this.color;
    }

    public Type getType() {
        return this.type;
    }

    public double getPoint(){return this.type.getPoint();}

    public List<Direction> getDirections() {
        return this.directions;
    }

    public char getRepresentation() {

        if (this.color.equals(Color.BLACK)) {
            return type.getBlackRepresentation();
        }

        return type.getWhiteRepresentation();
    }

    public boolean isWhite() {
        return isEqualColor(Color.WHITE);
    }

    public boolean isBlack() {
        return isEqualColor(Color.BLACK);
    }

    public boolean isEqualColor(Color color) {
        if (this.color.equals(color)) {
            return true;
        }

        return false;
    }

    public boolean isEqualType(Type type) {
        if (this.type.equals(type)) {
            return true;
        }

        return false;
    }

    public boolean isPiece() {

        if (this.type.equals(Type.NO_PIECE)) {
            return false;
        }

        return true;
    }

    public boolean isEqualColorAndType(Color color, Type type) {

        if (this.color.equals(color) && this.type.equals(type)) {
            return true;
        }

        return false;
    }


}
