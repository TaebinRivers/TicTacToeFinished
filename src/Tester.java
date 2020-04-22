public class Tester {
    int round = 10;


    public static void main(String[] args) {
        Board test = new Board();

        test.board[0][0] = "O";
        test.board[0][1] = "_";
        test.board[0][2] = "_";
        test.board[1][0] = "_";
        test.board[1][1] = "X";
        test.board[1][2] = "_";
        test.board[2][0] = "_";
        test.board[2][1] = "X";
        test.board[2][2] = "_";

        //checks the winning move and blocks
        System.out.println(test.legalMove(0,1));

        System.out.println(test.winningMove("X")[0]);
        System.out.println(test.winningMove("X")[1]);

        test.makeMove(test.winningMove("X")[0],test.winningMove("X")[1],"O");
        test.printBoard();
//        if(test.winningMove("X")[0] != -1){
//
//            System.out.println("This works!");
//
//        }
//        test.makeMove(test.winningMove("X")[1],test.winningMove("X")[0],"O");
//        test.printBoard();
//

//
        //This is option 0 (x in the corner)

//        test.makeMove(1,1,"O");
//
//        if(test.winningMove("O")[0] != -1 && test.winningMove("O")[1] != -1) {
//
//            System.out.println("The computer has won");
//            test.makeMove(test.winningMove("O")[1],test.winningMove("O")[0],"O");
//
//        } else if(test.winningMove("X")[0] != -1 && test.winningMove("X")[0] != -1) {
//            System.out.println("You have been Blocked");
//
//            test.makeMove(test.winningMove("X")[1],test.winningMove("X")[0],"O");
//        } else {
//
//            System.out.println("The computer took the side");
//
//            test.makeMove(test.getSide()[0],test.getSide()[1],"O");
//        }
//        test.printBoard();

//        int testcounter = 0;
//        int AIPath = 0;
//        while (testcounter < 5) {
//
//            if (AIPath == 0) {
//                int[] firstMove = test.determineXMove();
//                test.makeMove(firstMove[0], firstMove[1], "O");
//                if (firstMove[1] == 1 && firstMove[0] == 1) {
//                    AIPath = 1;
//                    System.out.println(AIPath);
//                } else {
//                    AIPath = 2;
//                    System.out.println(AIPath);
//                }
//            } else if (AIPath == 1 && testcounter != 0) {
//
//                if (test.winningMove("O")[0] != -1 && test.winningMove("O")[1] != -1) {
//
//                    System.out.println("The computer has won");
//                    test.makeMove(test.winningMove("O")[1], test.winningMove("O")[0], "O");
//                    testcounter = 10;
//
//                } else if (test.winningMove("X")[0] != -1 && test.winningMove("X")[0] != -1) {
//                    System.out.println("You have been Blocked");
//
//                    test.makeMove(test.winningMove("X")[1], test.winningMove("X")[0], "O");
//                } else {
//
//                    System.out.println("The computer took the side");
//
//                    test.makeMove(test.getSide()[0], test.getSide()[1], "O");
//                }
//
//            } else if (AIPath == 2 && testcounter != 0){
//
////
////
//                if (test.winningMove("O")[0] != -1 && test.winningMove("O")[1] != -1) {
//
//                    System.out.println("The computer has won");
//                    test.makeMove(test.winningMove("O")[1], test.winningMove("O")[0], "O");
//                    testcounter = 10;
//
//                } else if (test.winningMove("X")[0] != -1 && test.winningMove("X")[0] != -1) {
//                    System.out.println("You have been Blocked");
//
//                    test.makeMove(test.winningMove("X")[1], test.winningMove("X")[0], "O");
//
//                } else if (test.getCorner()[0] != -1) {
//
//                    System.out.println("corner");
//                    test.makeMove(test.getCorner()[0], test.getCorner()[1], "O");
//
//                } else {
//
//                    System.out.println("side");
//                    test.makeMove(test.getSide()[0], test.getSide()[1], "O");
//
//                }
//
//
//            }
//            test.printBoard();
//            testcounter++;
//
//        }


    }
}
