package org.example.session;

import org.example.user.UserDatabase;
import org.example.user.DefaultUser;
import org.example.user.User;

import java.util.Scanner;

public enum SessionManager {
    INSTANCE;

    private User user;

    public boolean isLoggedIn(){
        return this.user != null;
    }

    public User getUser(){
        return this.user;
    }

    public void setUser(User user){
        this.user = user;
    }

    public void logout(){
        INSTANCE.user = null;
    }

    public void login() {
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

    public void signup() {
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
