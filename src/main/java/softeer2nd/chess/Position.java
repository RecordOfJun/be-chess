package softeer2nd.chess;

import softeer2nd.chess.exception.InvalidPositionException;

import java.util.List;
import java.util.Objects;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

public class Position {
    private final int x;
    private final int y;

    private Position(int x, int y) {
        this.x = x;
        this.y = y;
    }

    public Position(String position) throws InvalidPositionException {
        if (position.length() != 2) {
            throw new InvalidPositionException("좌표 형식에 맞지 않습니다!");
        }

        if (position.charAt(0) < 'a' || position.charAt(0) > 'h' || position.charAt(1) < '1' || position.charAt(1) > '8') {
            throw new InvalidPositionException("보드의 범위를 벗어난 좌표입니다!");
        }

        int x = position.charAt(0) - 'a';
        int y = '8' - position.charAt(1);

        this.x = x;
        this.y = y;
    }

    public int getX() {
        return this.x;
    }

    public int getY() {
        return this.y;
    }

    public static List<Position> getPath(Position sourcePosition, Position targetPosition) {
        int xDiff = targetPosition.getX() - sourcePosition.getX();
        int yDiff = sourcePosition.getY() - targetPosition.getY();

        int size = Math.max(Math.abs(xDiff), Math.abs(yDiff));
        int xDirection = xDiff / size;
        int yDirection = yDiff / size;

        return IntStream.range(1, size)
                .mapToObj(index -> new Position(sourcePosition.getX() + xDirection * index, sourcePosition.getY() - yDirection * index))
                .collect(Collectors.toList());
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Position position = (Position) o;
        return x == position.x && y == position.y;
    }

    @Override
    public int hashCode() {
        return Objects.hash(x, y);
    }
}
