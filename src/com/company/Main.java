package com.company;
import java.io.IOException;
import java.io.File;
import java.util.ArrayList;
import java.util.regex.Matcher;
import java.util.regex.Pattern;
import java.util.Scanner;


public class Main {

    private static File file = new File("LoginFile.txt");

    public static void main(String[] args) {
        createFile();
        ConfirmLogin();
        //Leaderboard();
        String Email = "moo@gmail.com";
        System.out.println(ValidateEmail(Email));
    }

    public static void createFile(){

        try {
            if (file.createNewFile()) {
                System.out.println("File created: " + file.getName());
            } else {
                System.out.println("File already exists.");
            }
        } catch (IOException e) {
            System.out.println("An error occurred.");
            e.printStackTrace();


}
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
        boolean userValid = false;
        boolean passwordValid = false;
        try {

            Scanner x = new Scanner(file);
            while (x.hasNextLine()) {
                String data = x.nextLine();
                String[] yes = data.split(",");
                for (int i = 0; i < yes.length; i++) {
                    String userOrPass = yes[i];
                    if (i == 0) {
                        if (username.equals(userOrPass)) userValid = true;
                    } else {
                        if (password.equals(userOrPass)) passwordValid = true;
                    }
                }
            }
            x.close();
        } catch (Exception e) {
            System.out.println("An error occurred while logging in");
            e.printStackTrace();
        }

        if (!userValid || !passwordValid) {
            System.out.println("Not valid");
        } else System.out.println("Valid");
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


