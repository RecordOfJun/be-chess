package softeer2nd.chess.utils;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import softeer2nd.chess.exception.InvalidPositionException;

import java.util.Map;

import static org.junit.jupiter.api.Assertions.*;

class PositionUtilsTest {

    @Test
    @DisplayName("source와 target을 받으면 x,y차이 값을 Map형식으로 리턴 해줘야한다")
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
        Map<String, Integer> degree=PositionUtils.getDirection(sourcePosition, targetPosition);

        assertEquals(xDegree,degree.get("xDegree"));
        assertEquals(yDegree,degree.get("yDegree"));

    }

}