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
            BufferedReader echoes = new BufferedReader(new InputStreamReader(socket.getInputStream()));// strig odebrany z serwera
            PrintWriter stringToEcho = new PrintWriter(socket.getOutputStream(), true); // string wsłany do serwera

            Scanner scanner = new Scanner(System.in);
            String echoString; // treść wysyłana serwerowif
            String response; // odpowiedx z serwera

            //do {

                int[][]gameboard = Game.createEmptyGameboard();
                echoString=ParsingGameboard.parseGameboardFromIntToString(gameboard);

                stringToEcho.println(echoString);
                if (!echoString.equals("exit")) {
                    response = echoes.readLine();
                    System.out.println(response);
                }

            //}
            //while (!echoString.equals("exit"));

        } catch (IOException e) {
            System.out.println("Client error!!!!!1");
        }
    }
}
