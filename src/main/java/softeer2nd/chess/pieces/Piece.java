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

    private final Color color;

    private final Type type;

    private final List<Direction> directions;

    protected Piece() {
        this.color = Color.NOCOLOR;
        this.type = Type.NO_PIECE;
        this.directions = null;
    }

    protected Piece(Color color, Type type, List<Direction> directions) {
        this.color = color;
        this.type = type;
        this.directions = directions;
    }

    public abstract void checkPieceMove(Position sourcePosition, Position targetPosition) throws InvalidDirectionException;


    protected void checkSliding(Position sourcePosition, Position targetPosition, char representation) throws InvalidDirectionException {
        int xDiff = targetPosition.getX() - sourcePosition.getX();
        int yDiff = sourcePosition.getY() - targetPosition.getY();

        int largerDegree = Math.max(Math.abs(xDiff), Math.abs(yDiff));

        checkDirection(xDiff, yDiff, representation, largerDegree);
    }

    protected void checkNonSliding(Position sourcePosition, Position targetPosition, char representation) throws InvalidDirectionException {
        int xDiff = targetPosition.getX() - sourcePosition.getX();
        int yDiff = sourcePosition.getY() - targetPosition.getY();
        checkDirection(xDiff, yDiff, representation, 1);
    }

    private void checkDirection(int xDiff, int yDiff, char representation, int largerDegree) throws InvalidDirectionException {
        for (Direction direction : getDirections()) {
            if (direction.getXDegree() * largerDegree == xDiff && direction.getYDegree() * largerDegree == yDiff) {
                return;
            }
        }

        throw new InvalidDirectionException(representation + "(은)는 해당 위치로 이동할 수 없습니다!");
    }


    public Color getColor() {
        return this.color;
    }

    public Type getType() {
        return this.type;
    }

    public double getPoint() {
        return this.type.getPoint();
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

    public boolean isEqualColor(Color color) {
        return this.color.equals(color);
    }

    public boolean isEqualType(Type type) {
        return this.type.equals(type);
    }

    public boolean isPiece() {
        return !this.type.equals(Type.NO_PIECE);
    }

    public boolean isEqualColorAndType(Color color, Type type) {
        return this.color.equals(color) && this.type.equals(type);
    }


}
