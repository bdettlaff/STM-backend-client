package com.company;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.net.Socket;
import java.util.Scanner;

public class Main {

    public static void main(String[] args) {

        try (Socket socket = new Socket("localhost", 5000)) {
            BufferedReader input = new BufferedReader(new InputStreamReader(socket.getInputStream()));// strig odebrany z serwera
            PrintWriter output = new PrintWriter(socket.getOutputStream(), true); // string wsłany do serwera

            Game game = new Game();
            String p ="";
            String[][] gameboard;
            String[][] gameboardEnemy;
            String temp;
            p=input.readLine();
            gameboard = ParsingGameboard.createEmptyGameboard();
            gameboard = game.placingShips(gameboard);
            output.println(p+" "+"PS " + ParsingGameboard.parseGameboardFromStringTabToString(gameboard));
            System.out.println(p);
            temp=input.readLine();
            gameboard=ParsingGameboard.parseGameboardFromStringToStringTab(temp.split(" ")[1]);
            gameboardEnemy=ParsingGameboard.parseGameboardFromStringToStringTab(temp.split(" ")[2]);
            System.out.println("TWOJE STATKI:");
            printGameboard(gameboard);
            System.out.println("TWOJE STRZAŁY:");
            printGameboard(gameboardEnemy);
            System.out.println();
            while(true) {
                temp=input.readLine();
                if(temp.equals("Lost")){
                    System.out.println(temp);
                    break;
                }
                if (temp.equals("Twoja Tura")) {
                    System.out.println(temp);
                    String shot = game.shot();
                    output.println(p + " " + "SH" + " " + shot);
                    temp = input.readLine();
                    if (temp.equals("Błędny strzał") || temp.equals("Win")) {
                        System.out.println(temp);
                        break;
                    } else {
                        gameboard = ParsingGameboard.parseGameboardFromStringToStringTab(temp.split(" ")[1]);
                        gameboardEnemy = ParsingGameboard.parseGameboardFromStringToStringTab(temp.split(" ")[2]);
                        System.out.println("TWOJE STATKI:");
                        printGameboard(gameboard);
                        System.out.println("TWOJE STRZAŁY:");
                        printGameboard(gameboardEnemy);
                        System.out.println();
                    }

                }
                else{
                    System.out.println("Tura Przeciwnika");
                }
            }



        } catch (IOException e) {
            System.out.println("Client error!!!!!1");
        }
    }

    public static void printGameboard(String[][] gameboard) {
        System.out.println("  0 1 2 3 4 5 6 7 8 9");
        for (int i = 0; i < 10; i++) {
            System.out.print(i+" ");
            for (int j = 0; j < 10; j++) {


                    System.out.print(gameboard[i][j]+" ");

            }
            System.out.println();

        }
        System.out.println();
    }
}
