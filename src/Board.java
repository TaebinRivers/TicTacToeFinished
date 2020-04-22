public class Board {
    int round = 0;
    int size = 3;
    String[][] board = new String[3][3];
    public boolean gameOver = false;
    public Board() {

        resetBoard();

    }
    //This checks every single rows and looks for two in a row and returns the last place if empty else returns -1
    public int checkRow(String token, int rowNum){

        if(board[rowNum][0].equals(token) && board[rowNum][0].equals(board[rowNum][1]) && board[rowNum][2].equals("_")){

            return 2;

        }else if(board[rowNum][0].equals(token) && board[rowNum][0].equals(board[rowNum][2]) && board[rowNum][1].equals("_")){

            return 1;

        }else if(board[rowNum][1].equals(token) && board[rowNum][1].equals(board[rowNum][2]) && board[rowNum][0].equals("_")) {

            return 0;

        }else {

            return -1;

        }

    }
    //This checks every single columns and looks for two in a row and returns the last place if empty else returns -1
    public int checkColumn(String token, int columnNum){

        if(board[0][columnNum].equals(token) && board[0][columnNum].equals(board[1][columnNum]) && board[2][columnNum].equals("_")){

            return 2;

        }else if(board[0][columnNum].equals(token) && board[0][columnNum].equals(board[2][columnNum]) && board[1][columnNum].equals("_")){

            return 1;

        }else if(board[1][columnNum].equals(token) && board[1][columnNum].equals(board[2][columnNum]) && board[0][columnNum].equals("_")) {

            return 0;

        }else {

            return -1;

        }

    }
    //checks both diagonals for a two in a row, returns the empty spot in an array
    public int[] checkDiagonal(String token){
        int[] resultArr = new int[2];
        if(board[0][0].equals(token) && board[0][0].equals(board[1][1]) && board[2][2].equals("_")) {
            resultArr[0] = 2;
            resultArr[1] = 2;
        }else if(board[1][1].equals(token) && board[1][1].equals(board[2][2]) && board[0][0].equals("_")) {
            resultArr[0] = 0;
            resultArr[1] = 0;
        }else if(board[0][0].equals(token) && board[0][0].equals(board[2][2]) && board[1][1].equals("_")) {
            resultArr[0] = 1;
            resultArr[1] = 1;
        }else if(board[0][2].equals(token) && board[0][2].equals(board[1][1]) && board[2][0].equals("_")) {
            resultArr[0] = 2;
            resultArr[1] = 0;
        }else if(board[1][1].equals(token) && board[2][0].equals(board[1][1]) && board[0][2].equals("_")) {
            resultArr[0] = 0;
            resultArr[1] = 2;
        }else if(board[0][2].equals(token) && board[0][2].equals(board[2][0]) && board[1][1].equals("_")) {
            resultArr[0] = 1;
            resultArr[1] = 1;
        } else {
            resultArr[0] = -1;
            resultArr[1] = -1;
        }
        return resultArr;
    }


    public int determineWin(String token) {

        if(board[0][0].equals(token) && board[0][0].equals(board[1][1]) && board[2][2].equals(board[0][0])) {
                return 10;
        }else if(board[0][1].equals(token) && board[0][1].equals(board[0][2]) && board[0][1].equals(board[0][0])) {
            return 10;
        }else if(board[1][0].equals(token) && board[1][0].equals(board[1][1]) && board[1][1].equals(board[1][2])) {
            return 10;
        }else if(board[2][0].equals(token) && board[2][0].equals(board[2][1]) && board[2][0].equals(board[2][2])) {
            return 10;
        }else if(board[0][0].equals(token) && board[0][0].equals(board[0][1]) && board[0][0].equals(board[0][2])) {
            return 10;
        }else if(board[1][0].equals(token) && board[1][0].equals(board[1][1]) && board[1][0].equals(board[1][2])) {
            return 10;
        }else if(board[2][0].equals(token) && board[2][0].equals(board[2][1]) && board[2][0].equals(board[2][2])) {
            return 10;
        }else if(board[0][2].equals(token) && board[0][2].equals(board[1][1]) && board[1][1].equals(board[2][0])) {
            return 10;
        }else {
            return 0;
        }

    }

    public String[][] getBoard() {
        return board;
    }

    public boolean isGameOver() {
        return gameOver;
    }



    public void printBoard() {

        for(int row = 0; row < size; row++) {

            for(int column = 0; column < size; column++) {

                System.out.print(board[row][column]+" ");

            }
            System.out.print("\n");
        }

    }
    //checks to see if there is any space left and returns true if there isn't
    public boolean checkBoard() {
        int checkcount = 0;
        if(board[0][0].equals("_")) {
            checkcount ++;
        }else if(board[0][1].equals("_")) {
            checkcount++;
        }else if(board[0][2].equals("_")) {
            checkcount++;
        }else if(board[1][0].equals("_")) {
            checkcount++;
        }else if(board[1][1].equals("_")) {
            checkcount++;
        }else if(board[1][2].equals("_")) {
            checkcount++;
        }else if(board[2][0].equals("_")) {
            checkcount++;
        }else if(board[2][2].equals("_")) {
            checkcount++;
        }else if(board[2][1].equals("_")) {
            checkcount++;
        }
        if(checkcount == 0) {

            return true;

        }else {

            return false;

        }
    }
    public void resetBoard() {
        //sets the board to be a clean board ie no spots filled

        board[0][0] = "_";
        board[0][1] = "_";
        board[0][2] = "_";
        board[1][0] = "_";
        board[1][1] = "_";
        board[1][2] = "_";
        board[2][0] = "_";
        board[2][1] = "_";
        board[2][2] = "_";

    }



    public boolean legalMove(int row, int column) {
        if(row > 3 || column > 3 || row < 0 || column < 0){

            return false;

        }else if(board[row][column].equals("_")) {

            return true;

        }else {

            return false;

        }

    }

    public boolean makeMove(int row, int column, String token) {

        if(legalMove(row,column)){

            board[row][column] = token;
            return true;
        }else{

            System.out.println("That isn't legal!");
            return false;
        }

    }
//    public void computerMove(int[] move) {
//        int row = move[0];
//        int column = move[1];
//
//        board[row][column] = "O";
//
//    }

    //uses the check column/row to find a winning move for the given token
    //returns winning move spot or -1,-1
    public int[] winningMove(String token) {
        int[] movecoord = new int[2];
        for(int i = 0; i < 3; i++) {
            if(checkDiagonal(token)[0] != -1) {

                movecoord = checkDiagonal(token);
                return movecoord;
            }
            int xvalue = checkRow(token, i);
            int yvalue = checkColumn(token,i);
            if(xvalue != -1){
                movecoord[0] = i;
                movecoord[1] = xvalue;
                return movecoord;
            }else if(yvalue != -1){

                movecoord[0] = yvalue;
                movecoord[1] = i;
                return movecoord;
            }

        }
        movecoord[0] = -1;
        movecoord[1] = -1;
//        System.out.println(movecoord[0]);
//        System.out.println(movecoord[1]);
        return movecoord;

    }

    //determines the direction of the path of the ai's movement returns middle or corner
    public int[] determineXMove(){
        int[] firstMove = new int[2];
        if(board[0][0].equals("X") || board[0][2].equals("X") || board[2][0].equals("X") || board[2][2].equals("X")) {
            firstMove[0] = 1;
            firstMove[1] = 1;
            return firstMove;

        }else {
            firstMove[0] = getCorner()[0];
            firstMove[1] = getCorner()[1];

            return firstMove;

        }

    }

    public int getRound() {
        return round;
    }
    //this gets all of the sides that are empty and returns the first one
    public int[] getSide(){
        int[] sideMove = new int[2];
        if(board[0][1].equals("_")){
            sideMove[0] = 0;
            sideMove[0] = 1;
        }else if(board[1][0].equals("_")){
            sideMove[0] = 1;
            sideMove[0] = 0;
        }else if(board[1][2].equals("_")){
            sideMove[0] = 1;
            sideMove[0] = 2;
        }else if(board[2][1].equals("_")){
            sideMove[0] = 2;
            sideMove[0] = 1;
        }else{
            sideMove[0] = -1;
            sideMove[1] = -1;
        }
        return sideMove;
    }
    public int[] getCorner(){

        int[] cornerMove = new int[2];
        if(board[0][0].equals("_")){
            cornerMove[0] = 0;
            cornerMove[0] = 0;
        }else if(board[2][2].equals("_")){
            cornerMove[0] = 2;
            cornerMove[0] = 2;
        }else if(board[2][0].equals("_")){
            cornerMove[0] = 2;
            cornerMove[0] = 0;
        }else if(board[0][2].equals("_")){
            cornerMove[0] = 0;
            cornerMove[0] = 2;
        }else{
            cornerMove[0] = -1;
            cornerMove[1] = -1;
        }
        return cornerMove;

    }
}