package com.company;

import java.*;
import java.io.File;
import java.util.regex.Matcher;
import java.util.regex.Pattern;
import java.util.Scanner;


public class Main {


    public static void main(String[] args) {
        File file = new File("LoginFile.txt");
        ConfirmLogin();
        VerifyLogin();
        Leaderboard();
        //Register();
        String Email = "moo@gmail.com";
        System.out.println(ValidateEmail(Email));
    }


    public static boolean ValidateEmail(String input) {
        String EmailRegex = "^[A-Z0-9._%+-]+@[A-Z0-9.-]+\\.[A-Z]{2,6}$";
        Pattern EmailPattern = Pattern.compile(EmailRegex, Pattern.CASE_INSENSITIVE);
        Matcher matcher = EmailPattern.matcher(input);
        return matcher.find();

    }

    public static void ConfirmLogin() {

        System.out.println("Would you like to login or register?");
        Scanner input = new Scanner(System.in);
        while (true) {
            String userInput = input.nextLine();
            if (userInput.equals("login")) {
                VerifyLogin();
                break;

            }
            if (userInput.equals("register")) {
                //Register();
                break;

            } else {
                System.out.println("Error");
            }
        }
    }


    public static void VerifyLogin() {

        Scanner Login = new Scanner(System.in);
        System.out.println("Enter your username: ");
        String username = Login.next();
        System.out.println("Enter your password: ");
        String password = Login.next();
        String filepath = "LoginFile.txt";

        boolean found = false;
        String tempUsername = "";
        String tempPassword = "";

        try {

            Scanner x = new Scanner(new File(filepath));
            x.useDelimiter("[,\n]");

            tempUsername = x.next();
            tempPassword = x.next();

            while (x.hasNext() || !found) {


                if (tempUsername.trim().equals(username.trim()) && tempPassword.trim().equals(password.trim())) {

                    found = true;
                }
            }
            x.close();

        } catch (Exception e) {
            System.out.println("An error occurred while logging in");
        }
    }




//    public static void Register() {
//
//        Scanner register = new Scanner(System.in);
//        System.out.println("Enter your name");
//        String username = register.next();
//        System.out.println("Please enter your password");
//        String password = register.next();
//        File file = new File("LoginFile.txt");
//        String userName = (username);
//        FileWriter writer = null;
//        try {
//            writer = new FileWriter("LoginFile.txt", true);
//            BufferedWriter bw = new BufferedWriter(writer);
//            writer.write(userName + password);
//            writer.close();
//            System.out.println("Successfully registered to the library, hello " + username);
//        } catch (IOException e) {
//            e.printStackTrace();
//        }
//    }
    }
}

