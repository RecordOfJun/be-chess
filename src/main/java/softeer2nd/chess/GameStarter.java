package softeer2nd.chess;

import softeer2nd.chess.exception.InvalidCommandException;
import softeer2nd.chess.exception.InvalidDirectionException;
import softeer2nd.chess.exception.InvalidPositionException;

import java.util.Scanner;

public class GameStarter {
    private Scanner scanner;

    private Game game;

    private boolean isContinue;

    private final static int SOURCE_POSITION_INDEX=1;
    private final static int TARGET_POSITION_INDEX=2;
    private final static int MOVE_COMMAND_LENGTH=3;
    private final static int MOVE_COMMAND_INDEX=0;
    private final static String MOVE_STRING="move";

    private final static String START_STRING="start";
    private final static String END_STRING="end";


    public void playGame(){
        initialize();
        isContinue=true;

        while (isContinue){
            selectFunction(getCommand());
        }
    }

    private void initialize(){
        game=new Game();
        game.start();
    }

    private String getCommand(){
        System.out.println("---------------------");
        System.out.print("명령어를 입력해주세요 : ");
        scanner=new Scanner(System.in);
        String command=scanner.nextLine();

        return command;
    }

    private void selectFunction(String command){

        if(command.equals(START_STRING)){
            System.out.println(game.showBoard());
            isContinue=true;

            return;
        }

        if(command.equals(END_STRING)){
            System.out.println("게임이 종료되었습니다");
            isContinue=false;

            return;
        }

        if(command.startsWith(MOVE_STRING)){
            try{

                String[] commands=command.split(" ");
                checkMoveCommands(commands);

                String sourcePosition=commands[SOURCE_POSITION_INDEX];
                String targetPosition=commands[TARGET_POSITION_INDEX];

                game.move(sourcePosition,targetPosition);

                System.out.println(game.showBoard());

                return;
            }
            catch (InvalidCommandException exception){
                System.out.println(exception.getMessage());
                isContinue=true;
                return;
            }
            catch (InvalidPositionException exception){
                System.out.println(exception.getMessage());
                isContinue=true;
                return;
            }
            catch (InvalidDirectionException exception){
                System.out.println(exception.getMessage());
                isContinue=true;
                return;
            }
        }


        System.out.println("다시 입력해주세요.");
        isContinue=true;
    }

    private void checkMoveCommands(String[] commands) throws InvalidCommandException,InvalidPositionException{

        if(commands.length != MOVE_COMMAND_LENGTH || !commands[MOVE_COMMAND_INDEX].equals(MOVE_STRING)){
            throw new InvalidCommandException("명령의 형식이 잘못되었습니다. 다시 입력해주세요.");
        }

    }
}
