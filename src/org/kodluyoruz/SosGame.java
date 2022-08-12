package org.kodluyoruz;

import java.sql.SQLOutput;
import java.util.InputMismatchException;
import java.util.Scanner;

public class SosGame {
    Scanner in = new Scanner(System.in);
    private  double count=0.0;

    private GameBoard board;
    private String userName;

    private int userScore;
    private int compScore;

    public SosGame(String userName, GameBoard board) {
        this.board = board;
        this.userName = userName;
    }
    public double getCount() {
        return count;
    }

    public void setCount(double count) {
        this.count = count;
    }


    public int getUserScore() {
        return userScore;
    }

    public void setUserScore(int userScore) {
        this.userScore = userScore;
    }

    public int getCompScore() {
        return compScore;
    }

    public void setCompScore(int compScore) {
        this.compScore = compScore;
    }

    public String getUserName() {
        return userName;
    }

    public void setUserName(String userName) {
        this.userName = userName;
    }


    public GameBoard getBoard() {
        return board;
    }

    public void setBoard(GameBoard board) {
        this.board = board;
    }

    public void gameRun() {
        System.out.println("------Welcome to the SOS Game !! " + this.userName + " ------- ");
        System.out.println();
        this.getBoard().createBoard();
        boolean start = true;
        int playerChanceValue = ((int) (Math.random() * ((3 - 1))));
        while (start) {
            this.getBoard().displayBoard();
            switch (playerChanceValue) {
                case 1:
                    userMove();
                    compMove();
                    break;
                default:
                    compMove();
                    playerInfo();
                    this.getBoard().displayBoard();
                    userMove();
                    break;
            }
            playerInfo();

            if(this.getCount()>=Math.pow(this.board.getRow(),2)){
                if(this.getUserScore()>this.getCompScore()){
                    System.out.println("**************************************");
                    System.out.println(" Congratulations you win the game ");
                } else{
                    System.out.println("***************************************");
                    System.out.println(" Unfortunately you lose the game " );
                }
                start=false;
            }


        }

    }

    public void userMove() {
        System.out.println();
        System.out.println("First please enter the 'S' or 'O' character which you want to insert the board, than enter the row and column number ");
        boolean sameCharCheck=true;
        this.setCount(this.getCount()+1);
        String insChar="";
        while (sameCharCheck){
            System.out.print("Char (S)/(O): ");
            while (!in.hasNext("[SOso]")){
                System.out.println("Invalid char please enter (S) or (O) !! ");
                System.out.print("Char (S)/(O): ");
                in.next();
            }
            insChar = in.next().toUpperCase();
            System.out.print("Row: ");
            while (!in.hasNextInt()){
                System.out.println("Invalid character please enter a number  !! ");
                System.out.print("Row: ");
                in.next();
            }
            int row = in.nextInt();
            System.out.print("Column: ");
            while (!in.hasNextInt()){
                System.out.println("Invalid character please enter a number  !! ");
                System.out.print("Column: ");
                in.next();
            }
            int column = in.nextInt();
            if(this.board.getBoard()[row-1][column-1]!="S" && this.board.getBoard()[row-1][column-1]!="O"){
                this.board.getBoard()[row - 1][column - 1] = insChar;
                this.setUserScore(this.getUserScore()+playerScoreCalc(insChar, row, column));
                sameCharCheck=false;
            }
            else {
                System.out.println("Character which you enter exist in that location, please try to enter another row and column location");

            }
        }

    }

    public void compMove() {
        boolean sameCharCheck=true;
        this.setCount(this.getCount()+1);
        while(sameCharCheck){
            int ranCompRow = ((int) (Math.random() * (this.board.getRow())+1));
            int ranCompColumn = ((int) (Math.random() * (this.board.getColumn())+1));
            int ranChar = ((int) (Math.random() * ((3 - 1))));
            if(this.board.getBoard()[ranCompRow-1][ranCompColumn-1].equals("-")){
                this.board.getBoard()[ranCompRow-1][ranCompColumn-1] = ranChar == 1 ? "S" : "O";
                this.setCompScore(this.getCompScore()+playerScoreCalc(ranChar == 1 ? "S" : "O", ranCompRow, ranCompColumn));
                sameCharCheck=false;
            }else{
               if(this.getCount()>=Math.pow(this.board.getRow(),2)){
                   sameCharCheck=false;
               }
            }
        }


    }

