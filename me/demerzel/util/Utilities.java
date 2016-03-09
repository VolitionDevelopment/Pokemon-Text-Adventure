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

    public static void drawMenu(String... input){
        String[] options = new String[4];

        System.arraycopy(input, 0, options, 0, input.length);

        for(int i = input.length; i < options.length; i++){
            options[i] = "-----";
        }

        int line1 = 30;
        int line2 = 30;
        int line4 = 30;

        for(int i = 0; i < line1; i++){
            System.out.print("=");
        }
        System.out.println();

        System.out.print("|");
        line2--;
        for(int i = 0; i < 6 - (options[0].length() / 2); i++){
            System.out.print(" ");
            line2--;
        }

        System.out.print(options[0]);
        line2 -= options[0].length();

        for(int i = 0; i < 6 - (options[0].length() / 2); i++){
            System.out.print(" ");
            line2--;
        }

        for(int i = 30 - line2; i < 14; i++){
            System.out.print(" ");
            line2--;
        }

        System.out.print("||");
        line2 -= 2;

        for(int i = 0; i < 6 - (options[1].length() / 2); i++){
            System.out.print(" ");
            line2--;
        }

        System.out.print(options[1]);
        line2 -= options[1].length();

        for(int i = 0; i < 6 - (options[1].length() / 2); i++){
            System.out.print(" ");
            line2--;
        }

        for(int i = 1; i < line2; i++){
            System.out.print(" ");
        }

        System.out.println("|");

        for(int i = 0; i < line1; i++){
            System.out.print("=");
        }
        System.out.println();

        System.out.print("|");
        line4--;
        for(int i = 0; i < 6 - (options[2].length() / 2); i++){
            System.out.print(" ");
            line4--;
        }

        System.out.print(options[2]);
        line4 -= options[2].length();

        for(int i = 0; i < 6 - (options[2].length() / 2); i++){
            System.out.print(" ");
            line4--;
        }

        for(int i = 30 - line4; i < 14; i++){
            System.out.print(" ");
            line4--;
        }

        System.out.print("||");
        line4 -= 2;

        for(int i = 0; i < 6 - (options[3].length() / 2); i++){
            System.out.print(" ");
            line4--;
        }

        System.out.print(options[3]);
        line4 -= options[3].length();

        for(int i = 0; i < 6 - (options[3].length() / 2); i++){
            System.out.print(" ");
            line4--;
        }

        for(int i = 1; i < line4; i++){
            System.out.print(" ");
        }

        System.out.println("|");

        for(int i = 0; i < line1; i++){
            System.out.print("=");
        }

        System.out.println();
        System.out.println();
    }
}
