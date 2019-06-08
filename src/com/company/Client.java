package com.company;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.net.Socket;

public class Client {


    String[][] gameboard;
    String[][] gameboardEnemy;


    public void start(){

        try (Socket socket = new Socket("localhost", 5000)) {
            BufferedReader input = new BufferedReader(new InputStreamReader(socket.getInputStream()));// strig odebrany z serwera
            PrintWriter output = new PrintWriter(socket.getOutputStream(), true); // string wsłany do serwera

            Game game = new Game();
            String p;

            String temp;
            p=input.readLine();
            gameboard = ParsingGameboard.createEmptyGameboard();
            gameboard = game.placingShips(gameboard);
            output.println(p+" "+"PS " + ParsingGameboard.parseGameboardFromStringTabToString(gameboard));
            System.out.println(p);
            temp=input.readLine();
            parseAndPrint(temp);
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
                        parseAndPrint(temp);
                        System.out.println();
                    }

                }
                if(temp.equals("Zaczekaj aż przeciwnik ustawi Statki")){
                    System.out.println(temp);
                }
                if(temp.equals("Tura Przeciwnika")){
                    temp = input.readLine();
                    parseAndPrint(temp);
                    System.out.println("Tura Przeciwnika");
                }
            }



        } catch (IOException e) {
            System.out.println("Client error!!!!!1");
        }
    }

    public void parseAndPrint(String temp){
        gameboard=ParsingGameboard.parseGameboardFromStringToStringTab(temp.split(" ")[1]);
        gameboardEnemy=ParsingGameboard.parseGameboardFromStringToStringTab(temp.split(" ")[2]);
        System.out.println("TWOJE STATKI:");
        ParsingGameboard.printGameboard(gameboard);
        System.out.println("TWOJE STRZAŁY:");
        ParsingGameboard.printGameboard(gameboardEnemy);
        System.out.println();
    }

}
