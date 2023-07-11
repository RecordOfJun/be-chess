package softeer2nd.chess.utils;

import softeer2nd.chess.exception.InvalidPositionException;

import java.util.HashMap;
import java.util.Map;

public class PositionUtils {

    public static HashMap<String,Integer> getRowAndCol(String position) throws InvalidPositionException{
        if(position.length() != 2){
            throw new InvalidPositionException("좌표 형식에 맞지 않습니다!");
        }

        if(position.charAt(0) < 'a' || position.charAt(0) > 'h' || position.charAt(1) < '1' || position.charAt(1) > '8'){
            throw new InvalidPositionException("보드의 범위를 벗어난 좌표입니다!");
        }

        HashMap<String,Integer> rowAndCol=new HashMap<String,Integer>(2);

        Integer column=position.charAt(0) - 'a';
        Integer row= '8' - position.charAt(1);

        rowAndCol.put("column",column);
        rowAndCol.put("row", row);

        return rowAndCol;
    }

    public static HashMap<String,Integer> getDirection(String sourcePosition, String targetPosition) throws InvalidPositionException{
        Map<String,Integer> sourceRowAndCol=getRowAndCol(sourcePosition);
        Map<String,Integer> targetRowAndCol=getRowAndCol(targetPosition);

        HashMap<String,Integer> direction=new HashMap<String,Integer>(2);

        direction.put("xDegree",targetRowAndCol.get("column")-sourceRowAndCol.get("column"));
        direction.put("yDegree",sourceRowAndCol.get("row")-targetRowAndCol.get("row"));

        return direction;
    }
}
