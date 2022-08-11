package org.kodluyoruz;

import java.util.InputMismatchException;
import java.util.Scanner;


public class Main {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        System.out.println("Please enter your name and  select map size (1-SMALL,2-MEDIUM,3-LARGE) ");
        System.out.print("Name: ");
        String name = in.nextLine();
        System.out.print("MapSize: ");
        int select = in.nextInt();
        int index;
        switch(select){
            case 1:
                index=5;
                break;
            case 2:
                index=8;
                break;
            case 3:
                index=10;
                break;
            default:
                index=5;
                break;
        }
        SosGame game = new SosGame(name,new GameBoard(index,index));
        game.gameRun();
    }
}
