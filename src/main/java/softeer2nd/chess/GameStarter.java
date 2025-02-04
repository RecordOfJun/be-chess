package softeer2nd.chess;

import softeer2nd.chess.exception.*;
import softeer2nd.chess.pieces.Color;
import softeer2nd.chess.pieces.Piece;

import java.util.Scanner;

public class GameStarter {

    private Game game;

    private boolean isContinue;
    private final static int SOURCE_POSITION_INDEX = 1;
    private final static int TARGET_POSITION_INDEX = 2;
    private final static int MOVE_COMMAND_LENGTH = 3;
    private final static int MOVE_COMMAND_INDEX = 0;
    private final static String MOVE_STRING = "move";

    private final static String START_STRING = "start";
    private final static String END_STRING = "end";


    public void playGame() {
        initialize();
        isContinue = true;

        while (isContinue) {
            selectFunction(getCommand());
        }
    }

    private void initialize() {
        game = new Game();
        game.start();
        game.initBoard();
    }

    private String getCommand() {
        System.out.println("---------------------");
        System.out.print("명령어를 입력해주세요 : ");
        Scanner scanner = new Scanner(System.in);

        return scanner.nextLine();
    }

    private void selectFunction(String command) {
        if (command.equals(START_STRING)) {
            start();
            return;
        }

        if (command.equals(END_STRING)) {
            end();
            return;
        }

        if (command.startsWith(MOVE_STRING)) {
            move(command);
            return;
        }

        System.out.println("다시 입력해주세요.");
        isContinue = true;
    }

    private void start(){
        System.out.println(game.showBoard());
        isContinue = true;
    }

    private void end(){
        System.out.println("게임이 종료되었습니다");
        isContinue = false;
    }

    private void move(String command){
        try {
            String[] commands = command.split(" ");
            checkMoveCommands(commands);

            String sourcePosition = commands[SOURCE_POSITION_INDEX];
            String targetPosition = commands[TARGET_POSITION_INDEX];

            game.move(sourcePosition, targetPosition);

            System.out.println(game.showBoard());
            System.out.println("흰색 점수:" + game.calculatePoint(Color.WHITE) + " , 검은색 점수:" + game.calculatePoint(Color.BLACK));

        } catch (ChessException exception) {
            System.out.println(exception.getMessage());
            isContinue = true;
        }
    }

    private void checkMoveCommands(String[] commands) throws InvalidCommandException, InvalidPositionException {
        if (commands.length != MOVE_COMMAND_LENGTH || !commands[MOVE_COMMAND_INDEX].equals(MOVE_STRING)) {
            throw new InvalidCommandException("명령의 형식이 잘못되었습니다. 다시 입력해주세요.");
        }
    }
}
