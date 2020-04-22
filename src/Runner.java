import java.util.Scanner;


public class Runner {

    public static void main(String[] args) {

        Scanner scanner = new Scanner(System.in);
        System.out.println("Please enter your name: ");
        String playerName = scanner.next();
        Human p = new Human(playerName,"X");
        Computer c = new Computer("O");
        Board b = new Board();
        b.resetBoard();
        boolean gameOver = b.isGameOver();
        int roundCounter = b.round;
        int AIPath = 0;
        int counter = 0;
        while (counter < 10) {
            //player moves
            b.printBoard();
            System.out.println("Please choose a row: ");
            int playerMoveX = scanner.nextInt();
            System.out.println("Please choose a column: ");
            int playerMoveY = scanner.nextInt();

            while(b.makeMove(playerMoveX,playerMoveY, "X") == false) {

                System.out.println("Please choose a row: ");
                playerMoveX = scanner.nextInt();
                System.out.println("Please choose a column: ");
                playerMoveY = scanner.nextInt();



            }
            if(b.determineWin("X") == 10) {

                System.out.println("YOU win!!!!");
                counter = 10;

            }else if(b.determineWin("O") == 10) {

                System.out.println("You lose.");
                counter = 10;

            }
            if(b.checkBoard()) {

                System.out.println("Tie game!");
                counter = 10;

            }



            //First turn
            if (AIPath == 0) {
                int[] firstMove = b.determineXMove();
                b.makeMove(firstMove[0], firstMove[1], "O");
                System.out.println("First move");
                if (firstMove[1] == 1 && firstMove[0] == 1) {
                    AIPath = 1;
                    System.out.println(AIPath);
                } else {
                    AIPath = 2;
                    System.out.println(AIPath);
                }
            } else if (AIPath == 1 && counter != 0) {
            //second turn if x went corner
                if (b.winningMove("O")[0] != -1 && b.winningMove("O")[1] != -1) {


                    b.makeMove(b.winningMove("O")[0], b.winningMove("O")[1], "O");
                    System.out.println("The computer has won");
                    b.printBoard();

                    counter = 10;

                } else if (b.winningMove("X")[0] != -1 && b.winningMove("X")[0] != -1) {


                    b.makeMove(b.winningMove("X")[0], b.winningMove("X")[1], "O");
                    System.out.println("You have been Blocked");

                } else {


                    b.makeMove(b.getSide()[0], b.getSide()[1], "O");
                    System.out.println("The computer took the side");
                }

            } else if (AIPath == 2 && counter != 0){
            //second move if x went non-corner
//
//
                if (b.winningMove("O")[0] != -1 && b.winningMove("O")[1] != -1) {


                    b.makeMove(b.winningMove("O")[0], b.winningMove("O")[1], "O");
                    System.out.println("The computer has won");
                    b.printBoard();

                    counter = 10;

                } else if (b.winningMove("X")[0] != -1 && b.winningMove("X")[0] != -1) {


                    b.makeMove(b.winningMove("X")[0], b.winningMove("X")[1], "O");
                    System.out.println("You have been Blocked");

                } else if (b.getCorner()[0] != -1) {

                    b.makeMove(b.getCorner()[0], b.getCorner()[1], "O");
                    System.out.println("corner");


                } else {
                    if(counter < 10){
                        b.makeMove(b.getSide()[0], b.getSide()[1], "O");
                        System.out.println("side");
                    }



                }


            }


            counter++;


        }
    }

}