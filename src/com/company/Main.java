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

            Scanner scanner = new Scanner(System.in);
            String p ="";
            String[][] gameboard;
            String[][] gameboardEnemy;
            String temp;
            p=input.readLine();
            gameboard = ParsingGameboard.createEmptyGameboard();
            output.println(p+" "+"PS " + ParsingGameboard.parseGameboardFromStringTabToString(gameboard));
            System.out.println(p);
            temp=input.readLine();
            System.out.println("xddddd");
            System.out.println(temp);
            gameboard=ParsingGameboard.parseGameboardFromStringToStringTab(temp.split(" ")[1]);
            gameboardEnemy=ParsingGameboard.parseGameboardFromStringToStringTab(temp.split(" ")[2]);
            printGameboard(gameboard);
            printGameboard(gameboardEnemy);



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
