package softeer2nd.chess;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import softeer2nd.chess.exception.InvalidPositionException;

import java.util.ArrayList;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

class PositionTest {

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
        assertTrue(Position.getPath(new Position("a8"),new Position("a1")).equals(positions));
    }
}