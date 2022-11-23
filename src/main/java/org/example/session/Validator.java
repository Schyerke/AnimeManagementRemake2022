package org.example.session;

import org.example.user.UserDatabase;

public class Validator {
    private Validator() {
    }
    public static boolean isUsernameValid(String username) {
        return username.matches("^[a-zA-Z0-9_-]{3,15}$");
    }

    public static boolean isPasswordValid(char[] password) {
        return String.valueOf(password).matches("^[a-zA-Z0-9_-]$");
    }

    public static boolean isEmailValid(String email) {
        return email.matches("^[A-Za-z0-9+_.-]+@(.+)$");
    }

    public static void checkUser(String username, char[] password, String email) {
        if (!isUsernameValid(username)) {
            throw new IllegalArgumentException("Username is not valid");
        }
        if (!isPasswordValid(password)) {
            throw new IllegalArgumentException("Password is not valid");
        }
        if (!isEmailValid(email)) {
            throw new IllegalArgumentException("Email is not valid");
        }
        if (UserDatabase.INSTANCE.checkAlreadyExists(username, email)) {
            throw new IllegalArgumentException("Username or email already exists");
        }
    }
}
