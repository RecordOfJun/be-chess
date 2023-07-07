package softeer2nd.chess;

import softeer2nd.chess.exception.InvalidCommandException;
import softeer2nd.chess.exception.InvalidPositionException;

import java.util.Scanner;

public class GameStarter {
    private Scanner scanner;
    private Board board;

    private boolean isContinue;


    public void playGame(){
        initialize();
        isContinue=true;

        while (isContinue){
            selectFunction(getCommand());
        }
    }

    private void initialize(){
        board=new Board();
        board.initialize();
    }

    private String getCommand(){
        System.out.println("---------------------");
        System.out.print("명령어를 입력해주세요 : ");
        scanner=new Scanner(System.in);
        String command=scanner.nextLine();

        return command;
    }

    private void selectFunction(String command){

        if(command.equals("start")){
            System.out.println(board.showBoard());
            isContinue=true;

            return;
        }

        if(command.equals("end")){
            System.out.println("게임이 종료되었습니다");
            isContinue=false;

            return;
        }

        if(command.startsWith("move")){
            try{

                String[] commands=command.split(" ");
                checkMoveCommands(commands);

                String sourcePosition=commands[1];
                String targetPosition=commands[2];

                board.move(sourcePosition,targetPosition);

                System.out.println(board.showBoard());

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
        }


        System.out.println("다시 입력해주세요.");
        isContinue=true;
    }

    private void checkMoveCommands(String[] commands) throws InvalidCommandException,InvalidPositionException{

        if(commands.length != 3 || commands[0].length() != 4){
            throw new InvalidCommandException("명령의 형식이 잘못되었습니다. 다시 입력해주세요.");
        }

    }
}
