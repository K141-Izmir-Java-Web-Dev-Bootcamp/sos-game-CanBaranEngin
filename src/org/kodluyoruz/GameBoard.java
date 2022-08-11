package org.kodluyoruz;

public class GameBoard {
    private String[][] board;
    private int row;
    private int column;

    public GameBoard(int row, int column) {
        this.row = row;
        this.column = column;
    }

    public int getRow() {
        return row;
    }

    public void setRow(int row) {
        this.row = row;
    }


    public int getColumn() {
        return column;
    }

    public void setColumn(int column) {
        this.column = column;
    }

    public String[][] getBoard() {
        return board;
    }

    public void setBoard(String[][] board) {
        this.board = board;
    }

    public void createBoard(){
        board = new String[this.getRow()][this.getColumn()];
        for(int i=0;i<this.getRow();i++){
            for(int j=0;j<this.getColumn();j++){
                board[i][j]="-";
            }
        }

    }
    public void displayBoard() {

        for(int s=0; s < this.getRow(); s++) {
            System.out.print(s+1);
            for(int k=0; k <this.getColumn(); k++) {
                System.out.print("\t" + board[s][k]);
            }
            System.out.println();
        }
        for(int i =0; i<this.getRow();i++){
            System.out.print("\t"+(i+1));
        }
        System.out.println();
        System.out.println();
        System.out.println("**********************************");
        System.out.println();
    }
}
