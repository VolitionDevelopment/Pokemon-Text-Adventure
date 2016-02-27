package me.demerzel.util;

import java.util.Scanner;

/**
 * Created by Demerzel on 2/7/16.
 */
public class Utilities {
    public static String getUserInput(String output){
        Scanner scanner = new Scanner(System.in);
        System.out.print(output);
        return scanner.nextLine();
    }

    public static void drawMenu(String... options){
        int lineSize = 30;

        for(int i = 0; i < lineSize; i++){
            System.out.print("=");
        }
        System.out.println();

        System.out.print("|");
        for(int i = 0; i < 6 - (options[0].length() / 2); i++){
            System.out.print(" ");
        }

        System.out.print(options[0]);

        for(int i = 0; i < 6 - (options[0].length() / 2); i++){
            System.out.print(" ");
        }

        System.out.print("||");

        for(int i = 0; i < 6 - (options[1].length() / 2); i++){
            System.out.print(" ");
        }

        System.out.print(options[1]);

        for(int i = 0; i < 6 - (options[1].length() / 2); i++){
            System.out.print(" ");
        }

        System.out.println("|");

        for(int i = 0; i < lineSize; i++){
            System.out.print("=");
        }
        System.out.println();

        System.out.print("|");
        for(int i = 0; i < 6 - (options[2].length() / 2); i++){
            System.out.print(" ");
        }

        System.out.print(options[2]);

        for(int i = 0; i < 6 - (options[2].length() / 2); i++){
            System.out.print(" ");
        }

        System.out.print("||");

        for(int i = 0; i < 6 - (options[3].length() / 2); i++){
            System.out.print(" ");
        }

        System.out.print(options[3]);

        for(int i = 0; i < 6 - (options[3].length() / 2); i++){
            System.out.print(" ");
        }

        System.out.println("|");

        for(int i = 0; i < lineSize; i++){
            System.out.print("=");
        }

        System.out.println();
        System.out.println();
    }
}
