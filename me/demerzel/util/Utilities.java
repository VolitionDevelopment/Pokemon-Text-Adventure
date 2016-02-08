package me.demerzel.util;

import java.util.Scanner;

/**
 * Created by Demerzel on 2/7/16.
 */
public class Utilities {
    public static String getUserInput(String output){
        Scanner scanner = new Scanner(System.in);
        System.out.println(output);
        return scanner.nextLine();
    }
}
