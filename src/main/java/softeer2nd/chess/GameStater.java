package softeer2nd.chess;

import java.util.Scanner;

public class GameStater {
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

        switch (command){
            case "start":
                board.printBoard();
                isContinue=true;

            case "end":
                System.out.println("게임이 종료되었습니다");
                isContinue=false;

            default:
                System.out.println("다시 입력해주세요.");
                isContinue=true;
        }

    }
}
