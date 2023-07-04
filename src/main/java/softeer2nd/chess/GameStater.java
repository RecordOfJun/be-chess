package softeer2nd.chess;

import java.util.Scanner;

public class GameStater {
    Scanner scanner;
    Board board;


    public void playGame(){
        initialize();
        boolean isContinue=true;

        while (isContinue){
            isContinue=selectFunction(getCommand());
        }
    }

    private void initialize(){
        board=new Board();
        board.initialize();
    }

    private String getCommand(){
        System.out.print("명령어를 입력해주세요 : ");
        scanner=new Scanner(System.in);
        String command=scanner.nextLine();

        return command;
    }

    private boolean selectFunction(String command){

        switch (command){
            case "start":
                board.printBoard();
                return true;

            case "end":
                System.out.println("게임이 종료되었습니다");
                return false;

            default:
                System.out.println("다시 입력해주세요.");
                return true;
        }

    }
}
