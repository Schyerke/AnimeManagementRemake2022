package org.example.user;

import java.util.Arrays;

public enum UserDatabase {
    INSTANCE;

    private final User[] users = new User[100];
    private int userCount = 0;

    public void addUser(User user) {
        users[userCount++] = user;
    }

    public User[] getUsers() {
        return users;
    }

    public int getUserCount() {
        return userCount;
    }

    public User getUser(String username, char[] password) {
        for (int i = 0; i < userCount; i++) {
            User user = users[i];
            if (user.getUsername().equals(username) && Arrays.equals(user.getPassword(), password)) {
                return user;
            }
        }
        return null;
    }

    public boolean checkAlreadyExists(String username, String email) {
        for (int i = 0; i < userCount; i++) {
            User user = users[i];
            if (user.getUsername().equals(username) || user.getEmail().equals(email)) {
                return true;
            }
        }
        return false;
    }
}
