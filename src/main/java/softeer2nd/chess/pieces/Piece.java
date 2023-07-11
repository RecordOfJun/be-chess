package softeer2nd.chess.pieces;

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

    public abstract void checkPieceMove(String sourcePosition, String targetPosition) throws InvalidDirectionException,InvalidPositionException;


    protected void checkSliding(int xDegree, int yDegree, char representation) throws InvalidDirectionException{
        int largerDegree=Math.max(Math.abs(xDegree), Math.abs(yDegree));

        if(xDegree==0 && yDegree==0){
            throw new InvalidDirectionException("제자리 이동은 불가능합니다!");
        }

        for (Direction direction : getDirections()) {
            if(direction.getYDegree()*largerDegree==xDegree && direction.getXDegree()*largerDegree==yDegree){
                return;
            }
        }

        throw new InvalidDirectionException(representation+"(은)는 해당 위치로 이동할 수 없습니다!");
    }

    protected void checkNonSliding(int xDegree, int yDegree, char representation) throws InvalidDirectionException{

        if(xDegree==0 && yDegree==0){
            throw new InvalidDirectionException("제자리 이동은 불가능합니다!");
        }

        for (Direction direction : getDirections()) {
            if(direction.getXDegree()==xDegree && direction.getYDegree()==yDegree){
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

    private boolean isEqualColor(Color color) {
        if (this.color.equals(color)) {
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
