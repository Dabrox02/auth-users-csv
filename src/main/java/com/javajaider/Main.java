package com.javajaider;

import java.io.FileNotFoundException;
import java.io.UnsupportedEncodingException;
import java.security.NoSuchAlgorithmException;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {

        Scanner input = new Scanner(System.in);
        System.out.println("Enter your username:\n");
        String username = input.nextLine();
        System.out.println("Enter your password:\n");
        String password = input.nextLine();
        try {
            String response = Auth.authUser(username, password);
            System.out.println(response);
        } catch (FileNotFoundException | NoSuchAlgorithmException | UnsupportedEncodingException e) {
            System.out.println("Error: " + e.getMessage());
        }

        input.close();

    }
}