package softeer2nd.chess;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import softeer2nd.chess.Position;
import softeer2nd.chess.exception.InvalidPositionException;

import java.util.ArrayList;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

class PositionTest {

    @Test
    @DisplayName("source와 target을 받으면 x,y차이 값을 Position형식으로 리턴 해줘야한다")
    void degree() throws InvalidPositionException{
        verifyGetDegree(0,1,"d2","d3");
        verifyGetDegree(0,-1,"d3","d2");
        verifyGetDegree(1,0,"d3","e3");
        verifyGetDegree(-1,0,"e3","d3");
        verifyGetDegree(1,1,"d3","e4");
        verifyGetDegree(1,-1,"d3","e2");
        verifyGetDegree(-1,1,"d3","c4");
        verifyGetDegree(-1,-1,"d3","c2");
    }

    void verifyGetDegree(int xDegree, int yDegree, String sourcePosition, String targetPosition) throws InvalidPositionException {
        Position degree=Position.getDirection(new Position(sourcePosition), new Position(targetPosition));

        assertEquals(xDegree,degree.getX());
        assertEquals(yDegree,degree.getY());

    }
    @Test
    @DisplayName("source와 target을 넣으면 그 사이의 경로가 반환되어야 한다")
    void path() throws InvalidPositionException{
        List<Position> positions=new ArrayList<>();
        positions.add(new Position("a7"));
        positions.add(new Position("a6"));
        positions.add(new Position("a5"));
        positions.add(new Position("a4"));
        positions.add(new Position("a3"));
        positions.add(new Position("a2"));
//        Position.getPath(new Position("a8"),new Position("a1")).stream().forEach(position -> {
//            System.out.println(position.getX());
//            System.out.println(position.getY());
//        });
        assertTrue(Position.getPath(new Position("a8"),new Position("a1")).equals(positions));
    }
}