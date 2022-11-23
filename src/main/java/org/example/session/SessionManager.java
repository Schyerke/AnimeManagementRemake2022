package org.example.session;

import org.example.user.UserDatabase;
import org.example.user.DefaultUser;
import org.example.user.User;

import java.util.Scanner;

public enum SessionManager {
    INSTANCE;

    private User user;

    public static boolean isLoggedIn(){
        return INSTANCE.user != null;
    }

    public static User getUser(){
        return INSTANCE.user;
    }

    public static void setUser(User user){
        INSTANCE.user = user;
    }

    public static void logout(){
        INSTANCE.user = null;
    }

    public static void login() {
        Scanner scanner = new Scanner(System.in);
        System.out.println("Enter your username:");
        String username = scanner.nextLine();
        System.out.println("Enter your password:");
        char[] password = scanner.nextLine().toCharArray();
        User user = UserDatabase.INSTANCE.getUser(username, password);
        if(user != null){
            setUser(user);
            System.out.println("Logged in successfully!");
        } else{
            System.out.println("Invalid username or password");
        }
    }

    public static void signup() {
        Scanner scanner = new Scanner(System.in);
        System.out.println("Enter your username:");
        String username = scanner.nextLine();
        System.out.println("Enter your password:");
        char[] password = scanner.nextLine().toCharArray();
        System.out.println("Enter your email:");
        String email = scanner.nextLine();
        boolean isValid = true;
        try {
            Validator.checkUser(username, password, email);
        } catch (IllegalArgumentException e) {
            System.out.println(e.getMessage());
            isValid = false;
        }catch (Exception e) {
            e.printStackTrace();
        }
        if (isValid){
            User user = new DefaultUser(username, password, email);
            UserDatabase.INSTANCE.addUser(user);
            System.out.println("Signed up successfully!");
        } else {
            System.out.println("Failed to sign up");
        }
    }
}
