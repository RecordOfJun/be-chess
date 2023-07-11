package softeer2nd.chess;

import softeer2nd.chess.exception.InvalidPositionException;

public class Position {
    private int x;
    private int y;

    private Position(int x, int y){
        this.x=x;
        this.y=y;
    }

    public Position(String position) throws InvalidPositionException{
        if (position.length() != 2) {
            throw new InvalidPositionException("좌표 형식에 맞지 않습니다!");
        }

        if (position.charAt(0) < 'a' || position.charAt(0) > 'h' || position.charAt(1) < '1' || position.charAt(1) > '8') {
            throw new InvalidPositionException("보드의 범위를 벗어난 좌표입니다!");
        }

        int x = position.charAt(0) - 'a';
        int y = '8' - position.charAt(1);

        this.x=x;
        this.y=y;
    }

    public int getX(){
        return this.x;
    }

    public int getY(){
        return this.y;
    }

    public static Position getDirection(Position sourcePosition, Position targetPosition) {

        int xDegree=targetPosition.getX() - sourcePosition.getX();
        int yDegree=sourcePosition.getY() - targetPosition.getY();

        return new Position(xDegree,yDegree);
    }
}
