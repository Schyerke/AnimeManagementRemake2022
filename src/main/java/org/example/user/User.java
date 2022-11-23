package org.example.user;

import java.util.Arrays;

public abstract class User  {
    private String username;
    private char[] password;
    private String email;
    private boolean hasPermission;

    public User(String username, char[] password, String email, boolean hasPermission){
        this.username = username;
        this.password = password;
        this.email = email;
        this.hasPermission = hasPermission;
    }

    public void addManga(String mangaName, int mark) {
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public char[] getPassword() {
        return password;
    }

    public void setPassword(char[] password) {
        this.password = password;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public boolean isHasPermission() {
        return hasPermission;
    }

    public void setHasPermission(boolean hasPermission) {
        this.hasPermission = hasPermission;
    }

    @Override
    public String toString() {
        return "User{" +
                "username='" + username + '\'' +
                ", password=" + Arrays.toString(password) +
                ", email='" + email + '\'' +
                ", hasPermission=" + hasPermission +
                '}';
    }
}
