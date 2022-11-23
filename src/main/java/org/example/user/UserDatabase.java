package org.example.user;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public enum UserDatabase {
    INSTANCE;

    private final List<User> users = new ArrayList<>();

    public void addUser(User user) {
        if(findByUsername(user.getUsername()) != null){
            throw new IllegalArgumentException("User already in database");
        }
        users.add(user);
    }

    public User findByUsername(String username){
        return users.stream()
                .filter(user -> user.getUsername().equals(username))
                .findFirst()
                .orElse(null);
    }

    public List<User> getUsers() {
        return users;
    }

    public User getUser(String username, char[] password) {
        return users.stream()
                .filter(user -> user.getUsername().equals(username) && Arrays.equals(user.getPassword(), password))
                .findFirst()
                .orElse(null);
    }

    public boolean checkAlreadyExists(String username, String email) {
        return users.stream()
                .anyMatch(user -> user.getUsername().equals(username) || user.getEmail().equals(email));
    }
}