    public int playerScoreCalc(String insChar, int row, int column) {
        int point = 0;
        if (insChar.equals("S")) {
            try {

                if (this.board.getBoard()[row - 1][column].equals("O")  && this.board.getBoard()[row - 1][column + 1].equals("S")) {
                    point += 1;
                }

            } catch (ArrayIndexOutOfBoundsException Ix) {
                point += 0;
            }
            try {
                if (this.board.getBoard()[row - 1][column - 2].equals("O") && this.board.getBoard()[row - 1][column - 3].equals("S")) {
                    point += 1;
                }

            } catch (ArrayIndexOutOfBoundsException ex) {
                point += 0;
            }

            try {
                if (this.board.getBoard()[row - 2][column - 1].equals("O") && this.board.getBoard()[row - 3][column - 1].equals("S")) {
                    point += 1;
                }
            } catch (ArrayIndexOutOfBoundsException cx) {
                point += 0;
            }

            try {
                if (this.board.getBoard()[row][column - 1].equals("O") && this.board.getBoard()[row + 1][column - 1].equals("S")) {
                    point += 1;
                }
            } catch (ArrayIndexOutOfBoundsException dx) {
                point += 0;
            }
            try {
                if (this.board.getBoard()[row - 2][column - 1].equals("O") && this.board.getBoard()[row - 3][column - 2].equals("S")) {
                    point += 1;

                }
            } catch (ArrayIndexOutOfBoundsException kx) {
                point += 0;
            }
            try {
                if (this.board.getBoard()[row - 2][column].equals("O") && this.board.getBoard()[row - 3][column + 1].equals("S")) {
                    point += 1;
                }
            } catch (ArrayIndexOutOfBoundsException ax) {
                point += 0;
            }
            try {
                if (this.board.getBoard()[row - 2][column - 2].equals("O") && this.board.getBoard()[row - 3][column - 3].equals("S")) {
                    point += 1;
                }
            } catch (ArrayIndexOutOfBoundsException ax) {
                point += 0;
            }

            try {
                if (this.board.getBoard()[row][column - 2].equals("O") && this.board.getBoard()[row + 1][column - 3].equals("S")) {
                    point += 1;
                }
            } catch (ArrayIndexOutOfBoundsException ax) {
                point += 0;
            }
            try {
                if (this.board.getBoard()[row][column].equals("O") && this.board.getBoard()[row + 1][column + 1].equals("S")) {
                    point += 1;
                }
            } catch (ArrayIndexOutOfBoundsException ax) {
                point += 0;
            }
        }
        if (insChar.equals("O")) {
            try {

                if (this.board.getBoard()[row - 1][column].equals("S") && this.board.getBoard()[row - 1][column - 2].equals("S")) {
                    point += 1;
                }
            } catch (ArrayIndexOutOfBoundsException ax) {
                point += 0;
            }
            try {
                if (this.board.getBoard()[row - 2][column - 1].equals("S") && this.board.getBoard()[row][column - 1].equals("S")) {
                    point += 1;
                }
            } catch (ArrayIndexOutOfBoundsException ax) {
                point += 0;
            }
            try {
                if (this.board.getBoard()[row - 2][column].equals("S") && this.board.getBoard()[row][column - 2].equals("S")) {
                    point += 1;
                }
            } catch (ArrayIndexOutOfBoundsException ax) {
                point += 0;
            }
            try {
                if (this.board.getBoard()[row - 2][column - 2].equals("S") && this.board.getBoard()[row][column].equals("S")) {
                    point += 1;
                }
            } catch (ArrayIndexOutOfBoundsException ax) {
                point += 0;
            }

        }

        return point;

    }

    public void playerInfo() {
        System.out.println();
        System.out.println("**********************************");
        System.out.println(this.userName + "'s Scores: " + this.getUserScore());
        System.out.println();
        System.out.println("Computer scores: " + this.getCompScore());
        System.out.println("**********************************");
        System.out.println();
    }
}

